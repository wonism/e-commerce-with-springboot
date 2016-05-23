package jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@NamedQuery(name="Emp.findBySalNamed",
            query="select e from Emp e where e.sal > :sal")
public class Emp { 
	@Id
	@GeneratedValue
	private Long empno;
	private String ename;
	private String job;
	private Long sal;
	
	@ManyToOne
	@JoinColumn(name = "deptno")	
	private Dept dept;
}
