package com.csv.downloader.controller;

import com.csv.downloader.domain.response.StudentResponse;
import com.csv.downloader.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
@Tag(name = "Student Controller", description = "Endpoint for returning csv with a list of students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("all")
    @Operation(summary = "list all students")
    ResponseEntity<List<StudentResponse>> getAllStudents() {
        return ResponseEntity.ok().body(studentService.getStudents());
    }

}
