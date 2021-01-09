package com.william.endpoint;

import com.william.domain.model.Inventory;
import com.william.domain.service.InventoryService;
import com.william.endpoint.dto.InventoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    public class GreetingController {

        @MessageMapping("/create-inventory")
        @SendTo("/topic/create-inventory")
        public InventoryDto createInventory(InventoryDto message) throws Exception {
            Inventory item = inventoryService.createInventory(message.toInventory());
            return InventoryDto.create(item);
        }

        @MessageMapping("/save-inventory")
        @SendTo("/topic/save-inventory")
        public InventoryDto updateInventory(InventoryDto message) throws Exception {
            Inventory item = inventoryService.updateInventory(message.toInventory());
            return InventoryDto.create(item);
        }

        @MessageMapping("/list-inventory")
        @SendTo("/topic/list-inventory")
        public List<InventoryDto> listInventory() throws Exception {
            List<Inventory> items = inventoryService.findInventories();
            return items.stream().map(InventoryDto::create).collect(Collectors.toList());
        }
    }
}
