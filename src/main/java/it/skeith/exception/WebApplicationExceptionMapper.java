package it.skeith.exception;


import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class WebApplicationExceptionMapper implements ExceptionMapper<WebApplicationException> {

    @Override
    public Response toResponse(WebApplicationException exception) {

       return Response.status(Response.Status.BAD_REQUEST)
               .entity(exception.getMessage())
               .type(MediaType.TEXT_PLAIN_TYPE)
               .build();
    }
}