package com.krzywdek19.student_diary.school.schoolClass.service;

import com.krzywdek19.student_diary.common.exception.ResourceNotFoundException;
import com.krzywdek19.student_diary.school.schoolClass.SchoolClass;
import com.krzywdek19.student_diary.school.schoolClass.SchoolClassMapper;
import com.krzywdek19.student_diary.school.schoolClass.SchoolClassRepository;
import com.krzywdek19.student_diary.school.schoolClass.dto.SchoolClassDto;
import com.krzywdek19.student_diary.school.schoolClass.request.CreateSchoolClassRequest;
import com.krzywdek19.student_diary.school.schoolClass.request.UpdateSchoolClassRequest;
import com.krzywdek19.student_diary.school.service.SchoolServiceImpl;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolClassServiceImpl implements SchoolClassService{
    private final SchoolClassRepository repository;
    private final SchoolServiceImpl schoolService;
    private final SchoolClassMapper schoolClassMapper;

    //CREATE
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
        repository.save(schoolClass);
        return schoolClassMapper
                .schoolClassToSchoolClassDto(schoolClass);
    }

    //READ
    public SchoolClass findRawSchoolClassById(Long id) {
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException(SchoolClass.class, id));
    }

    @Override
    public SchoolClassDto findSchoolClassById(Long id) {
        return schoolClassMapper
                .schoolClassToSchoolClassDto(findRawSchoolClassById(id));
    }

    @Override
    public List<SchoolClassDto> findSchoolClassesBySchoolId(Long schoolId) {
        return repository
                .findAllBySchoolId(schoolId)
                .stream()
                .map(schoolClassMapper::schoolClassToSchoolClassDto)
                .toList();
    }

    @Override
    public List<SchoolClassDto> findAllSchoolClasses() {
        return repository
                .findAll()
                .stream()
                .map(schoolClassMapper::schoolClassToSchoolClassDto)
                .toList();
    }

    //UPDATE
    @Override
    @Transactional
    public SchoolClassDto changeSchoolClassDetails(Long id, UpdateSchoolClassRequest request) {
        var schoolClass = findRawSchoolClassById(id);
        request
                .classGrade()
                .ifPresent(schoolClass::setClassGrade);
        request
                .classSign()
                .ifPresent(schoolClass::setClassSign);
        return schoolClassMapper
                .schoolClassToSchoolClassDto(schoolClass);
    }

    //DELETE
    @Override
    public void deleteSchoolClassById(Long id) {
        repository
                .findById(id)
                .ifPresent(repository::delete);
    }
}
