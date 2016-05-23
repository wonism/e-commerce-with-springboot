package jpa.repository;

import static jpa.model.QDept.dept;
import static jpa.model.QEmp.emp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPADeleteClause;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAUpdateClause;

import jpa.model.Emp;
import jpa.model.QEmp;

// 사용자정의인터페이스 구현
// QueryDSL용 인터페이스 구현
@Repository
public class EmpRepositoryImpl implements EmpRepositoryCustom {

	@PersistenceContext
	EntityManager em;

	////////////////////////////////// NamedQuery 처리 메소드
	// Emp엔티티에서 정의된 NamedQuery 사용
	public List<Emp> findBySalNamed(Long sal) { 
		List<Emp> result = em.createNamedQuery("Emp.findBySalNamed", Emp.class)
                .setParameter("sal", 2000L)
                .getResultList();
		
		return result;
	}
	
	////////////////////////////////// QueryDSL용 메소드
	@Override
	/* Emp 테이블에서 job을 조건으로 검색, 이름 내림차순으로 */
	public List<Emp> selectByJobOrderByEnameDesc(String job) {
		JPAQuery<?> query = new JPAQuery<Void>(em);		
		List<Emp> emps = query.select(emp).from(emp)
				              .where(emp.job.eq(job))
				              .orderBy(emp.ename.desc()).fetch();
		return emps;
	}

	@Override
	@Transactional
	/* job을 입력받아 EMP 삭제 */
	public Long deleteByJob(String job) {
		Long affedtedRow = new JPADeleteClause(em, emp)
		    .where(emp.job.eq(job))
		    .execute();	
		return affedtedRow;
	}

	/* 사번과 새이름을 입력받아 이름을 변경 */
	@Override
	@Transactional
	public Long updateByEmpno(Long empno, String newEname) {
		Long affedtedRow = new JPAUpdateClause(em, emp)
		.where(emp.empno.eq(empno))
		.set(emp.ename, newEname)
		.execute();		
		
		return affedtedRow;
	}

	/* job을 검색조건으로 ename, job 추출 */
	@Override
	public List<Tuple> selectEnameJobByEmpno(Long empno) {
		JPAQuery<?> query = new JPAQuery<Void>(em);

		//Multi Column Select
	    List<Tuple> result = query.select(emp.ename, emp.job)
	    		             .from(emp)
	    		             .where(emp.empno.eq(empno))
	    		             .fetch();
	    
		return result;
	}

	/* Emp, Dept를 조인하여 입력받은 부서의 사원명,부서명을 추출하는데 부서코드가 
	없는 사원은 추출되지 않는다 */
	@Override
	public List<Tuple> selectEmpEnameDnameJoinDept(Long deptno) {
		JPAQuery<?> query = new JPAQuery<Void>(em);
		
		List<Tuple> emps = query.select(emp.ename, dept.dname).from(emp)
				.innerJoin(emp.dept, dept)
				.where(emp.dept.deptno.eq(deptno))
				.fetch();
		
		return emps;
	}

	/* Emp 테이블에서 최대급여 사원 추출, 서브쿼리 */
	@Override
	public List<Emp> selectEmpMaxSal() {
		JPAQuery<?> query = new JPAQuery<Void>(em);
		QEmp e = new QEmp("e");
		
		List<Emp> emps = query.select(emp).from(emp)
				.where(emp.sal.eq(
						JPAExpressions.select(e.sal.max()).from(e)))
				.fetch();		
		
		return emps;
	}

	/* 부서별 최대급여받는 사원 추출 , 서브쿼리 */
	@Override
	public List<Emp> selectEmpMaxSalOfDept() {
		JPAQuery<?> query = new JPAQuery<Void>(em);	
		QEmp e = new QEmp("e"); 
		
		List<Emp> emps = query.select(emp).from(emp)
				         .where(emp.sal.eq(
						 JPAExpressions
						      .select(e.sal.max()).from(e)						
						      .where(emp.dept.deptno.eq(e.dept.deptno))
						))						
				.fetch();	
		
		return emps;
	}

	/* 자신이 속한 부서의 평균급여보다 급여가 많은 사원추출 ,서브쿼리 */
	@Override
	public List<Emp> selectEmpGreaterThanAvgSal() {
		JPAQuery<?> query = new JPAQuery<Void>(em);	
		QEmp e = new QEmp("e"); 
		
		List<Emp> emps = query.select(emp).from(emp)
				.where(emp.sal.gt(
						 JPAExpressions
						      .select(e.sal.avg()).from(e)						
						      .where(emp.dept.deptno.eq(e.dept.deptno))
						))						
				.fetch();	
		
		return emps;
	}
	
	/* 입력받은 사원과 급여가 같은 사원추출 , 서브쿼리 */
	/* 입력받은 사원은 출력안함                       */
	@Override
	public List<Emp> selectEmpEqualsEmpno(Long empno) {
		JPAQuery<?> query = new JPAQuery<Void>(em);	
		QEmp e = new QEmp("e"); 
		
		List<Emp> emps = query.select(emp).from(emp)
				.where(emp.sal.eq(
						 JPAExpressions
						      .select(e.sal).from(e)						
						      .where(e.empno.eq(empno))
						))	
				.where(emp.empno.ne(empno))
				.fetch();	
		
		return emps;
	}

	/* Emp 테이블에서 급여상위 3명 추출 , 서브쿼리 */
	@Override
	public List<Emp> selectEmpMaxSalTop3() {

		JPAQuery<?> query = new JPAQuery<Void>(em);	
		
		List<Emp> emps = query.select(emp).from(emp)
				.orderBy(emp.sal.desc())
				.limit(3)
				.fetch();	
		
		return emps;
	}

	/* Dept 테이블에서 사원이 한명이라도 존재하는 부서명추출, 서브쿼리 */
	@Override
	public List<String> selectDeptExistsEmp() {
		JPAQuery<?> query = new JPAQuery<Void>(em);	
		 
		List<String> depts = query.select(dept.dname).from(dept)
				.where(JPAExpressions
					      .selectFrom(emp)						
					      .where(emp.dept.deptno.eq(dept.deptno)).exists()
	             )
				.fetch();	
		
		return depts;
	}	
}
