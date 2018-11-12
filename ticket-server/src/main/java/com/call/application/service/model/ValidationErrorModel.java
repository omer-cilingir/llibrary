package com.call.application.service.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ValidationErrorModel {

    private final List<FieldErrorModel> fieldErrors = new ArrayList<>();

    public ValidationErrorModel() {

    }

    public void addFieldError(String path, String message) {
        FieldErrorModel error = new FieldErrorModel(path, message);
        fieldErrors.add(error);
    }

    public List<FieldErrorModel> getFieldErrors() {
        return Collections.unmodifiableList(fieldErrors);
    }
}
