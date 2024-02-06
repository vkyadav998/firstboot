package com.vipinfirst.firstboot.controller;

import com.vipinfirst.firstboot.model.Item;
import com.vipinfirst.firstboot.repository.ItemRepository;
import com.vipinfirst.firstboot.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemService itemService;

    private static final Logger FBLogger = LoggerFactory.getLogger("firstboot");

    @GetMapping("/getItems")
    public List<Item> getAllItems() {
        try {
            FBLogger.info("[ITEM CONTROLLER] Fetching Items");
            return itemRepository.findAll();
        }catch (Exception e){
            FBLogger.error("[ITEM CONTROLLER] Error in fetching items : \n", e);
        }
        return null;
    }

    @PostMapping("/addItem")
    public ResponseEntity<Item> addItemInList(@RequestBody Item item){
        try {
            FBLogger.info("[ITEM CONTROLLER] Adding Items : [{}]\n", item);
            return itemService.addItem(item);
        }catch (Exception e){
            FBLogger.error("[ITEM CONTROLLER] Error in adding items : [{}]\n", item, e);
        }
        return null;
    }
}

