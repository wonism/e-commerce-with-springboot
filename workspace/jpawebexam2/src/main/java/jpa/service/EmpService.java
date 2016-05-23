package jpa.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.querydsl.core.Tuple;

import jpa.model.Dept;
import jpa.model.Emp;

public interface EmpService {
	List<Emp> findAll();
	void saveEmp(Emp emp);
	Emp findOne(Long empno);
	void delete(Long empno);
	
	//NamedQuery
	List<Emp> findBySalNamed(Long sal);
	
	//Query Method(메소드명으로 쿼리자동작성)
	List<Emp> findByEname(String ename);
	List<Emp> findBySalCustom(Long sal);	
	List<Emp> findBySalRange(Long sal1, Long sal2);
	List<Emp> findByEnameMatch(String ename);
	List<Emp> findByNamedParam(String ename, String job, Long sal);
	List<Emp> findFirst3BySalBetweenOrderByEnameDesc(Long sal1, Long sal2);
	
	//QueryDSL
	List<Emp> selectByJobOrderByEnameDesc(String job);
	Long deleteByJob(String job);
	Long updateByEmpno(Long empno, String newEname);
	List<Tuple> selectEnameJobByEmpno(Long empno);
	List<Tuple> selectEmpEnameDnameJoinDept(Long deptno);
	List<Emp> selectEmpMaxSal();
	List<Emp> selectEmpMaxSalOfDept();
	List<Emp> selectEmpGreaterThanAvgSal();
	List<Emp> selectEmpEqualsEmpno(Long empno);
	List<Emp> selectEmpMaxSalTop3();
	List<String> selectDeptExistsEmp();
	
	//Pagination
	Page<Emp> getEmpBySalGreaterThan(Long sal, Integer pageSize, Integer pageNumber);
}
