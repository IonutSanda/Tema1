package model;

import model.enumeration.ErrorCodes;

public class ValidationException extends Exception {

    private ErrorCodes code;

    public ValidationException(String message, ErrorCodes code) {
        super(message);
        this.code = code;
    }
}
