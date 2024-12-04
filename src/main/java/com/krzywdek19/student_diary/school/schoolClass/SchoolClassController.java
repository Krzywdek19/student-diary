package com.krzywdek19.student_diary.school.schoolClass;

import com.krzywdek19.student_diary.common.exception.ResponseUtil;
import com.krzywdek19.student_diary.common.response.ApiResponse;
import com.krzywdek19.student_diary.school.schoolClass.dto.SchoolClassDto;
import com.krzywdek19.student_diary.school.schoolClass.request.CreateSchoolClassRequest;
import com.krzywdek19.student_diary.school.schoolClass.request.UpdateSchoolClassRequest;
import com.krzywdek19.student_diary.school.schoolClass.service.SchoolClassService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/class/school/{schoolId}/class")
public class SchoolClassController {
    private final SchoolClassService service;

    //CREATE
    @PostMapping
    public ResponseEntity<ApiResponse<SchoolClassDto>> createSchoolClass(@PathVariable Long schoolId, @RequestBody CreateSchoolClassRequest request, HttpServletRequest httpServletRequest){
        var schoolClass = service.createSchoolClass(schoolId, request);
        return ResponseEntity
                .status(202)
                .body(ResponseUtil.success(schoolClass, "School class has been created successfully", httpServletRequest.getRequestURI()));
    }

    //READ
    @GetMapping("/class/{id}")
    public ResponseEntity<ApiResponse<SchoolClassDto>> findSchoolClassById(@PathVariable Long schoolId, @PathVariable Long id, HttpServletRequest httpServletRequest){
        var schoolClass = service.findSchoolClassById(schoolId, id);
        return ResponseEntity
                .ok(ResponseUtil.success(schoolClass, "School class has been found successfully", httpServletRequest.getRequestURI()));
    }

    @GetMapping()
    public ResponseEntity<ApiResponse<List<SchoolClassDto>>> findSchoolClassesBySchoolId(@PathVariable Long schoolId, HttpServletRequest httpServletRequest){
        return ResponseEntity
                .ok(ResponseUtil.success(service.findSchoolClassesBySchoolId(schoolId), "School classes have been found successfully", httpServletRequest.getRequestURI()));
    }

    //UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<SchoolClassDto>> updateSchoolClass(@PathVariable Long schoolId, @PathVariable Long id, @RequestBody UpdateSchoolClassRequest request, HttpServletRequest httpServletRequest){
        var schoolClass = service.changeSchoolClassDetails(schoolId, id, request);
        return ResponseEntity
                .ok(ResponseUtil.success(schoolClass, "School class has been updated successfully", httpServletRequest.getRequestURI()));
    }

    //DELETE
    @DeleteMapping("/id}")
    public ResponseEntity<ApiResponse<Void>> deleteSchoolClassById(@PathVariable Long schoolId, @PathVariable Long id, HttpServletRequest httpServletRequest) {
        service.deleteSchoolClassById(schoolId, id);
        return ResponseEntity
                .ok(ResponseUtil.success(null, "School class has been deleted successfully", httpServletRequest.getRequestURI()));
    }
}

