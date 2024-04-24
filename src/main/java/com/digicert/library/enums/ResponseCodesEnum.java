package com.digicert.library.enums;

import org.springframework.http.HttpStatus;

/**
 * This represents all the response codes that are possible in the Server

 *
 */
public enum ResponseCodesEnum {
    GENERAL_UNABLE_TO_PROCESS_HOST_RSP(500, "We are unable to process your request at the moment. Please try again later.", HttpStatus.BAD_GATEWAY),
    BOOK_RECORD_NOT_FOUND_FOR_GIVEN_ID(100, "Book Record not found for given id", HttpStatus.BAD_REQUEST);
    private final String responseCode;
    private final Integer httpStatusCode;
    private final String responseMessage;
// ---------------------------------------------------------------------------------------------------------    

    /**
     * Creates the enum with responseCode and responseDesc.
     */
    private ResponseCodesEnum(int responseCode, String responseMessage, HttpStatus httpStatus) {
        this.responseCode = String.valueOf(responseCode);
        this.responseMessage = responseMessage;
        this.httpStatusCode = httpStatus.value();
    }

// ---------------------------------------------------------------------------------------------------------
    /**
     * Returns the responseCode for Enum
     *
     * @return errorCode
     */
    public String getResponseCode() {
        return responseCode;
    }

    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }



    @Override
    public String toString() {
        return "ResponseCodesEnum{" + "responseCode=" + responseCode + ", httpStatusCode=" + httpStatusCode + ", responseMessage=" + responseMessage + '}';
    }

}
