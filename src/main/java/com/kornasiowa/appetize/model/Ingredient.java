package com.kornasiowa.appetize.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class Ingredient implements Serializable {

    private String amount;
    private String ingredientName;

    public Ingredient() {
    }

    public Ingredient(String amount, String ingredientName) {
        this.amount = amount;
        this.ingredientName = ingredientName;
    }

}

