package com.krzywdek19.student_diary.school.service;

import com.krzywdek19.student_diary.common.Address;
import com.krzywdek19.student_diary.common.exception.ResourceNotFoundException;
import com.krzywdek19.student_diary.school.School;
import com.krzywdek19.student_diary.school.SchoolMapper;
import com.krzywdek19.student_diary.school.SchoolRepository;
import com.krzywdek19.student_diary.school.SchoolType;
import com.krzywdek19.student_diary.school.dto.SchoolDto;
import com.krzywdek19.student_diary.school.request.CreateSchoolRequest;
import com.krzywdek19.student_diary.school.request.UpdateSchoolRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SchoolServiceImpl implements SchoolService{
    private final SchoolRepository repository;
    private final SchoolMapper mapper;

    //CREATE
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

    //READ
    @Override
    public SchoolDto findSchoolById(Long id) {
        var school = repository
                .findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(School.class, id));
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

    //UPDATE
    @Override
    @Transactional
    public SchoolDto changeSchoolDetails(Long id, UpdateSchoolRequest request) {
        var school = repository
                .findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(School.class ,id));
        if(request.schoolType().isPresent() && !request.schoolType().get().equals(school.getSchoolType())){
            school.setSchoolType(request.schoolType().get());
        }
        if(request.address().isPresent() && !request.address().get().equals(school.getAddress())) {
            school.setAddress(request.address().get());
        }
        if(request.name().isPresent() && !request.name().get().equals(school.getName())) {
            school.setName(request.name().get());
        }
        return mapper
                .schoolToSchoolDto(school);
    }

    //DELETE
    @Override
    public void deleteSchoolById(Long id) {
        repository
                .findById(id)
                .ifPresent(repository::delete);
    }
}
