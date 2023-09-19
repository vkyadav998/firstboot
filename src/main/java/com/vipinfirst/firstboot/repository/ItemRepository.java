package com.vipinfirst.firstboot.repository;

import com.vipinfirst.firstboot.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, String> {
}
