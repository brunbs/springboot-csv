package com.csv.downloader.service.Impl;


import com.csv.downloader.domain.entity.StudentEntity;
import com.csv.downloader.domain.response.StudentResponse;
import com.csv.downloader.repository.StudentRepository;
import com.csv.downloader.service.StudentService;
import com.csv.downloader.util.StudentMapper;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
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

    @Override
    public void getStudentsCSV(HttpServletResponse response) {
        List<StudentEntity> students = StudentRepository.findAll();

        try(XSSFWorkbook workbook = new XSSFWorkbook()){
            String headerKey = "Content-Disposition";
            String headerValue = "attachment; filename=report.csv";
            response.setHeader(headerKey, headerValue);

            XSSFSheet sheet = createSheet(workbook);
            createHeader(sheet);
            createRow(sheet, students);

            ServletOutputStream out = response.getOutputStream();
            out.flush();
            workbook.write(out);
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private XSSFSheet createSheet(XSSFWorkbook workbook) {
        XSSFSheet sheet = workbook.createSheet("Student Report");
        sheet.setColumnWidth(0, 4000);
        sheet.setColumnWidth(1, 4000);
        sheet.setColumnWidth(2, 4000);
        return sheet;
    }

    private void createHeader(XSSFSheet sheet) {
        XSSFRow header = sheet.createRow(0);
        createCell(header, 0, "Registration");
        createCell(header, 1, "Name");
        createCell(header, 2, "Grade");
    }

    private void createCell(XSSFRow row, int index, String value) {
        XSSFCell cell = row.createCell(index);
        cell.setCellValue(value);
    }

    private void createRow(XSSFSheet sheet, List<StudentEntity> students) {
        XSSFRow row;
        int rowCounter = 1;

        for(var student : students) {
            row = sheet.createRow(rowCounter);
            createCell(row, 0, student.getRegistration().toString());
            createCell(row, 1, student.getName());
            createCell(row, 2, student.getGrade().toString());
            rowCounter++;
        }
    }


}
