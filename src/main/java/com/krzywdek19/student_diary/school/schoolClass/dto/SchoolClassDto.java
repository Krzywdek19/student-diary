package com.krzywdek19.student_diary.school.schoolClass.dto;

import lombok.Data;

@Data
public class SchoolClassDto {
    private Long id;
    private int classGrade;
    private char classSign;
    private String fullName;

    public SchoolClassDto(char classSign, int classGrade, Long id) {
        this.id = id;
        this.classGrade = classGrade;
        this.classSign = classSign;
        fullName = classGrade + String.valueOf(classSign);
    }
}
