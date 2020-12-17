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
@Table(name = "recipe")
public class Recipe implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rid")
    private long rid;

    private String uid;
    private String name;
    private String category;
    private int calories;
    private int portions;
    private int cookingTime;
    private boolean favorite;
    private String image;

    @ElementCollection
    private List<Ingredient> ingredientList = new ArrayList<Ingredient>();

    @ElementCollection
    private List<Step> stepList = new ArrayList<Step>();

    public Recipe() {
    }

    public Recipe(String uid, String name, String category, int calories, int portions, int cookingTime, boolean favorite, String image, List<Ingredient> ingredientList, List<Step> stepList) {
        this.uid = uid;
        this.name = name;
        this.category = category;
        this.calories = calories;
        this.portions = portions;
        this.cookingTime = cookingTime;
        this.favorite = favorite;
        this.image = image;
        this.ingredientList = ingredientList;
        this.stepList = stepList;
    }

    public Recipe(long rid, String uid, String name, String category, int calories, int portions, int cookingTime, boolean favorite, String image, List<Ingredient> ingredientList, List<Step> stepList) {
        this.rid = rid;
        this.uid = uid;
        this.name = name;
        this.category = category;
        this.calories = calories;
        this.portions = portions;
        this.cookingTime = cookingTime;
        this.favorite = favorite;
        this.image = image;
        this.ingredientList = ingredientList;
        this.stepList = stepList;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getRid() {
        return rid;
    }

    public void setRid(long rid) {
        this.rid = rid;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getPortions() {
        return portions;
    }

    public void setPortions(int portions) {
        this.portions = portions;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public List<Step> getStepList() {
        return stepList;
    }

    public void setStepList(List<Step> stepList) {
        this.stepList = stepList;
    }

}
