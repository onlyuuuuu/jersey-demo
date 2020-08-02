package com.onlyu.demo;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.LinkedHashMap;
import java.util.Map;

@Provider
public class RunTimeExceptionMapper implements ExceptionMapper<RuntimeException> {

    @Override
    public Response toResponse(RuntimeException exception) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("general", exception.getMessage());
        map.put("details", exception.getLocalizedMessage());
        return Response.status(500).entity(map).build();
    }

}
