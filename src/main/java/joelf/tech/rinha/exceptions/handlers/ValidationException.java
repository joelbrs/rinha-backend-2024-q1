package joelf.tech.rinha.exceptions.handlers;

import java.util.*;

import java.time.Instant;

public class ValidationException extends ResponseException {
    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationException(Instant timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
    }

    public List<FieldMessage> getErrors() {
        return Collections.unmodifiableList(errors);
    }

    public void addError(String fieldName, String message) {
        errors.add(new FieldMessage(fieldName, message));
    }
}