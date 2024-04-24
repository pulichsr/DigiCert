/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digicert.library.dto;

import com.digicert.library.enums.ResponseCodesEnum;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Arrays;
import java.util.List;


@Data
public class ApiErrorResponse {

    @NotNull
    private String errorMessage;
    @NotNull
    private ResponseStatus response;


    public ApiErrorResponse(ResponseCodesEnum responseCodesEnum, String errorMessage) {

        this.response = new ResponseStatus(responseCodesEnum.getResponseCode(), responseCodesEnum.getHttpStatusCode());
        this.errorMessage = errorMessage;

    }

    /**
     * Use this constructor for defaulting to ResponseCodesEnum's message.
     *
     * @param responseCodesEnum - Required. This will default to success = true.
     */
    public ApiErrorResponse(ResponseCodesEnum responseCodesEnum) {
        this.response = new ResponseStatus(responseCodesEnum.getResponseCode(), responseCodesEnum.getHttpStatusCode());
        this.errorMessage = responseCodesEnum.getResponseMessage();
    }

}
