package demo.model;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "dept")
public class Dept {	
	private Long deptno;
	private String dname; 
		
	private Set<Emp> emps;
	
	public Dept() { }
	public Dept(String dname) {
		this.dname = dname;
	}
	public Dept(String dname, Set<Emp> emps) {
		this.dname = dname;
		this.emps = emps;
	}
	
	@Id
	@GeneratedValue
	public Long getDeptno() {
		return deptno;
	}
	public void setDeptno(Long deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	//Emp 엔티티의 dept 속성(필드)를 매핑
	//mappedBy에서 반대쪽(many쪽),Owner가 되는쪽의 매핑되는 속성지정
	@OneToMany(mappedBy = "dept", cascade = CascadeType.ALL)
	public Set<Emp> getEmps() {
		return emps;
	}
	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}
	public String toString() {
		String s = String.format("DEPT[deptno = %d, dname = '%s']%n",  deptno, dname);
		
		if (emps != null) {
			for(Emp e : emps) {
				s += String.format("EMP[empno = %d, ename = '%s', deptno = '%s']%n",
						e.getEmpno(), e.getEname(), 
						e.getDept()==null?"":e.getDept().deptno);
			}
		}		
		return s;
	}	
}
