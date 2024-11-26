package com.krzywdek19.student_diary.school.service;

import com.krzywdek19.student_diary.school.SchoolMapper;
import com.krzywdek19.student_diary.school.SchoolRepository;
import com.krzywdek19.student_diary.school.dto.SchoolDto;
import com.krzywdek19.student_diary.school.exception.SchoolNotFoundException;
import com.krzywdek19.student_diary.school.request.CreateSchoolRequest;
import com.krzywdek19.student_diary.school.request.UpdateSchoolRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SchoolServiceImpl implements SchoolService{
    private final SchoolRepository repository;
    private final SchoolMapper mapper;

    @Override
    public SchoolDto addSchool(CreateSchoolRequest request) {
        var school = mapper.createSchoolRequestToSchool(request);
        System.out.println(school.toString());
        school.setClassCount(0);
        school.setStudentCount(0);
        System.out.println(school);
        school = repository.save(school);
        return mapper.schoolToSchoolDto(school);
    }

    @Override
    public SchoolDto findSchoolById(Long id) {
        var school = repository
                .findById(id)
                .orElseThrow(()-> new SchoolNotFoundException("Cannot find school with id: " + id));
        return mapper
                .schoolToSchoolDto(school);
    }

    @Override
    public List<SchoolDto> findAllSchools() {
        return repository
                .findAll()
                .stream()
                .map(mapper::schoolToSchoolDto)
                .toList();
    }

    @Override
    @Transactional
    public SchoolDto changeSchoolDetails(UpdateSchoolRequest request) {
        var school = repository
                .findById(request.id())
                .orElseThrow(()-> new SchoolNotFoundException("Cannot find school with id: " + request.id()));
        if(request.schoolType() != null){
            school.setSchoolType(request.schoolType());
        }
        if(request.address() != null) {
            school.setAddress(request.address());
        }
        if(request.name() != null) {
            school.setName(request.name());
        }
        return mapper
                .schoolToSchoolDto(school);
    }

    @Override
    public void deleteSchoolById(Long id) {
        repository
                .findById(id)
                .ifPresent(repository::delete);
    }
}
