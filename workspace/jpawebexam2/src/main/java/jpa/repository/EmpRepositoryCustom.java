package jpa.repository;


import java.util.List;

import com.querydsl.core.Tuple;

import jpa.model.Dept;
import jpa.model.Emp;

/* 
 * 사용자 정의 인터페이스, 기본으로 제공되는 JpaRepository이외의
 * 사용자 쿼리 작성할 때 만드는 인퍼테이스이며 Query Mathod 및 
 * NamedQuery 처리를 위한 메소드를 정의하고 있다.
 */
public interface EmpRepositoryCustom {
	
	//NamedQuery 처리용
	List<Emp> findBySalNamed(Long sal);
	
	//QueryDSL 처리용
	List<Emp> selectByJobOrderByEnameDesc(String job);
	Long deleteByJob(String job);
	Long updateByEmpno(Long empno, String newEname);
	List<Tuple> selectEnameJobByEmpno(Long empno);
	List<Tuple> selectEmpEnameDnameJoinDept(Long deptno);  //Join
	List<Emp> selectEmpMaxSal();         //subquery
	List<Emp> selectEmpMaxSalOfDept();   //subquery
	List<Emp> selectEmpGreaterThanAvgSal();  //subquery
	List<Emp> selectEmpEqualsEmpno(Long empno);  //subquery
	List<Emp> selectEmpMaxSalTop3();  //subquery
	List<String> selectDeptExistsEmp();  //subquery 
}
