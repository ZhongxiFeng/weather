package com.example.studentservicedev.controller;

//import com.example.common.domain.GeneralResponse;
import com.example.studentservicedev.pojo.Student;
import com.example.studentservicedev.response.GeneralResponse;
import com.example.studentservicedev.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ZHONGXI FENG
 * @projectName Antra_HW
 * @create 6/14/2023-7:21 PM
 * @description
 */
@RestController
public class StudentController {
    private final StudentService studentService;

    @Autowired
    StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    //@GetMapping("/hello")
    //public String hhh(){
    //    return "hello";
    //}

    @GetMapping("/student")
    public GeneralResponse getAllStudents(){
        List<Student> allStudents = studentService.getAllStudents();
        GeneralResponse generalResponse = new GeneralResponse(allStudents);
        return generalResponse;
    }
    @GetMapping("/student/{id}")
    public GeneralResponse getStudentById(@PathVariable String id){
        Student student = studentService.getStudentById(Integer.parseInt(id));
        GeneralResponse generalResponse = new GeneralResponse(student);
        return generalResponse;
    }

    @PutMapping(value = "/student",params = {"name","age"})
    public GeneralResponse insertNewStudent(@RequestParam("name")String name,@RequestParam("age")Integer age){
        Student student = studentService.insertNewStudent(name, age);
        GeneralResponse generalResponse = new GeneralResponse(student);
        return generalResponse;
    }

    @PutMapping(value = "/student", params = {"id","name","age"})
    public GeneralResponse updateStudent(@RequestParam("id")Integer id,@RequestParam("name")String name,@RequestParam("age")Integer age){
        Student student = studentService.updateStudentById(id, name, age);
        GeneralResponse generalResponse = new GeneralResponse(student);
        return generalResponse;
    }

    @PostMapping(value = "/student")
    public GeneralResponse newUpdate(@RequestBody Student student){
        Student student1 = studentService.newUpdateStudent(student);
        GeneralResponse generalResponse = new GeneralResponse(student1);
        return generalResponse;
    }

    @DeleteMapping("/student/{id}")
    public GeneralResponse deleteStudent(@PathVariable("id")Integer id){
        studentService.deleteStudentById(id);
        GeneralResponse generalResponse = new GeneralResponse("Delete Successfully");
        return generalResponse;
    }
}
