package com.william.domain.service;

import com.william.domain.model.Inventory;
import com.william.domain.model.ValidationResult;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;

@Validated
public class InventoryCategoryValidator implements Validator<Inventory> {

    @Override
    public ValidationResult validate(Inventory model) {
        // Check the subCat belong to Cat or not
        return new ValidationResult(true, new ArrayList<>());
    }
}
