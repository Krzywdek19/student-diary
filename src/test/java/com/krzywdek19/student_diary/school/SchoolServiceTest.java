package com.krzywdek19.student_diary.school;

import com.krzywdek19.student_diary.common.Address;
import com.krzywdek19.student_diary.school.dto.SchoolDto;
import com.krzywdek19.student_diary.school.request.CreateSchoolRequest;
import com.krzywdek19.student_diary.school.service.SchoolService;
import com.krzywdek19.student_diary.school.service.SchoolServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class SchoolServiceTest {
    @InjectMocks
    private SchoolServiceImpl schoolService;

    @Mock
    private SchoolRepository schoolRepository;

    @Mock
    private SchoolMapper schoolMapper;


    @Test
    void shouldCreateSchoolSuccessfully() {
        CreateSchoolRequest createSchoolRequest = new CreateSchoolRequest("school name",new Address("city","street", 0),SchoolType.SZKOLA_PODSTAWOWA);
        School school = new School(null,"school name",new Address("city","street", 0),SchoolType.SZKOLA_PODSTAWOWA,null,0,0);
        School savedSchool = new School(1L,"school name",new Address("city","street", 0),SchoolType.SZKOLA_PODSTAWOWA,null,0,0);
        SchoolDto expectedDto = new SchoolDto(1L,"school name",new Address("city","street", 0),SchoolType.SZKOLA_PODSTAWOWA.name(),null,0,0);

        Mockito.when(schoolMapper.createSchoolRequestToSchool(createSchoolRequest)).thenReturn(school);
        Mockito.when(schoolRepository.save(school)).thenReturn(savedSchool);
        Mockito.when(schoolMapper.schoolToSchoolDto(savedSchool)).thenReturn(expectedDto);

        SchoolDto result = schoolService.createSchool(createSchoolRequest);

        assertNotNull(result);
        assertEquals(expectedDto, result);

        Mockito.verify(schoolMapper).createSchoolRequestToSchool(createSchoolRequest);
        Mockito.verify(schoolRepository).save(school);
        Mockito.verify(schoolMapper).schoolToSchoolDto(savedSchool);
    }
}
