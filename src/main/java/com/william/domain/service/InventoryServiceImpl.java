package com.william.domain.service;

import com.william.domain.model.Inventory;
import com.william.domain.model.ValidationResult;
import com.william.domain.respository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    private InventoryValidator inventoryValidator = new InventoryValidator();

    @Autowired
    InventoryRepository inventoryRepository;

    @Override
    public Inventory createInventory(Inventory inventory) {
        ValidationResult result = inventoryValidator.validate(inventory);
        if (result.isValid()) {
            return inventoryRepository.save(inventory);
        } else
            throw new RuntimeException("createInventory Error" + result.getFailReasons());
    }

    @Override
    public List<Inventory> findInventories() {
        return inventoryRepository.findAll();
    }

    @Override
    public Inventory updateInventory(Inventory inventory) {
        ValidationResult result = inventoryValidator.validate(inventory);
        if (result.isValid())
            return inventoryRepository.save(inventory);
        else
            throw new RuntimeException("createInventory Error" + result.getFailReasons());
    }
}
