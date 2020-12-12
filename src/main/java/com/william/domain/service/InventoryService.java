package com.william.domain.service;

import com.william.domain.model.Inventory;

import java.util.List;

public interface InventoryService {
    Inventory createInventory(Inventory inventory);
    List<Inventory> findInventories();
    Inventory updateInventory(Inventory inventory);
}
