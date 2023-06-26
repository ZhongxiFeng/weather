package com.example.studentservicedev.repository;

import com.example.studentservicedev.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ZHONGXI FENG
 * @projectName Antra_HW
 * @create 6/14/2023-2:44 PM
 * @description
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
