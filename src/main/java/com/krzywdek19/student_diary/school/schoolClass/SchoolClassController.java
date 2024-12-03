package com.krzywdek19.student_diary.school.schoolClass;

import com.krzywdek19.student_diary.common.exception.ResponseUtil;
import com.krzywdek19.student_diary.common.response.ApiResponse;
import com.krzywdek19.student_diary.school.schoolClass.dto.SchoolClassDto;
import com.krzywdek19.student_diary.school.schoolClass.request.CreateSchoolClassRequest;
import com.krzywdek19.student_diary.school.schoolClass.service.SchoolClassService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/class")
public class SchoolClassController {
    private final SchoolClassService service;

    @PostMapping
    public ResponseEntity<ApiResponse<SchoolClassDto>> createSchoolClass(@RequestBody CreateSchoolClassRequest request, HttpServletRequest httpServletRequest){
        var schoolClass = service.createSchoolClass(request);
        return ResponseEntity
                .status(202)
                .body(ResponseUtil.success(schoolClass, "School class has been created successfully", httpServletRequest.getRequestURI()));
    }
}
