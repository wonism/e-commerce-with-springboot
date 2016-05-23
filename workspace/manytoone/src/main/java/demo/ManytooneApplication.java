package demo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import demo.model.Dept;
import demo.model.Emp;
import demo.repository.DeptRepository;

@SpringBootApplication
public class ManytooneApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(ManytooneApplication.class);

	@Autowired
	private DeptRepository deptRepository;
	
	@PersistenceContext
	private EntityManager em;
	
	public static void main(String[] args) {
		SpringApplication.run(ManytooneApplication.class, args);
	}
	
	@Override
	@Transactional
	public void run(String...strings) throws Exception {
		
		//Dept에 1번부서가 만들어지고, Emp의 deptno는 1로 입력됨
		Dept d1 = new Dept("교육팀");
		Emp e1 = new Emp("김교육", d1);
		Emp e2 = new Emp("나교육", d1);

		d1.setEmps(new HashSet<Emp>() {
			  {
					add(e1);
					add(e2);
			  }
		});		
		
		//Dept에 2번 부서가 만들어지고 Emp의 deptno는 NULL로 입력
		Dept d2 = new Dept("개발팀", new HashSet<Emp>() {
		  {
			add(new Emp("김개발"));
			add(new Emp("나개발"));
		  }
		});
		
		//Dept, Emp 저장
		deptRepository.save(new HashSet<Dept>() {
		  {
			add(d1);
			add(d2);
		  }
		});
					
		for(Dept d : deptRepository.findAll()) {
			if (d != null) {
				logger.info(d.toString());
			}
		}	
		
		//------------- 1번 부서 및 부서원 로드		
		Dept d3 = deptRepository.findOne(1L);
		Set<Emp> emps = d3.getEmps();
		for(Emp e : emps) {
			logger.info(e.toString());
		}		
		
		//------------- 1번부서 삭제, 1번부서원들도 같이 삭제된다.		
		deptRepository.delete(d3);
	}
}
