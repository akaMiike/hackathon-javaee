package com.stefanini.exceptions.user;

import com.stefanini.exceptions.ErrorResponse;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class InvalidPasswordException extends WebApplicationException {

    public InvalidPasswordException(){
        super(Response.status(400)
                .entity(
                        new ErrorResponse(
                        "Password must have at least: " +
                                " 1 special character, 1 upper character, 1 lower character and 1 number",
                        Response.Status.BAD_REQUEST.getStatusCode())
                )
                .build());
    }
}
