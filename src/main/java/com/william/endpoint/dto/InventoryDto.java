package com.william.endpoint.dto;

import com.william.domain.model.Inventory;

import javax.persistence.Entity;
import java.util.Objects;

public class InventoryDto {
    private String name;
    private String category;
    private String subCategory;
    private String quantity;

    public InventoryDto(String name, String category, String subCategory, String quantity) {
        this.name = name;
        this.category = category;
        this.subCategory = subCategory;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryDto inventory = (InventoryDto) o;
        return Objects.equals(name, inventory.name) && Objects.equals(category, inventory.category) && Objects.equals(subCategory, inventory.subCategory) && Objects.equals(quantity, inventory.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category, subCategory, quantity);
    }

    public Inventory toInventory() {
        return new Inventory(name,category, subCategory, quantity);
    }

    public static InventoryDto create(Inventory item) {
        return new InventoryDto(item.getName(),item.getCategory(), item.getSubCategory(), item.getQuantity());
    }
}
