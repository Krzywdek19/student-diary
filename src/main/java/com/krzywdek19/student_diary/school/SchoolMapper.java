package com.krzywdek19.student_diary.school;

import com.krzywdek19.student_diary.school.dto.SchoolDto;
import com.krzywdek19.student_diary.school.request.CreateSchoolRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SchoolMapper {
    SchoolDto schoolToSchoolDto(School school);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "schoolType", target = "schoolType")
    @Mapping(target = "studentCount", ignore = true)
    @Mapping(target = "classCount", ignore = true)
    @Mapping(target = "id", ignore = true)
    School createSchoolRequestToSchool(CreateSchoolRequest request);
}
