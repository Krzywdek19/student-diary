package com.krzywdek19.student_diary.school.schoolClass.dto;

import com.krzywdek19.student_diary.school.dto.SchoolDto;
import com.krzywdek19.student_diary.school.schoolClass.SchoolClass;

import java.util.List;

public record SchoolClassDto(Long id, int classGrade, char classSign, SchoolDto schoolDto, List<SchoolClass> schoolClasses) {

    public String getFullClassName(){
        return "" + classGrade + classSign;
    }
}
