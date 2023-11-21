package com.csv.downloader.domain.response;

import com.csv.downloader.domain.entity.StudentEntity;
import lombok.Data;

@Data
public class StudentResponse {

    private Integer registration;
    private String name;
    private Integer grade;

}
