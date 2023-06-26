package com.example.studentservicedev.controller;

import com.example.studentservicedev.pojo.Teacher;
import com.example.studentservicedev.response.ResponseData;
import com.example.studentservicedev.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ZHONGXI FENG
 * @projectName Antra_HW
 * @create 6/14/2023-8:05 PM
 * @description
 */
@RestController
public class TeacherController {
    private final TeacherService teacherService;

    @Autowired
    TeacherController(TeacherService teacherService){
        this.teacherService = teacherService;
    }

    @GetMapping("/teacher")
    public ResponseData getAllTeacher(){
        List<Teacher> allTeachers = teacherService.getAllTeachers();
        ResponseData responseData = new ResponseData();
        responseData.put("allTeachers",allTeachers);
        return responseData;
    }

    @GetMapping("/teacher/{id}")
    public ResponseData getTeacherById(@PathVariable Integer id){
        Teacher teacher = teacherService.getTeacherById(id);
        ResponseData responseData = new ResponseData();
        responseData.put("teacher",teacher);
        return responseData;
    }
}
