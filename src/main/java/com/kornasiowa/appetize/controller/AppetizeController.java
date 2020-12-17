package com.kornasiowa.appetize.controller;

import com.kornasiowa.appetize.model.Item;
import com.kornasiowa.appetize.model.Recipe;
import com.kornasiowa.appetize.model.ShoppingList;
import com.kornasiowa.appetize.repo.RecipeRepository;

import com.kornasiowa.appetize.repo.ShoppingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.kornasiowa.appetize.exception.NotFoundException;

import java.util.List;

@RestController
@RequestMapping("/appetize")
public class AppetizeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private ShoppingListRepository shoppingListRepository;

    @GetMapping("/recipes")
    public List<Recipe> getAllRecipes() {
        return (List<Recipe>) recipeRepository.findAll();
    }

    @GetMapping("/recipes/{uid}/fav/{fav}")
    public List<Recipe> getUserRecipeByFavorite(@PathVariable("uid") String uid, @PathVariable("fav") boolean fav) {
        return recipeRepository.findByUidAndFavorite(uid, fav);
    }

    @GetMapping("/recipes/{uid}/category/{category}")
    public List<Recipe> getUserRecipeByCategory(@PathVariable("uid") String uid, @PathVariable("category") String category) {
        return recipeRepository.findByUidAndCategory(uid, category);
    }

    @GetMapping("/recipe/{rid}")
    public Recipe getRecipeById(@PathVariable long rid) {
        return recipeRepository.findById(rid).orElseThrow(() -> new NotFoundException("No recipe with related ID:" + rid));
    }

    @PutMapping("/recipe/{rid}")
    public Recipe updateRecipe(@PathVariable long rid, @RequestBody Recipe updatedRecipe) {
        return recipeRepository.findById(rid)
                .map(recipe -> {
                    recipe.setUid(updatedRecipe.getUid());
                    recipe.setName(updatedRecipe.getName());
                    recipe.setCategory(updatedRecipe.getCategory());
                    recipe.setCalories(updatedRecipe.getCalories());
                    recipe.setPortions(updatedRecipe.getPortions());
                    recipe.setCookingTime(updatedRecipe.getCookingTime());
                    recipe.setFavorite(updatedRecipe.isFavorite());
                    recipe.setImage(updatedRecipe.getImage());
                    recipe.setIngredientList(updatedRecipe.getIngredientList());
                    recipe.setStepList(updatedRecipe.getStepList());
                    return recipeRepository.save(recipe);
                }).orElseThrow(() -> new NotFoundException("No recipe with related ID:" + rid));
    }

    @PutMapping("/recipe/{rid}/{fav}")
    public Recipe updateFavourite(@PathVariable long rid, @PathVariable boolean fav) {
        return recipeRepository.findById(rid)
                .map(recipe -> {
                    recipe.setFavorite(fav);
                    return recipeRepository.save(recipe);
                }).orElseThrow(() -> new NotFoundException("No recipe with related ID:" + rid));
    }

    @PostMapping("/recipe")
    public Recipe addRecipe(@RequestBody Recipe recipeToSave) {
        return recipeRepository.save(recipeToSave);
    }

    @DeleteMapping("/recipe/{rid}")
    public Boolean deleteRecipe(@PathVariable long rid) {
        recipeRepository.deleteById(rid);
        return recipeRepository.existsById(rid);
    }

    //SHOPPING LIST CONTROLLER METHODS

    @PostMapping("/shoppingList")
    public ShoppingList addList(@RequestBody ShoppingList listToSave) {
        return shoppingListRepository.save(listToSave);
    }

    @GetMapping("/shoppingLists")
    public List<ShoppingList> getAllLists() {
        return (List<ShoppingList>) shoppingListRepository.findAll();
    }

    @GetMapping("/shoppingList/{uid}")
    public List<ShoppingList> getUsersShoppingLists(@PathVariable("uid") String uid) {
        return shoppingListRepository.findByUid(uid);
    }

    @GetMapping("/shoppingList/details/{lid}")
    public ShoppingList getShoppingListById(@PathVariable long lid) {
        return shoppingListRepository.findById(lid).orElseThrow(() -> new NotFoundException("No shopping list with related ID:" + lid));
    }

    @GetMapping("/shoppingList/{uid}/{name}")
    public Boolean findShoppingListByName(@PathVariable("uid") String uid, @PathVariable("name") String name) {
        return shoppingListRepository.existsByUidAndName(uid, name);
    }

    @DeleteMapping("/shoppingList/{lid}")
    public Boolean deleteShoppingList(@PathVariable long lid) {
        shoppingListRepository.deleteById(lid);
        return recipeRepository.existsById(lid);
    }

    @PutMapping("/shoppingList/items/{lid}")
    public ShoppingList updateShoppingList(@PathVariable long lid, @RequestBody List<Item> itemList) {
        return shoppingListRepository.findById(lid)
                .map(shoppingList -> {
                    shoppingList.setItemsList(itemList);
                    return shoppingListRepository.save(shoppingList);
                }).orElseThrow(() -> new NotFoundException("No shopping list with related ID:" + lid));
    }

    @PutMapping("/shoppingList/recipeItems/{name}")
    public Boolean updateShoppingList(@PathVariable String name, @RequestBody List<Item> itemList) {
        ShoppingList shoppingList = shoppingListRepository.findByName(name);
        shoppingList.setItemsList(itemList);
        shoppingListRepository.save(shoppingList);
        return shoppingListRepository.existsByName(name);
    }

}
