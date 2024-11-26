package com.krzywdek19.student_diary.school;

import com.krzywdek19.student_diary.school.dto.SchoolDto;
import com.krzywdek19.student_diary.school.request.CreateSchoolRequest;
import com.krzywdek19.student_diary.school.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/school")
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolService service;

    //CREATE
    @PostMapping
    public ResponseEntity<SchoolDto> createSchool(@RequestBody CreateSchoolRequest request){
        System.out.println(request);
        return ResponseEntity
                .ok(service.addSchool(request));
    }
}
