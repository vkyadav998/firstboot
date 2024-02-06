package com.vipinfirst.firstboot.service;

import com.vipinfirst.firstboot.model.Item;
import com.vipinfirst.firstboot.repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    private static final Logger FBLogger = LoggerFactory.getLogger("firstboot");

    public ResponseEntity<Item> addItem(Item item) {
        try {
            if(item != null && item.getName() != null && item.getPrice() > 0){
                Item addedItem = itemRepository.save(item);
                if (addedItem != null) {
                    FBLogger.info("[ITEM SERVICE] Item added successfully: [{}]", addedItem);
                    return new ResponseEntity<>(addedItem, HttpStatus.CREATED);
                } else {
                    // Handle failure to add item
                    FBLogger.error("[ITEM SERVICE] Failed to add item");
                    throw new RuntimeException("Failed to add item: addedItem is null");
                }
            }else{
                throw new RuntimeException("Parameter of Item to be added should not null \n"+ item);
            }
        } catch (Exception e) {
            // Handle exception
            FBLogger.error("[ITEM SERVICE] Error in add item [{}]\n", item, e);
            return null;
        }
//        return ResponseEntity<Item>;
    }
}
