package com.example.studentservicedev.service;

import com.example.studentservicedev.pojo.TeacherStudent;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZHONGXI FENG
 * @projectName Antra_HW
 * @create 6/14/2023-9:51 PM
 * @description
 */
@Service
public interface TeacherStudentService {
    List<TeacherStudent> getAllTeacherStudents();
}
