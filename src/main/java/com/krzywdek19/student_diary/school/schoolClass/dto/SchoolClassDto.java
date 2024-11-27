package com.krzywdek19.student_diary.school.schoolClass.dto;

import com.krzywdek19.student_diary.school.dto.SchoolDto;

public record SchoolClassDto(Long id, int classGrade, char classSign, SchoolDto schoolDto) {

    public String getFullClassName(){
        return "" + classGrade + classSign;
    }
}
