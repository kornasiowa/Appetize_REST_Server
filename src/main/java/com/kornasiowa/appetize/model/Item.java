package com.kornasiowa.appetize.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class Item implements Serializable {

    private boolean bought;
    private String itemName;

    public Item() {
    }

    public Item(boolean bought, String itemName) {
        this.bought = bought;
        this.itemName = itemName;
    }

}

