package com.krzywdek19.student_diary.school.request;

import com.krzywdek19.student_diary.common.Address;
import com.krzywdek19.student_diary.school.SchoolType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

public record CreateSchoolRequest (
    String name,
    Address address,
    SchoolType schoolType
){}
