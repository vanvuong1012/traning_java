package com.example.amit_training.aop;

import com.example.amit_training.model.response.BaseResponse;
import com.example.amit_training.model.utils.ApiException;
import com.example.amit_training.model.utils.ERROR;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandle {
    private static final Logger LOGGER = LogManager.getLogger(GlobalExceptionHandle.class);

    @ExceptionHandler(ApiException.class)
    @ResponseBody
    public ResponseEntity<BaseResponse<String>> handleCustomizedException(ApiException e) {
        LOGGER.info("Exception {}", e.getMessage());
        return new ResponseEntity<>(new BaseResponse<>(e.getCode(), e.getMessage()), HttpStatus.OK);
    }


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<BaseResponse<String>> handleInternalException(Exception ex) {
        try {
            LOGGER.error("Exception ", ex);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(new BaseResponse<>(ERROR.SYSTEM_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}


