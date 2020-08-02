package com.onlyu.demo.v1;


import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class CORSFilter implements ContainerResponseFilter {

//    @Override
//    public ContainerResponse filter(ContainerRequest request, ContainerResponse response) {
//        MultivaluedMap<String, Object> headers = response.getHttpHeaders();
//        headers.add("Access-Control-Allow-Origin", "*");
//        headers.add("Access-Control-Allow-Headers", "*");
//        headers.add("Access-Control-Allow-Methods", "*");
//        return response;
//    }

    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
        MultivaluedMap<String, Object> headers = containerResponseContext.getHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Headers", "*");
        headers.add("Access-Control-Allow-Methods", "*");
    }

}
