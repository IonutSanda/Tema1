package model.enumeration;

public enum ErrorCodes {

    HOTEL_NOT_FOUND("The hotel has not been found",801),
    EMPLOYEE_NOT_FOUND("The employee has not been found",803),
    CLIENT_NOT_FOUND("The client has not been found",804),
    DETAILS_NOT_FOUND("No details entered for the Hotel",802),
    HOTEL_DETAILS_NOT_FOUND("There are no details of the hotel to add",805),
    CLIENT_DETAILS_NOT_FOUND("There are no client details of the client to add",806),
    EMPLOYEE_DETAILS_NOT_FOUND("There are no employee details of the client to add",806),
    AGE_NEGATIVE("Age can not be negative",807),
    RATING_NEGATIVE("Rating must be positive",808);

    private int code;
    private String message;

    ErrorCodes(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public String getMessage(){
        return message;
    }

    public String getErrorcode(){
        return message + "_" + code;
    }
}
