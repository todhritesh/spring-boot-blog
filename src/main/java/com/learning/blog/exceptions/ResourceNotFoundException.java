package com.learning.blog.exceptions;


public class ResourceNotFoundException extends RuntimeException {
    private String resourceName;
    private String fieldName;
    private long fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName , long fieldValue){
        super(String.format("%s not found with %s : %s",resourceName,fieldName,fieldValue));
        this.fieldName = fieldName;
        this.resourceName = resourceName;
        this.fieldValue = fieldValue;
    }

}
