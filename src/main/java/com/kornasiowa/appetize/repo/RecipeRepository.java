package com.kornasiowa.appetize.repo;

import com.kornasiowa.appetize.model.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    List<Recipe> findByUidAndCategory(String uid, String category);

    List<Recipe> findByUidAndFavorite(String uid, boolean fav);
}
