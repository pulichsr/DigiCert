/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digicert.library.exception;

import com.digicert.library.dto.ApiErrorResponse;
import com.digicert.library.enums.ResponseCodesEnum;
import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;
import java.util.Arrays;


@RestControllerAdvice
public class ControllerAdviceHandler extends ResponseEntityExceptionHandler {

    @ResponseBody
    @ExceptionHandler(GlobalRuntimeException.class)
    ResponseEntity<?> handleGlobalRuntimeException(HttpServletRequest request, GlobalRuntimeException ex) {
        return RestUtil
                .toErrorResponseEntity(new ApiErrorResponse(ex.getErrEnum(), ex.getResponseMessage()));
    }

    @ResponseBody
    @ExceptionHandler(IOException.class)
    ResponseEntity<?> handleGlobalRuntimeException(HttpServletRequest request, IOException ex) {
        return RestUtil
                .toErrorResponseEntity(new ApiErrorResponse(ResponseCodesEnum.GENERAL_UNABLE_TO_PROCESS_HOST_RSP));
    }

    @ResponseBody
    @ExceptionHandler(GenericJDBCException.class)
    ResponseEntity<?> handleGenericJDBCException(HttpServletRequest request, GenericJDBCException ex) {
        return RestUtil
                .toErrorResponseEntity(new ApiErrorResponse(ResponseCodesEnum.GENERAL_UNABLE_TO_PROCESS_HOST_RSP));
    }

    @ResponseBody
    @ExceptionHandler(DataAccessException.class)
    ResponseEntity<?> handleGenericJDBCException(HttpServletRequest request, DataAccessException ex) {
        return RestUtil
                .toErrorResponseEntity(new ApiErrorResponse(ResponseCodesEnum.GENERAL_UNABLE_TO_PROCESS_HOST_RSP));
    }

    @ResponseBody
    @ExceptionHandler(HttpClientErrorException.class)
    ResponseEntity<?> handleHttpClientErrorException(HttpServletRequest request, HttpClientErrorException ex) {
        return RestUtil
                .toErrorResponseEntity(new ApiErrorResponse(ResponseCodesEnum.GENERAL_UNABLE_TO_PROCESS_HOST_RSP));
    }
}
