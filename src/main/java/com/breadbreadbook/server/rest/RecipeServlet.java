package com.breadbreadbook.server.rest;

import javax.servlet.http.HttpServlet;
import com.google.inject.Singleton;
import com.google.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.breadbreadbook.db.model.Recipe;
import com.breadbreadbook.db.model.Step;
import com.google.common.collect.ImmutableList;
import java.io.IOException;

/**
 * Servlet for recipes.
 */
@Singleton
public class RecipeServlet extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    response.getWriter().println(
          new ObjectMapper().writeValueAsString(
              new Recipe(
                  null,
                  "Test",
                  ImmutableList.of(
                      new Step(null, "Step 1"),
                      new Step(null, "Step 2")))));
  }
}