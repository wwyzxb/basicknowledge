package common.db.jpa.service;

import common.db.jpa.model.Student;

import java.util.List;

/**
 * @Author Vincent
 * @Date 2017/11/5 11:26
 */
public interface StudentService {
    //定义获得用户的接口
    public List<Student> getStudents();

    public Student getStudentById(Integer id);
}
