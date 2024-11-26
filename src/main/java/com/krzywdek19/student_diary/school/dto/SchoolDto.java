package com.krzywdek19.student_diary.school.dto;

import com.krzywdek19.student_diary.common.Address;

public record SchoolDto (Long id, String name, Address address, String schoolType, int studentCount, int classCount){}
