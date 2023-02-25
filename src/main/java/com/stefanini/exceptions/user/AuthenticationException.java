package com.stefanini.exceptions.user;

import com.stefanini.exceptions.ErrorResponse;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class AuthenticationException extends WebApplicationException {
    public AuthenticationException() {
        super(Response.status(Response.Status.UNAUTHORIZED)
                .entity(
                        new ErrorResponse(
                                "Incorrect Password",
                                Response.Status.UNAUTHORIZED.getStatusCode()
                        )
                )
                .build()
        );
    }
}
