package jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.querydsl.core.Tuple;

import jpa.model.Emp;
import jpa.repository.EmpRepository;
import jpa.repository.EmpRepositoryQuery;

@Service("empService")
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpRepository empRepository;
	
	@Autowired
	private EmpRepositoryQuery empRepositoryQuery;

    ////////////////////////// JpaRepository 기본 CRUD 메소드
	@Override
	public List<Emp> findAll() {
		//JpaRepository기본 메소드
		return empRepository.findAll();		
	}

	@Override
	public void saveEmp(Emp emp) {
		//JpaRepository기본 메소드
		empRepository.save(emp);  
	}

	@Override
	public Emp findOne(Long empno) {	
		//JpaRepository기본 메소드
		return empRepository.findOne(empno); 
	}

	@Override
	public void delete(Long empno) {
		//JpaRepository기본 메소드
		empRepository.delete(empno);
	}
	
	//////////////// EmpRepository에 만든 메소드(NamedQuery 호출)
	@Override
	public List<Emp> findBySalNamed(Long sal) {		
		return empRepository.findBySalNamed(sal);
	}
	
	//////////////// EmpRepository에 만든 메소드(페이지처리용 Query Method 호출)
	/* 입력받은 sal값보다 크거나 같은사원 추출, 페이징 처리 */
	/* Query Method 호출                             */
	@Override 
	public Page<Emp> getEmpBySalGreaterThan(Long sal, Integer pageSize, Integer pageNumber) {
        PageRequest request = new PageRequest(pageNumber - 1, pageSize, Sort.Direction.DESC, "ename");
        return empRepository.findBySalGreaterThan(sal, request);  //1000:sal
    }
	
	/* 급여로 조회하는데 이름내림차순으로 처음3건만 추출 */
	/* Query Method 호출                             */
	@Override
	public List<Emp> findFirst3BySalBetweenOrderByEnameDesc(Long sal1, Long sal2) {		
		return empRepository.findFirst3BySalBetweenOrderByEnameDesc(sal1, sal2);
	}

	/////////////////////////////////////// @Query 메소드
	@Override
	public List<Emp> findByEname(String ename) {
		return empRepositoryQuery.findByEname(ename);
	}	

	@Override
	public List<Emp> findBySalRange(Long sal1, Long sal2) {
		return empRepositoryQuery.findBySalRange(sal1, sal2);
	}

	@Override
	public List<Emp> findByEnameMatch(String ename) {
		return empRepositoryQuery.findByEnameMatch(ename);
	}

	@Override
	public List<Emp> findByNamedParam(String ename, String job, Long sal) {
		return empRepositoryQuery.findByNamedParam(ename, job, sal);
	}

	@Override
	public List<Emp> findBySalCustom(Long sal) {
		return empRepositoryQuery.findBySalCustom(sal);
	}

	////////////////////////////////////// QueryDSL 메소드
	@Override
	public List<Emp> selectByJobOrderByEnameDesc(String job) {
		return empRepository.selectByJobOrderByEnameDesc(job);
	}

	@Override
	public Long deleteByJob(String job) {
		return empRepository.deleteByJob(job);	
	}
	
	@Override
	public Long updateByEmpno(Long empno, String newEname) {
		return empRepository.updateByEmpno(empno, newEname);	
	}

	@Override
	public List<Tuple> selectEnameJobByEmpno(Long empno) {
		return empRepository.selectEnameJobByEmpno(empno);		
	}

	@Override
	public List<Tuple> selectEmpEnameDnameJoinDept(Long deptno) {
		return empRepository.selectEmpEnameDnameJoinDept(deptno);
	}

	@Override
	public List<Emp> selectEmpMaxSal() {
		return empRepository.selectEmpMaxSal();		
	}

	@Override
	public List<Emp> selectEmpMaxSalOfDept() {
		return empRepository.selectEmpMaxSalOfDept();				
	}

	@Override
	public List<Emp> selectEmpGreaterThanAvgSal() {
		return empRepository.selectEmpGreaterThanAvgSal();	
	}

	@Override
	public List<Emp> selectEmpEqualsEmpno(Long empno) {
		return empRepository.selectEmpEqualsEmpno(empno);
	}

	@Override
	public List<Emp> selectEmpMaxSalTop3() {
		return empRepository.selectEmpMaxSalTop3();
	}

	@Override
	public List<String> selectDeptExistsEmp() {
		return empRepository.selectDeptExistsEmp();
	}	
}
