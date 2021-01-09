package com.william.domain.respository;

import com.william.domain.model.Inventory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory, Long> {

    List<Inventory> findAll();
}
