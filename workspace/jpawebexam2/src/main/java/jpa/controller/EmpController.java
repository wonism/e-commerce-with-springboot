package jpa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.querydsl.core.Tuple;

import jpa.model.Dept;
import jpa.model.Emp;
import jpa.model.QDept;
import jpa.model.QEmp;
import jpa.service.DeptService;
import jpa.service.EmpService;

@RestController
@RequestMapping("/emp")
public class EmpController {
	@Autowired
	private EmpService empService;

	@Autowired
	private DeptService deptService;

	///////////////////////////// JpaRepository의 기본 CRUD
	/* localhost:8080/emp/add/홍길동/교수/9999/교육부 */
	@RequestMapping(value = "/add/{ename}/{job}/{sal}/{dname}")
	public Emp addEmp(@PathVariable String ename, @PathVariable String job, @PathVariable Long sal,
			@PathVariable String dname) {

		Dept dept = deptService.findByDname(dname);
		if (dept == null) {
			dept = deptService.saveDept(new Dept(dname));
		}

		Emp emp = new Emp();
		emp.setEname(ename);
		emp.setJob(job);
		emp.setSal(sal);
		emp.setDept(dept);

		empService.saveEmp(emp);

		return emp;
	}

	/////////////////////////// JpaRepository의 기본 CRUD
	/* localhost:8080/emp/delete/9999 */
	@RequestMapping(value = "/delete/{empno}")
	public void deleteEmp(@PathVariable Long empno) {
		empService.delete(empno);
	}

	/////////////////////////// JpaRepository의 기본 CRUD
	/* localhost:8080/emp/ */
	@RequestMapping(value = "/")
	public List<Emp> findAll() {
		return empService.findAll();
	}

	/////////////////////////// JpaRepository의 기본 CRUD
	/* localhost:8080/emp/1 */
	@RequestMapping(value = "/{empno}")
	public Emp findOne(@PathVariable Long empno) {
		return empService.findOne(empno);
	}

	////////////////////////// Named Query
	@RequestMapping(value = "/search/sal/{sal}")
	public List<Emp> findBySalNamed(@PathVariable Long sal) {
		return empService.findBySalNamed(sal);
	}

	////////////////////////// @Query
	/* localhost:8080/emp/search/ename/홍길동 */
	@RequestMapping(value = "/search/ename/{ename}")
	public List<Emp> findByEname(@PathVariable String ename) {
		return empService.findByEname(ename);
	}

	////////////////////////// @Query
	/* localhost:8080/emp/search/custom/sal/9999 */
	@RequestMapping(value = "/search/custom/sal/{sal}")
	public List<Emp> findBySalCustom(@PathVariable Long sal) {
		return empService.findBySalCustom(sal);
	}

	////////////////////////// @Query
	@RequestMapping(value = "/search/custom/top3/{sal1}/{sal2}")
	public List<Emp> findFirst3BySalBetweenOrderByEnameDesc(@PathVariable Long sal1, @PathVariable Long sal2) {
		return empService.findFirst3BySalBetweenOrderByEnameDesc(sal1, sal2);
	}

	////////////////////////// @Query
	@RequestMapping(value = "/search/match/ename/{ename}")
	public List<Emp> findByEnameMatch(@PathVariable String ename) {
		return empService.findByEnameMatch(ename);
	}

	////////////////////////// @Query
	/* localhost:8080/emp/search/param/홍길동/교수/9999 */
	@RequestMapping(value = "/search/param/{ename}/{job}/{sal}")
	public List<Emp> findByNamedParam(@PathVariable String ename, @PathVariable String job, @PathVariable Long sal) {
		return empService.findByNamedParam(ename, job, sal);
	}

	////////////////////////// @Query
	/* localhost:8080/emp/search/sal/5555/9999 */
	@RequestMapping(value = "/search/sal/{sal1}/{sal2}")
	public List<Emp> findBySalRange(@PathVariable Long sal1, @PathVariable Long sal2) {
		return empService.findBySalRange(sal1, sal2);
	}

	////////////////////////// @Query
	// localhost:8080/emp/search/sal/1000/3/2
	// SAL이 1000 보다 크거나 같은데, 한페이지3개씩,두번째페이지
	@RequestMapping(value = "/search/sal/{sal}/{pageSize}/{pageNumber}")
	public List<Emp> getEmpBySalGreaterThan(@PathVariable Long sal, @PathVariable Integer pageSize,
			@PathVariable Integer pageNumber) {
		Page<Emp> result = empService.getEmpBySalGreaterThan(sal, pageSize, pageNumber);
		List<Emp> emps = result.getContent();
		return emps;
	}

	////////////////////////// QueryDSL
	/* localhost:8080/emp/search/job/교수 */
	@RequestMapping(value = "/search/job/{job}")
	public List<Emp> getEmpBySal(@PathVariable String job) {
		return empService.selectByJobOrderByEnameDesc(job);
	}

	////////////////////////// QueryDSL
	/* localhost:8080/emp/delete/job/교수 */
	@RequestMapping(value = "/delete/job/{job}")
	public String deleteEmpByJob(@PathVariable String job) {
		Long affectedRow = empService.deleteByJob(job);
		return "[job:" + job + "] " + affectedRow + " row deleted!";
	}

	////////////////////////// QueryDSL
	/* localhost:8080/emp/update/empno/1/1길동 */
	@RequestMapping(value = "/update/empno/{empno}/{newEname}")
	public String updateEmpByEmpno(@PathVariable Long empno, @PathVariable String newEname) {
		Long affectedRow = empService.updateByEmpno(empno, newEname);
		return "[empno:" + empno + "] " + affectedRow + " row updated!";
	}

	////////////////////////// QueryDSL(다중칼럼 선택)
	/* localhost:8080/emp/select/empno/1 */
	@RequestMapping(value = "/select/empno/{empno}")
	public Map<String, String> selectEmpEnameSalByJob(@PathVariable Long empno) {
		Map<String, String> m = new HashMap<String, String>();
		QEmp emp = QEmp.emp;
		List<Tuple> result = empService.selectEnameJobByEmpno(empno);
		for (Tuple row : result) {
			m.put(row.get(emp.ename), row.get(emp.job));
		}
		return m;
	}

	///////////////////////// QueryDSL(join)
	/* localhost:8080/emp/select/enamedname/1 */
	/* 사원, 부서를 조인하여 사원이름, 부서명 추출 */
	@RequestMapping(value = "/select/enamedname/{deptno}")
	public Map<String, String> getEmpEnameDnameJoinDept(@PathVariable Long deptno) {
		Map<String, String> m = new HashMap<String, String>();
		QEmp emp = QEmp.emp;
		QDept dept = QDept.dept;
		List<Tuple> result = empService.selectEmpEnameDnameJoinDept(deptno);
		for (Tuple row : result) {
			m.put(row.get(emp.ename), row.get(dept.dname));
		}
		return m;
	}

	//////////////////////// QueryDSL(sub query)
	/* localhost:8080/emp/select/maxsal */
	/* 최대급여를 가지는 사원 추출 */
	@RequestMapping(value = "/select/maxsal")
	public List<Emp> selectEmpMaxSal() {
		return empService.selectEmpMaxSal();
	}

	//////////////////////// QueryDSL(sub query)
	/* localhost:8080/emp/select/emp/maxsalofdept */
	/* 부서별 최대 급여사원 출력 */
	@RequestMapping(value = "/select/maxsalofdept")
	public List<Emp> selectEmpMaxSalOfDept() {
		return empService.selectEmpMaxSalOfDept();
	}

	//////////////////////// QueryDSL(sub query)
	/* localhost:8080/emp/select/emp/gt/avgsalofdept */
	/* 자신이 속한 부서의 평균급여보다 급여가 많은 사원 */
	@RequestMapping(value = "/select/gt/avgsalofdept")
	public List<Emp> selectEmpGreaterThanAvgSal() {
		return empService.selectEmpGreaterThanAvgSal();
	}

	//////////////////////// QueryDSL(sub query)
	/* localhost:8080/emp/select/same/1 */
	/* 입력받은 사원과 급여가 같은 사원 추출, 입력받은 사원은 제외 */
	@RequestMapping(value = "/select/same/{empno}")
	public List<Emp> selectEmpEqualsEmpno(@PathVariable Long empno) {
		return empService.selectEmpEqualsEmpno(empno);
	}

	//////////////////////// QueryDSL(sub query)
	/* localhost:8080/emp/select/top3 */
	/* Emp 테이블에서 급여 상위 3명 추출 */
	@RequestMapping(value = "/select/top3")
	public List<Emp> selectEmpMaxSalTop3() {
		return empService.selectEmpMaxSalTop3();
	}

	//////////////////////// QueryDSL(sub query)
	/* localhost:8080/emp/select/exists */
	/* 사원이 한명이라도 존재하는 부서명 추출 */
	@RequestMapping(value = "/select/exists")
	public List<String> selectDeptExistsEmp() {
		return empService.selectDeptExistsEmp();
	}
}
