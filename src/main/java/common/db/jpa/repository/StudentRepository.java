package common.db.jpa.repository;

import common.db.jpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author Vincent
 * @Date 2017/11/5 11:27
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
