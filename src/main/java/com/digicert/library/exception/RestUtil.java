/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digicert.library.exception;

import com.digicert.library.dto.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class RestUtil {

    public static ResponseEntity toErrorResponseEntity(ApiErrorResponse apiErrorResponse) {
        return ResponseEntity
                .status(HttpStatus.valueOf(apiErrorResponse.getResponse().getHttpStatus()))
                .body(apiErrorResponse);
    }


}
