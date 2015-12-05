package com.kms.mono.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1")
public class Basic {
    
    //GET method without child path example, type /v1 in the URI
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String returnTitle() {
        return "<p>Java Web Service</p>";
    }
    
}
