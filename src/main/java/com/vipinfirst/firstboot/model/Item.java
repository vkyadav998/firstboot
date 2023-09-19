package com.vipinfirst.firstboot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = "items")
public class Item {
    private String name;
    private double price;

    // Jackson annotations
    @JsonProperty("item_name")
    private String getName() {
        return name;
    }

    @JsonProperty("item_price")
    private double getPrice() {
        return price;
    }
}
