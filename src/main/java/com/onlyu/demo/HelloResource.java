package com.onlyu.demo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
public class HelloResource {

    @GET
    @Path("/greet")
    public String greet() {
        return "Hello!";
    }

}
