package com.krzywdek19.student_diary.school.schoolClass.request;

public record CreateSchoolClassRequest(long schoolId, int classGrade, char classSign) {
}
