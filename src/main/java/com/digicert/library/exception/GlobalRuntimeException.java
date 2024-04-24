/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digicert.library.exception;

import com.digicert.library.enums.ResponseCodesEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false)
public class GlobalRuntimeException extends RuntimeException {

    private String responseCode;
    private String responseMessage;
    private Integer httpStatusCode;
    private ResponseCodesEnum errEnum;

    /**
     * Helps to customize the message. Everything else should come from enum.
     *
     * @param errEnum - required
     * @param responseMessage - required
     */
    public GlobalRuntimeException(ResponseCodesEnum errEnum, String responseMessage) {
        this.responseCode = errEnum.getResponseCode();
        this.responseMessage = responseMessage;
        this.httpStatusCode = errEnum.getHttpStatusCode();
        this.errEnum = errEnum;
    }

    /**
     * Simple constructor that creates responses based on enum data.
     *
     * @param errEnum - required
     */
    public GlobalRuntimeException(ResponseCodesEnum errEnum) {
        this.responseCode = errEnum.getResponseCode();
        this.responseMessage = errEnum.getResponseMessage();
        this.httpStatusCode = errEnum.getHttpStatusCode();
        this.errEnum = errEnum;
    }

}
