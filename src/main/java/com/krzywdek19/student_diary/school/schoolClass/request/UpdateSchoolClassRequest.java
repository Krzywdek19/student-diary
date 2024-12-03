package com.krzywdek19.student_diary.school.schoolClass.request;

public record UpdateSchoolClassRequest(long schoolId, int classGrade, char classSign) {
}
