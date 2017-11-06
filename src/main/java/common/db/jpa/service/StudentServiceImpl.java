package common.db.jpa.service;

import common.db.jpa.model.Student;
import common.db.jpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Vincent
 * @Date 2017/11/5 11:26
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student getStudentById(Integer id) {
        return studentRepository.getOne(id);
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
}
