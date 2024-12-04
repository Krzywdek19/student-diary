package com.krzywdek19.student_diary.school;

import com.krzywdek19.student_diary.common.exception.ResponseUtil;
import com.krzywdek19.student_diary.common.response.ApiResponse;
import com.krzywdek19.student_diary.school.dto.SchoolDto;
import com.krzywdek19.student_diary.school.request.CreateSchoolRequest;
import com.krzywdek19.student_diary.school.request.UpdateSchoolRequest;
import com.krzywdek19.student_diary.school.service.SchoolService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/school")
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolService service;

    //CREATE
    @PostMapping
    public ResponseEntity<ApiResponse<SchoolDto>> createSchool(@RequestBody CreateSchoolRequest request, HttpServletRequest httpRequest){
        var school = service.createSchool(request);
        return ResponseEntity
                .status(201)
                .body(ResponseUtil.success(school, "School has been added successfully",httpRequest.getRequestURI()));
    }

    //READ
    @GetMapping(path = "/{id}")
    public ResponseEntity<ApiResponse<SchoolDto>> findSchoolById(@PathVariable Long id, HttpServletRequest request){
        var school = service.findSchoolById(id);
        return ResponseEntity
                .ok(ResponseUtil.success(school, "School has been found successfully", request.getRequestURI()));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<SchoolDto>>> findAllSchools(HttpServletRequest request){
        List<SchoolDto> schoolList = service.findAllSchools();
        return ResponseEntity
                .ok(ResponseUtil.success(schoolList,"Schools has been found successfully", request.getRequestURI()));
    }

    //UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<SchoolDto>> updateSchool(@PathVariable Long id, @RequestBody UpdateSchoolRequest request, HttpServletRequest httpRequest){
        var updatedSchool = service.changeSchoolDetails(id, request);
        return ResponseEntity
                .ok(ResponseUtil.success(updatedSchool,"Details has been changed successfully", httpRequest.getRequestURI()));
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteSchool(@PathVariable Long id, HttpServletRequest request){
        service.deleteSchoolById(id);
        return ResponseEntity
                .ok(ResponseUtil.success(null,"School with id: " + id + " has been deleted successfully", request.getRequestURI()));
    }
}
