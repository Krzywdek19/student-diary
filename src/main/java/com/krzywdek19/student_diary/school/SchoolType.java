package com.krzywdek19.student_diary.school;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum SchoolType {
    LICEUM(4),
    TECHNIKUM(5),
    ZAWODOWKA(3),
    SZKOLA_PODSTAWOWA(8);

    private final int maxYear;

    public boolean isYearValid(int year){
        return year > 0 && year <= maxYear;
    }
}
