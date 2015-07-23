package com.breadbreadbook.dao;

import com.google.inject.Inject;
import com.mongodb.MongoClient;
import org.mongojack.JacksonDBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.mongojack.JacksonDBCollection;
import com.breadbreadbook.data.Recipe;
import com.mongodb.client.model.Filters;
import org.bson.types.ObjectId;

/**
 * Data access object for recipes.
 */
public class RecipeDao {
  
  private static final String RECIPES_COLLECTION_NAME = "recipes";
  
  private final MongoClient client;
  
  @Inject
  RecipeDao(MongoClient client) {
    this.client = client;
  }
  
  private JacksonDBCollection<Recipe, ObjectId> getCollection() {
    return JacksonDBCollection.wrap(
      client
          .getDB(DatabaseConstants.DATABASE_NAME)
          .getCollection(RECIPES_COLLECTION_NAME),
      Recipe.class,
      ObjectId.class);
  }
  
  public Recipe getRecipeById(ObjectId id) {
    return getCollection().findOneById(id);
  }
  
  public Recipe createRecipe(Recipe recipe) {
    return getCollection().insert(recipe).getSavedObject();
  }
  
  public void updateRecipe(Recipe recipe) {
    getCollection().updateById(recipe.getId(), recipe);
  }
}