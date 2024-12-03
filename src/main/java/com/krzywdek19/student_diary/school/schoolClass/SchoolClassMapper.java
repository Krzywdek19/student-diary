package com.krzywdek19.student_diary.school.schoolClass;

import com.krzywdek19.student_diary.school.schoolClass.dto.SchoolClassDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SchoolClassMapper {
    SchoolClassDto schoolClassToSchoolClassDto(SchoolClass schoolClass);
}
