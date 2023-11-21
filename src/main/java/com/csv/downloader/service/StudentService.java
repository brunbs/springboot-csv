package com.csv.downloader.service;


import com.csv.downloader.domain.response.StudentResponse;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public interface StudentService {
    List<StudentResponse> getStudents();
    void getStudentsCSV(HttpServletResponse response);

}
