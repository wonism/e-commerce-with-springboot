package jpa.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import jpa.model.Emp;

/*
 * 기본 JpaRepository외 사용자정의 인터페이스 EmpRepositoryCustom을
 * 상속받고 Query Method 2개를 정의하고 있다. 
 */
public interface EmpRepository extends JpaRepository<Emp, Long>, EmpRepositoryCustom{
	// sal값이 지정된값보다 크거나 같은조건으로, 페이징 기능을 이용해 추출
	// 메소드 명으로 쿼리 자동생성                      
	Page<Emp> findBySalGreaterThan(Long sal, Pageable pageable);
	
	// 급여로 조회하는데 이름내림차순으로 처음3건만 추출 
	// 메소드 명으로 쿼리 자동생성                      
	List<Emp> findFirst3BySalBetweenOrderByEnameDesc(Long sal1, Long Sal2);
}
