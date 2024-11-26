package com.krzywdek19.student_diary.school.service;

import com.krzywdek19.student_diary.school.dto.SchoolDto;
import com.krzywdek19.student_diary.school.request.CreateSchoolRequest;
import com.krzywdek19.student_diary.school.request.UpdateSchoolRequest;

import java.util.List;

public interface SchoolService {
    //CREATE
    SchoolDto addSchool(CreateSchoolRequest request);
    //READ
    SchoolDto findSchoolById(Long id);
    List<SchoolDto> findAllSchools();
    //UPDATE
    SchoolDto changeSchoolDetails(UpdateSchoolRequest request);
    //DELETE
    void deleteSchoolById(Long id);
}
