package com.krzywdek19.student_diary.school.schoolClass.request;
import java.util.Optional;

public record UpdateSchoolClassRequest (
        Optional<Integer> classGrade,
        Optional<Character> classSign
) {
}
