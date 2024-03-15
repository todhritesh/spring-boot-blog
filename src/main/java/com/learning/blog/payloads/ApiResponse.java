package com.learning.blog.payloads;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
    private String message;
    private boolean status;
    private Object data;
    private Map<String,String> error;
    
    public ApiResponse(String message, boolean status) {
        this.message = message;
        this.status = status;
    }
    
    public ApiResponse(String message, boolean status , Object data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }
    
    public ApiResponse(String message, boolean status , Map<String,String> error) {
        this.message = message;
        this.status = status;
        this.error = error;
    }
}
