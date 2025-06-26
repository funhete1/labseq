package dellent.errors; 

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class IllegalArgumentExceptionMapper implements ExceptionMapper<IllegalArgumentException> {

    @Override
    public Response toResponse(IllegalArgumentException exception) {
        System.err.println("Client provided invalid argument: " + exception.getMessage());

        ErrorResponse errorResponse = new ErrorResponse(
            Response.Status.BAD_REQUEST.getStatusCode(),
            exception.getMessage() 
        );

        return Response.status(Response.Status.BAD_REQUEST)
                       .entity(errorResponse)
                       .type(MediaType.APPLICATION_JSON)
                       .build();
    }
}