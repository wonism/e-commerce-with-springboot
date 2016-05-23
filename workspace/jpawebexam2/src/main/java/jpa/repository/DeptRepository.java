package jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jpa.model.Dept;

public interface DeptRepository extends JpaRepository<Dept, Long>{
	Dept findByDname(String dname); //query method
}
