package com.websocket.rest;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@ApplicationScoped
@Path("/web")
public class FrontRest {

    private static final Logger log = Logger.getLogger(FrontRest.class);

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getPage() {
        try {
            String content = new String(Files.readAllBytes(Paths.get("/root/html/index.html")));
            return Response.ok(content, MediaType.TEXT_HTML).build();
        } catch (IOException e) {
            log.error("Erro ao recuperar index.html" + e.getMessage());
            return Response.serverError().build();
        }
    }

    @GET()
    @Path("a")
    public Response ok() {
        return Response.ok("oi").build();
    }
}
