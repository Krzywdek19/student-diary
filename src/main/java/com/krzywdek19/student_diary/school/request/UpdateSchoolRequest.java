package com.krzywdek19.student_diary.school.request;

import com.krzywdek19.student_diary.common.Address;
import com.krzywdek19.student_diary.school.SchoolType;
import jakarta.annotation.Nullable;

import java.util.Optional;

public record UpdateSchoolRequest(
        Optional<String> name,
        Optional<Address> address,
        Optional<SchoolType> schoolType
        ) {
}
