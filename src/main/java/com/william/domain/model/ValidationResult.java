package com.william.domain.model;

import java.util.List;

public class ValidationResult {
    private boolean valid = false;
    private List<String> failReasons;

    public ValidationResult(boolean valid, List<String> failReasons) {
        this.valid = valid;
        this.failReasons = failReasons;
    }

    public boolean isValid() {
        return valid;
    }


    public List<String> getFailReasons() {
        return failReasons;
    }
}
