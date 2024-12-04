package com.krzywdek19.student_diary.common.exception;

public class ResourceNotBelongException extends RuntimeException {
    public ResourceNotBelongException(Long resourceId, Class resourceClass, Long parentEntity, Class parentEntityClass) {
        super("Resource of type: " + resourceClass + " with id: " + resourceId + " does not belong to: "
        + parentEntityClass + " with id: " + parentEntity);
    }
}
