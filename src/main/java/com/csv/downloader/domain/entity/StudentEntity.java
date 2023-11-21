package com.csv.downloader.domain.entity;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentEntity {

    private Integer registration;

    private String name;
    private Integer grade;


}
