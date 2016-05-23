package demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import demo.model.Dept;

public interface DeptRepository extends JpaRepository<Dept, Long> {

}
