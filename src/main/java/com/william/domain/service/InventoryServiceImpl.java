package com.william.domain.service;

import com.william.domain.model.Inventory;
import com.william.domain.model.ValidationResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    private InventoryValidator inventoryValidator = new InventoryValidator();

    @Override
    public Inventory createInventory(Inventory inventory) {
        ValidationResult result = inventoryValidator.validate(inventory);
        if (result.isValid())
            return inventory;
        else
            throw new RuntimeException("createInventory Error" + result.getFailReasons());
    }

    @Override
    public List<Inventory> findInventories() {
        return new ArrayList<>();
    }

    @Override
    public Inventory updateInventory(Inventory inventory) {
        ValidationResult result = inventoryValidator.validate(inventory);
        if (result.isValid())
            return inventory;
        else
            throw new RuntimeException("createInventory Error" + result.getFailReasons());
    }
}
