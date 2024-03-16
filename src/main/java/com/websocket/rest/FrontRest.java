package com.websocket.rest;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;

@ApplicationScoped
@Path("/web")
public class FrontRest {

    private static final Logger log = Logger.getLogger(FrontRest.class);

    @GET()
    @Path("a")
    public Response ok() {
        return Response.ok("oi").build();
    }
}
