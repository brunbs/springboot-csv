package com.csv.downloader.domain.request;

import lombok.Data;

@Data
public class StudentRequest {

    private Integer registration;
    private String name;
    private Integer grade;

}
