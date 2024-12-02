package com.krzywdek19.student_diary.school.dto;

import com.krzywdek19.student_diary.common.Address;
import com.krzywdek19.student_diary.school.schoolClass.SchoolClass;

import java.util.List;

public record SchoolDto (Long id, String name, Address address, String schoolType, int studentCount, int classCount, List<SchoolClass> schoolClasses){}
//todo SchoolClasses -> SchoolClassDTO
