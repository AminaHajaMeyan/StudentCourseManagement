package com.example.StudentCourseManagement.util;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class StandardResponse {

    private String message;
    private int status;
    private Object data;

    public StandardResponse(String message, int status, Object data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }

}
