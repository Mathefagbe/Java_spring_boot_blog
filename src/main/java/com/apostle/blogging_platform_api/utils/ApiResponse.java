package com.apostle.blogging_platform_api.utils;

import lombok.Data;

@Data
public class ApiResponse {

    private String message;
    private Object data;
    private String status;

    public ApiResponse(String message, Object data, String status) {
        this.message = message;
        this.data = data;
        this.status = status;
    }

}
