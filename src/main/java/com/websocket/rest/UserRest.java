package com.websocket.rest;

import com.websocket.services.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

import java.net.URI;

@Path("/user")
public class UserRest {

    @Inject
    UserService userService;

    @POST
    @Path("{nickname}")
    public Response createUser(@PathParam("nickname") String nickname) {
        try {
            return Response.created(URI.create("/user/" + userService.createUser(nickname))).build();
        } catch (Exception e) {
            //TODO Log
            return Response.serverError().build();
        }
    }

    @GET
    @Path("{id}")
    public Response getUser(@PathParam("id") Long id) {
        return Response.ok().build();
    }
}
