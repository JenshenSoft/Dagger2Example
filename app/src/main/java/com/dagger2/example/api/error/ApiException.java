package com.dagger2.example.api.error;

public class ApiException extends Exception {

    public ApiException(int code, String error) {
        this.code = code;
        this.error = error;
    }

    private int code;
    private String error;

    @Override
    public String getMessage() {
        return error;
    }
}
