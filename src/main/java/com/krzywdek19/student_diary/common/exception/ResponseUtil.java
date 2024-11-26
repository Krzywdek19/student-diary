package com.krzywdek19.student_diary.common.exception;

import com.krzywdek19.student_diary.common.response.ApiResponse;

import java.util.Collections;
import java.util.List;

public class ResponseUtil {
    public static <T>ApiResponse<T> success(T data, String message,String path){
        return new ApiResponse<>(true, message,
                data, null,0,System.currentTimeMillis(),path);
    }

    public static <T> ApiResponse<T> error(List<String> errors, String message, int errorCode, String path){
        return new ApiResponse<>(false,message,null,errors,errorCode,System.currentTimeMillis(),path);
    }

    public static <T> ApiResponse<T> error(String error, String message, int errorCode, String path){
        return error(Collections.singletonList(error), message, errorCode, path);
    }
}
