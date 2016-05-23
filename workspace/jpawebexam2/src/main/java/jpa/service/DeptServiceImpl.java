package jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jpa.model.Dept;
import jpa.repository.DeptRepository;

@Service("deptService")
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptRepository deptRepository;
	
	@Override
	public Dept findByDname(String dname) {
		Dept depts = deptRepository.findByDname(dname);
		return depts;
	}

	@Override
	public Dept saveDept(Dept dept) {
		return deptRepository.save(dept);
	}
}
