package jpa.service;

import jpa.model.Dept;

public interface DeptService {
	Dept findByDname(String dname);  //query method
	Dept saveDept(Dept dept);
}
