package com.breadbreadbook;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;
import com.google.inject.servlet.GuiceFilter;
import javax.servlet.DispatcherType;
import java.util.EnumSet;
import com.breadbreadbook.server.BreadBreadBookServletContextListener;
import com.breadbreadbook.server.BreadBreadBookModule;

public class Main {
  public static void main(String[] args) throws Exception {
    Server server = new Server();
    ServerConnector connector = new ServerConnector(server);
    connector.setPort(8080);
    server.setConnectors(new Connector[] { connector });
    ServletContextHandler context = new ServletContextHandler();
    context.setContextPath("/");
    context.addFilter(GuiceFilter.class, "/*", EnumSet.allOf(DispatcherType.class));
    context.addEventListener(new BreadBreadBookServletContextListener());
    HandlerCollection handlers = new HandlerCollection();
    handlers.setHandlers(new Handler[] { context, new DefaultHandler() });
    server.setHandler(handlers);
    server.start();
    server.join();

  }
}