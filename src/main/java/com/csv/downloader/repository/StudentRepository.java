package com.csv.downloader.repository;

import com.csv.downloader.domain.entity.StudentEntity;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository  {


    public static List<StudentEntity> findAll() {
        List<StudentEntity> students = new ArrayList<>();
        for(int i = 1; i < 11; i++) {
            students.add(StudentEntity.builder().name("Student " + i).registration(i).grade(i*10).build());
        }
        return students;
    }

}
