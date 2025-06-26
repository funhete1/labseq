@OpenAPIDefinition(
    info = @Info(
        title = "Labseq Service API",
        version = "1.0.0",
        description = "API for the Labseq sequence calculation"
    ),
    components = @Components(
        responses = {
            @APIResponse(
                name = "BadRequestResponse", 
                responseCode = "400",
                description = "Invalid input or bad request data.",
                content = @Content(mediaType = MediaType.APPLICATION_JSON,
                                   schema = @Schema(implementation = ErrorResponse.class))
            ),
            @APIResponse(
                name = "InternalServerErrorResponse", 
                responseCode = "500",
                description = "An unexpected internal server error occurred.",
                content = @Content(mediaType = MediaType.APPLICATION_JSON,
                                   schema = @Schema(implementation = ErrorResponse.class))
            )
        }
    )
)
package dellent;

import org.eclipse.microprofile.openapi.annotations.Components;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import dellent.errors.ErrorResponse;
import jakarta.ws.rs.core.MediaType;