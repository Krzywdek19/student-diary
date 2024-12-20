package com.krzywdek19.student_diary.school.service;

import com.krzywdek19.student_diary.school.dto.SchoolDto;
import com.krzywdek19.student_diary.school.request.CreateSchoolRequest;
import com.krzywdek19.student_diary.school.request.UpdateSchoolRequest;

import java.util.List;

public interface SchoolService {
    //CREATE
    SchoolDto createSchool(CreateSchoolRequest request);
    //READ
    SchoolDto findSchoolById(Long id);
    List<SchoolDto> findAllSchools();
    //UPDATE
    SchoolDto changeSchoolDetails(Long id, UpdateSchoolRequest request);
    //DELETE
    void deleteSchoolById(Long id);
}
