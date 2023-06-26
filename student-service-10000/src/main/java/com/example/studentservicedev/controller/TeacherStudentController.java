package com.example.studentservicedev.controller;

import com.example.studentservicedev.pojo.TeacherStudent;
import com.example.studentservicedev.response.ResponseData;
import com.example.studentservicedev.service.TeacherStudentServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ZHONGXI FENG
 * @projectName Antra_HW
 * @create 6/14/2023-9:46 PM
 * @description
 */
@RestController
public class TeacherStudentController {
    TeacherStudentServiceImpl teacherStudentService;

    TeacherStudentController(TeacherStudentServiceImpl teacherStudentService) {
        this.teacherStudentService = teacherStudentService;
    }

    @GetMapping("/teacherStudent")
    public ResponseData getAllTeacherStudents() {
        List<TeacherStudent> allTeacherStudents = teacherStudentService.getAllTeacherStudents();
        ResponseData responseData = new ResponseData();
        responseData.put("allTeacherStudents",allTeacherStudents);
        return responseData;
    }
}
