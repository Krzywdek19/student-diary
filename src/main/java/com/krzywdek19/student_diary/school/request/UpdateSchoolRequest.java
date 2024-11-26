package com.krzywdek19.student_diary.school.request;

import com.krzywdek19.student_diary.common.Address;
import com.krzywdek19.student_diary.school.SchoolType;
import jakarta.annotation.Nullable;

public record UpdateSchoolRequest(
        Long id,
        @Nullable String name,
        @Nullable Address address,
        @Nullable SchoolType schoolType
        ) {
}
