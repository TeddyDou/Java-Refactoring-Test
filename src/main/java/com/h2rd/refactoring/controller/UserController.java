package com.h2rd.refactoring.controller;

import com.h2rd.refactoring.domain.User;
import com.h2rd.refactoring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.util.List;

@Controller
@Path("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @POST
    @Path("add/")
    public Response addUser(@QueryParam("name") String name,
                            @QueryParam("email") String email,
                            @QueryParam("role") List<String> roles) {

        User user = new User(name, email, roles);
        userService.addUser(user);
        return Response.ok().entity(user).build();
    }

    @PUT
    @Path("update/")
    public Response updateUser(@QueryParam("name") String name,
                               @QueryParam("email") String email,
                               @QueryParam("role") List<String> roles) {

        User user = new User(name, email, roles);
        userService.updateUser(user);
        return Response.ok().entity(user).build();
    }

    @DELETE
    @Path("delete/")
    public Response deleteUser(@QueryParam("name") String name,
                               @QueryParam("email") String email,
                               @QueryParam("role") List<String> roles) {
        User user = new User(name, email, roles);

        userService.deleteUser(user);
        return Response.ok().entity(user).build();
    }

    @GET
    @Path("find/")
    public Response getUsers() {

        List<User> users = userService.getUsers();

        GenericEntity<List<User>> usersEntity = new GenericEntity<List<User>>(users) {};
        return Response.ok().entity(usersEntity).build();
    }

    @GET
    @Path("search/")
    public Response findUser(@QueryParam("name") String name) {

        User user = userService.findUser(name);
        return Response.ok().entity(user).build();
    }
}
