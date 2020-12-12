package com.william.domain.model;

import java.util.Objects;

public class Inventory {
    private String name;
    private String category;
    private String subCategory;
    private String quantity;

    public Inventory(String name, String category, String subCategory, String quantity) {
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
        Inventory inventory = (Inventory) o;
        return Objects.equals(name, inventory.name) && Objects.equals(category, inventory.category) && Objects.equals(subCategory, inventory.subCategory) && Objects.equals(quantity, inventory.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category, subCategory, quantity);
    }
}
