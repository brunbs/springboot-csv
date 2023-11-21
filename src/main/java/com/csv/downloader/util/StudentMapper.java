package com.csv.downloader.util;

import com.csv.downloader.domain.entity.StudentEntity;
import com.csv.downloader.domain.response.StudentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentMapper {

    List<StudentResponse> entityToResponseList(List<StudentEntity> entities);

}
