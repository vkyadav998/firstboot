package com.vipinfirst.firstboot.service;

import com.vipinfirst.firstboot.model.Item;
import org.springframework.http.ResponseEntity;

public abstract class ItemService {
    public abstract ResponseEntity<Item>  addItem(Item item);
}
