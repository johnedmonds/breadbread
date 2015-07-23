package com.breadbreadbook.server;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

/**
 * Servlet context listener.
 */

public class BreadBreadBookServletContextListener extends GuiceServletContextListener {
  @Override
  protected Injector getInjector() {
    return Guice.createInjector(new BreadBreadBookModule());
  }
}