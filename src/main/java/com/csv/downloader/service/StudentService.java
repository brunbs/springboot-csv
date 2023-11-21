package com.csv.downloader.service;


import com.csv.downloader.domain.response.StudentResponse;

import java.util.List;

public interface StudentService {
    List<StudentResponse> getStudents();

}
