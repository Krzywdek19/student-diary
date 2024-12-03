package com.krzywdek19.student_diary.school.schoolClass.service;

import com.krzywdek19.student_diary.school.SchoolRepository;
import com.krzywdek19.student_diary.school.schoolClass.SchoolClass;
import com.krzywdek19.student_diary.school.schoolClass.SchoolClassMapper;
import com.krzywdek19.student_diary.school.schoolClass.SchoolClassRepository;
import com.krzywdek19.student_diary.school.schoolClass.dto.SchoolClassDto;
import com.krzywdek19.student_diary.school.schoolClass.request.CreateSchoolClassRequest;
import com.krzywdek19.student_diary.school.schoolClass.request.UpdateSchoolClassRequest;
import com.krzywdek19.student_diary.school.service.SchoolService;
import com.krzywdek19.student_diary.school.service.SchoolServiceImpl;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolClassServiceImpl implements SchoolClassService{
    private final SchoolClassRepository schoolClassRepository;
    private final SchoolServiceImpl schoolService;
    private final SchoolClassMapper schoolClassMapper;

    @Override
    @Transactional
    public SchoolClassDto createSchoolClass(CreateSchoolClassRequest request) {
        var school = schoolService
                .findSchoolEntityById(request.schoolId());
        school.setClassCount(school.getClassCount() + 1);
        var schoolClass = SchoolClass
                .builder()
                .classSign(request.classSign())
                .classGrade(request.classGrade())
                .build();
        school.addSchoolClass(schoolClass);
        schoolClassRepository.save(schoolClass);
        return schoolClassMapper
                .schoolClassToSchoolClassDto(schoolClass);
    }

    @Override
    public SchoolClassDto findSchoolClassById(Long id) {
        return null;
    }

    @Override
    public List<SchoolClassDto> findSchoolClassesBySchoolId(Long schoolId) {
        return List.of();
    }

    @Override
    public List<SchoolClassDto> findAllSchoolClasses() {
        return List.of();
    }

    @Override
    public SchoolClassDto updateSchoolClass(Long id, UpdateSchoolClassRequest request) {
        return null;
    }

    @Override
    public void deleteSchoolClassById(Long id) {

    }
}
