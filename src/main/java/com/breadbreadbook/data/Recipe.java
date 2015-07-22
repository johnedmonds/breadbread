package com.breadbreadbook.data;

import org.mongojack.ObjectId;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.google.common.collect.ImmutableList;

/**
 * A single recipe.
 */
public class Recipe {
    private final long id;
    private final String name;
    private final ImmutableList<Step> steps;
    
    /**
     * A list of every step in the recipe. Steps may also reference each other.
     */
    @JsonCreator
    public Recipe(
        @JsonProperty("_id") long id,
        @JsonProperty("name") String name,
        @JsonProperty("steps") ImmutableList<Step> steps) {
        this.id = id;
        this.name = name;
        this.steps = steps;
    }
    
    @ObjectId
    @JsonProperty("_id")
    public long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public ImmutableList<Step> getSteps() {
        return steps;
    }
}