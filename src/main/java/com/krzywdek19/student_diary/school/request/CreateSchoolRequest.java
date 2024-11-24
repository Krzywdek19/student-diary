package com.krzywdek19.student_diary.school.request;

import com.krzywdek19.student_diary.common.Address;
import com.krzywdek19.student_diary.school.SchoolType;

public class CreateSchoolRequest {
    private String name;
    private Address address;
    private SchoolType schoolType;
}
