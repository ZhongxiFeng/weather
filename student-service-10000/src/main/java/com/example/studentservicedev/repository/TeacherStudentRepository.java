package com.example.studentservicedev.repository;

import com.example.studentservicedev.pojo.TeacherStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ZHONGXI FENG
 * @projectName Antra_HW
 * @create 6/14/2023-3:16 PM
 * @description
 */
@Repository
public interface TeacherStudentRepository extends JpaRepository<TeacherStudent,Integer> {
}
