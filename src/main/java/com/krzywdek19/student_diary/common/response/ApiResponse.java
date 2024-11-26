package com.krzywdek19.student_diary.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.net.URL;
import java.util.List;

@AllArgsConstructor
@Data
public class ApiResponse<T> {
    private boolean success;
    private String message;
    private T data;
    private List<String> errors;
    private int errorCode;
    private long timeStamp;
    private String path;
}
