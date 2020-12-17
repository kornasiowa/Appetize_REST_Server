package com.kornasiowa.appetize.repo;

import com.kornasiowa.appetize.model.ShoppingList;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ShoppingListRepository extends CrudRepository<ShoppingList, Long> {

    List<ShoppingList> findByUid(String uid);

    ShoppingList findByName(String name);

    Boolean existsByUidAndName(String uid, String name);

    Boolean existsByName(String name);
}
