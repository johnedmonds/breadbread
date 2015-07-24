package com.breadbreadbook.db.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.types.ObjectId;

/**
 * A single step in the recipe (e.g. chop carrots).
 */
public class Step {
  private final ObjectId id;
  private final String instruction;
  
  @JsonCreator
  public Step(
      @JsonProperty("_id") ObjectId id,
      @JsonProperty("instruction") String instruction) {
    this.id = id;
    this.instruction = instruction;
  }
  
  @JsonProperty("_id")
  public ObjectId getId() {
    return id;
  }
  
  public String getInstruction() {
    return instruction;
  }
}