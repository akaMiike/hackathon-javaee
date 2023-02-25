package com.stefanini.exceptions.user;

import com.stefanini.exceptions.ErrorResponse;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class UserLoginAlreadyExistsException extends WebApplicationException {

    public UserLoginAlreadyExistsException(){
        super(Response.status(400)
                .entity(
                        new ErrorResponse(
                        "Login is already in use by another user.",
                        Response.Status.BAD_REQUEST.getStatusCode())
                )
                .build());
    }
}
