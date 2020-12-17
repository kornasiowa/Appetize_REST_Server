package com.kornasiowa.appetize.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ToString
@EqualsAndHashCode
@Entity
@Table(name = "shoppinglist")
public class ShoppingList implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lid")
    private long lid;

    private String uid;
    private String name;

    @ElementCollection
    private List<Item> itemsList = new ArrayList<Item>();

    public ShoppingList() {
    }

    public ShoppingList(String uid, String name, List<Item> itemsList) {
        this.uid = uid;
        this.name = name;
        this.itemsList = itemsList;
    }

    public ShoppingList(long lid, String uid, String name, List<Item> itemsList) {
        this.lid = lid;
        this.uid = uid;
        this.name = name;
        this.itemsList = itemsList;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getLid() {
        return lid;
    }

    public void setLid(long lid) {
        this.lid = lid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<Item> itemsList) {
        this.itemsList = itemsList;
    }

}
