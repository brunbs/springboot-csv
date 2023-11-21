package com.csv.downloader.service.Impl;


import com.csv.downloader.domain.entity.StudentEntity;
import com.csv.downloader.domain.response.StudentResponse;
import com.csv.downloader.repository.StudentRepository;
import com.csv.downloader.service.StudentService;
import com.csv.downloader.util.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<StudentResponse> getStudents() {
        List<StudentEntity> students = StudentRepository.findAll();
        return studentMapper.entityToResponseList(students);
    }
}
