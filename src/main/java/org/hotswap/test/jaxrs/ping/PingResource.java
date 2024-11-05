package org.hotswap.test.jaxrs.ping;

import java.text.SimpleDateFormat;
import java.util.Date;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

import io.smallrye.common.annotation.NonBlocking;

@Path("ping")
public class PingResource {
  private static final String template = "Hello, %s!";
  
  @Inject
  private Statistics statistics;
  
  @GET
  @Produces({"text/plain"})
  @Path("simple")
  @NonBlocking
  public Response getSimple() {
    return Response.ok().build();
  }
  
  @GET
  @Produces({"text/plain"})
  @Path("hello")
  @NonBlocking
  public String hello() {
    return "helloJ";
  }
  
  @GET
  @Path("greeting")
  @Produces({"text/plain"})
  @NonBlocking
  public String greeting(@QueryParam("name") String name) {
    //System.out.println((new SimpleDateFormat("HH:mm:ss.SSS")).format(new Date(System.currentTimeMillis())));
    String suffix = (name != null) ? name : "World";
    return String.format("Hello, %s!", new Object[] { suffix });
  }
}
