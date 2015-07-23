package com.breadbreadbook.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.mongodb.MongoClient;

public class BreadBreadBookModule extends AbstractModule {
  @Override
  public void configure() {
  }
  
  @Provides
  MongoClient provideMongoClient() {
    // Default mongodb port on localhost.
    return new MongoClient("localhost", 27017);
  }
}