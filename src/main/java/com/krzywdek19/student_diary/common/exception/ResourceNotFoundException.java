package com.krzywdek19.student_diary.common.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Class clazz, long id ) {
        super("Cannot find: " + clazz.getName() + " with id: " + id);
    }
}
