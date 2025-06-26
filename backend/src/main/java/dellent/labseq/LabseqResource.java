package dellent.labseq;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/labseq")
public class LabseqResource {
    //Endpoint for the labseq sequence
    @Inject
    LabseqService labseqService;

    @GET
    @Path("/{n}")
    @Produces({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON})
    @Operation(summary = "Retrieves the n-th value of the Labseq sequence",
               description = "Calculates and returns the value l(n) for a given non-negative integer n.")
    @APIResponses(value = {
        @APIResponse(
            responseCode = "200",
            description = "Successfully retrieved the Labseq value.",
            content = @Content(mediaType = MediaType.TEXT_PLAIN,
                               schema = @Schema(type = SchemaType.STRING, example = "1"))
        ),
        @APIResponse(ref = "BadRequestResponse"),
        @APIResponse(ref = "InternalServerErrorResponse")
    })
    public String getLabseq(@PathParam("n") int n) {
        return String.valueOf(labseqService.labseq(n));
    }

}
