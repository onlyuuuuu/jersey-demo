package com.onlyu.demo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloResource {

    @GET
    @Path("/greet")
    @Produces(MediaType.TEXT_PLAIN)
    public String greet() {
        return "Hello!";
    }

    @GET
    @Path("/greet/xml")
    @Produces(MediaType.APPLICATION_XML)
    public Response greetAsXml() {
        Greet greet = new Greet();
        greet.setTo("John");
        greet.setMessage("Thank you John!");
        return Response.ok(greet).build();
    }

    @GET
    @Path("/greet/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response greetAsJson() {
        Greet greet = new Greet();
        greet.setTo("Smith");
        greet.setMessage("Hello Smith!");
        return Response.ok(greet).build();
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response greetAsJson(@PathParam("name") String name) {
        Greet greet = new Greet();
        greet.setTo(name);
        greet.setMessage("Hello " + name + "!");
        return Response.ok(greet).build();
    }

}
