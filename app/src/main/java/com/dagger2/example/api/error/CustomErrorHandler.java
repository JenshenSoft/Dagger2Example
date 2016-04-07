package com.dagger2.example.api.error;

import retrofit.ErrorHandler;
import retrofit.RetrofitError;

public class CustomErrorHandler implements ErrorHandler {

    @Override
    public Throwable handleError(RetrofitError cause) {
        return genApiException(cause);
    }

    private ApiException genApiException(RetrofitError cause) {
        ApiException apiException;
        RestError restError = (RestError) cause.getBodyAs(RestError.class);
        if (restError == null) {
            apiException = new ApiException(-1, cause.getMessage());
        } else {
            apiException = new ApiException(restError.code, restError.error);
        }
        return apiException;
    }
}
