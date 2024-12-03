package com.krzywdek19.student_diary.school.dto;

import com.krzywdek19.student_diary.common.Address;
import com.krzywdek19.student_diary.school.schoolClass.SchoolClass;
import com.krzywdek19.student_diary.school.schoolClass.dto.SchoolClassDto;

import java.util.List;

public record SchoolDto (Long id, String name, Address address, String schoolType, int studentCount, int classCount, List<SchoolClassDto> schoolClasses){}
//todo SchoolClasses -> SchoolClassDTO
