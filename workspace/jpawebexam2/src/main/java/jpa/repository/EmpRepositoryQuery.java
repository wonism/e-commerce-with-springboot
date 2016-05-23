package jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import jpa.model.Emp;

// Spring Data JPA @Query지원 메소드  
public interface EmpRepositoryQuery extends Repository<Emp, Long> 
{
	//Native SQL, SQL구문은 JPQL형태가 아니라 DB에서 사용하는 SQL형식을 쓰면 된다.
    //nativeQuery 값의 default는 false
    //#entityName은 SpEL 표현이며 위 Repository<Emp, Long>의 Emp객체를 가리킨다.
    //위 선언에서 EmpRepositoryQuery<Emp> Repository<T, Long> 형태로 쓸 때 유용하다.
	@Query(value="select * from #{#entityName} e where e.ename = ?1", 
		   nativeQuery=true)
	List<Emp> findByEname(String ename);
	
	@Query(value="select ename, job, sal from Emp e where e.sal > ?1 and e.sal < ?2 ")
	List<Emp> findBySalRange(Long sal1, Long sal2);
	
	@Query(value="select ename, job, sal from Emp e where e.ename like %:ename% ")
	List<Emp> findByEnameMatch(@Param("ename") String ename);
	
    //기본적으로 Spring Data JPA의 파라미터 바인딩은 순서에 의존한다.
    //쿼리의 바인딩 될 파라미터 이름으로 바인딩 하는 경우 @Param을 쓰면 된다.
	@Query(value="select ename, job, sal from Emp e where e.ename = :ename and e.job=:job and e.sal = :sal")
	List<Emp> findByNamedParam(@Param("ename") String ename,
			@Param("job") String job,
			@Param("sal") Long sal);
	
	@Query(value = "select e from Emp e where e.sal = :sal")
	List<Emp> findBySalCustom(@Param("sal") Long sal);		
		
}
