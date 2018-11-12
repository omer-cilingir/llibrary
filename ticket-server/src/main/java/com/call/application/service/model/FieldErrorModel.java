package com.call.application.service.model;

public final class FieldErrorModel {

    private final String field;

    private final String message;

    public FieldErrorModel(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }


}
