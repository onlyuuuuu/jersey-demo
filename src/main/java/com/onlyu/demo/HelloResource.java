package com.onlyu.demo;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

@Path("/hello")
public class HelloResource {

    /*
     * The following types are supported:
     * Primitive Types
     * Types that have a constructor that accepts a single String argument.
     * Types that have a static method named valueOf with a single String argument.
     * List<T>, Set<T>, or SortedSet<T> where T satisfies 2 or 3 above.
     */

    /***
     * problem with string list still persist (response for both json & xml not as expected) - THE PROBLEM WAS @XmlRootElement !!!
     * https://stackoverflow.com/questions/5392413/jersey-return-a-list-of-strings
     *
     * null values not appearing or only for string list ?
     *
     *
     * THE PROBLEM WAS @XmlRootElement !!!
     * THE PROBLEM WAS @XmlRootElement !!!
     * THE PROBLEM WAS @XmlRootElement !!!
     *
     *
     */

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

    @GET
    @Path("/query/simple")
    @Produces(MediaType.APPLICATION_JSON)
    public Response greetAsQuerySimple(@QueryParam("par1") String param1,
                                       @QueryParam("par2") String param2) {
        Greet greet = new Greet();
        greet.setTo(param1);
        greet.setMessage(param2);
        return Response.ok(greet).build();
    }

    @GET
    @Path("/query/simple2")
    @Produces(MediaType.APPLICATION_JSON)
    public Response greetAsQuerySimple2(@QueryParam("par1") String param1,
                                        @QueryParam("par2") String param2,
                                        @QueryParam("par3") List<String> param3) {
        GreetJson greet = new GreetJson();
        greet.setTo(param1);
        greet.setMessage(param2);
        greet.setDetails(Arrays.asList("aaa"));
        //greet.setDetails(Arrays.asList("aaa", "bbb", "ccc")); // only works for multiple values
        //greet.setDetails(param3);
        return Response.ok(greet).build();
    }

    @GET
    @Path("/query/simple2.5")
    @Produces(MediaType.APPLICATION_XML)
    public Response greetAsQuerySimple2dot5(@QueryParam("par1") String param1,
                                            @QueryParam("par2") String param2,
                                            @QueryParam("par3") List<String> param3) {
        Greet greet = new Greet();
        greet.setTo(param1);
        greet.setMessage(param2);
        greet.setDetails(Arrays.asList("aaa"));
        GreetDetails greetDetails = new GreetDetails();
        greetDetails.setDetails(Arrays.asList("aaa"));
        greet.setGreetDetails(greetDetails);
        //greet.setDetails(Arrays.asList("aaa", "bbb", "ccc")); // only works for multiple values
        //greet.setDetails(param3);
        return Response.ok(greet).build();
    }

    @GET
    @Path("/query/simple3")
    @Produces(MediaType.APPLICATION_XML)
    public Response greetAsQuerySimple3(@QueryParam("par1") String param1,
                                        @QueryParam("par2") String param2,
                                        @QueryParam("par3") List<String> param3) {
        Greet greet = new Greet();
        greet.setTo(param1);
        greet.setMessage(param2);
        //greet.setDetails(Arrays.asList("aaa")); // same with json
        greet.setDetails(Arrays.asList("aaa", "bbb", "ccc")); // only works for multiple values
        //greet.setDetails(param3);
        return Response.ok(greet).build();
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response simpleList() {
        List<String> list = Arrays.asList("abc");
        //GenericEntity<List<String>> entity = new GenericEntity<List<String>>(list) {};
        return Response.ok(list).build();
    }

    @GET
    @Path("/list2")
    @Produces(MediaType.APPLICATION_JSON)
    public Response simpleList2() {
        List<String> list = Arrays.asList("abc");
        GenericEntity<List<String>> entity = new GenericEntity<List<String>>(list) {};
        return Response.ok(entity).build();
    }

    @GET
    @Path("/query/cookie")
    @Produces(MediaType.APPLICATION_JSON)
    public Response greetAsQueryCookie(@CookieParam("par1") String param1,
                                       @CookieParam("par2") String param2) {
        Greet greet = new Greet();
        greet.setTo(param1);
        greet.setMessage(param2);
        return Response.ok(greet).build();
    }

    @GET
    @Path("/query/header")
    @Produces(MediaType.APPLICATION_JSON)
    public Response greetAsQueryHeader(@HeaderParam("par1") String param1,
                                       @HeaderParam("par2") String param2) {
        Greet greet = new Greet();
        greet.setTo(param1);
        greet.setMessage(param2);
        return Response.ok(greet).build();
    }

    @POST
    @Path("/query/form")
    @Produces(MediaType.APPLICATION_JSON)
    public Response greetAsQueryForm(@FormParam("par1") String param1,
                                     @FormParam("par2") String param2) {
        Greet greet = new Greet();
        greet.setTo(param1);
        greet.setMessage(param2);
        return Response.ok(greet).build();
    }

//    @GET
//    @Path("/query/object")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response greetAsQueryObject(@QueryParam("random") RandomParam randomParam) {
//        Greet greet = new Greet();
//        greet.setTo(randomParam.getPar1());
//        greet.setMessage(randomParam.getPar2());
//        return Response.ok(greet).build();
//    }

}
