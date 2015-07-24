package com.breadbreadbook.server                     ;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.mongodb.MongoClient;
import com.google.inject.servlet.ServletModule;
import com.breadbreadbook.server.rest.RecipeServlet;

public class BreadBreadBookModule extends ServletModule {
  @Override
  public void configureServlets() {
    serve("/api/recipes/*").with(RecipeServlet.class);
  }
  
  @Provides
  MongoClient provideMongoClient() {
    // Default mongodb port on localhost.
    return new MongoClient("localhost", 27017);
  }
}