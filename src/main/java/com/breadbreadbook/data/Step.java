package com.breadbreadbook.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.mongojack.ObjectId;

/**
 * A single step in the recipe (e.g. chop carrots).
 */
public class Step {
    private final long id;
    private final String instruction;
    
    @JsonCreator
    public Step(
        @JsonProperty("_id") long id,
        @JsonProperty("instruction") String instruction) {
        this.id = id;
        this.instruction = instruction;
    }
    
    @ObjectId
    @JsonProperty("_id")
    public long getId() {
        return id;
    }
    
    public String getInstruction() {
        return instruction;
    }
}