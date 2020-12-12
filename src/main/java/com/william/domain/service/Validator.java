package com.william.domain.service;

import com.william.domain.model.ValidationResult;

public interface Validator<T> {
    ValidationResult validate(T model);
}
