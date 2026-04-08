package com.software_architecture_patterns.exceptons;

public class NonExistingShortCodeException extends RuntimeException {
    public NonExistingShortCodeException(String message) {
        super(message);
    }
}
