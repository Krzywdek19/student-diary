package com.krzywdek19.student_diary.school.schoolClass.service;

import com.krzywdek19.student_diary.school.schoolClass.dto.SchoolClassDto;
import com.krzywdek19.student_diary.school.schoolClass.request.CreateSchoolClassRequest;
import com.krzywdek19.student_diary.school.schoolClass.request.UpdateSchoolClassRequest;

import java.util.List;

public interface SchoolClassService {
    //CREATE
    SchoolClassDto createSchoolClass(Long schoolId, CreateSchoolClassRequest request);
    //READ
    SchoolClassDto findSchoolClassById(Long schoolId, Long id);
    List<SchoolClassDto> findSchoolClassesBySchoolId(Long schoolId);
    //UPDATE
    SchoolClassDto changeSchoolClassDetails(Long schoolId, Long id, UpdateSchoolClassRequest request);
    //DELETE
    void deleteSchoolClassById(Long id);
}
