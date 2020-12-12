package com.william.domain.service;

import com.william.domain.model.Inventory;
import com.william.domain.model.ValidationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class InventoryValidator implements Validator<Inventory> {

    @Autowired
    List<Validator> validators = Arrays.asList(
            new InventoryCategoryValidator()
    );

    @Override
    public ValidationResult validate(Inventory model) {
        List<ValidationResult> results = validators.stream()
                .map(validator -> validator.validate(model))
                .collect(Collectors.toList());

        boolean valid = results.stream()
                .map(x -> x.isValid())
                .reduce(true, (x, y) -> (x && y));

        List<String> reasons = results.stream().flatMap(x -> x.getFailReasons().stream()).collect(Collectors.toList());

        return new ValidationResult(valid, reasons);
    }
}
