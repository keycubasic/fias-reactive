package org.keycube.fiasservice.fias.resource;

import io.smallrye.mutiny.Uni;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.keycube.fiasservice.fias.pojo.FiasRequest;
import org.keycube.fiasservice.fias.service.FiasService;
import org.keycube.fiasservice.internal.pojo.InternalResponse;

@Path("/fias")
@Tag(name = "1. FIAS Resource (Main)")
// @SecurityRequirement(name = "jwt2")
public class FiasResource {
  @Inject
  FiasService service;

  @POST
  @Path("/find-by-str")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(
      summary = "Получить JSON по адресу строкой",
      description = "Получить информацию в формате JSON по адресу строкой")
  @APIResponses(
      value = {
        @APIResponse(
            responseCode = "200",
            description = "OK",
            content =
                @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = InternalResponse.class))),
        @APIResponse(
            responseCode = "500",
            description = "Internal Server Error",
            content = @Content(mediaType = MediaType.APPLICATION_JSON))
      })
  public Uni<InternalResponse> findByStr(
      @Valid
          @RequestBody(
              description = "JSON с адресом строкой",
              required = true,
              content =
                  @Content(
                      mediaType = MediaType.APPLICATION_JSON,
                      schema = @Schema(implementation = FiasRequest.class)))
          FiasRequest request) {
    return service.getByStr(request);
  }

  @POST
  @Path("/find-by-id")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(
      summary = "Получить JSON по коду ФИАС",
      description = "Получить информацию в формате JSON по коду ФИАС")
  @APIResponses(
      value = {
        @APIResponse(
            responseCode = "200",
            description = "OK",
            content =
                @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = InternalResponse.class))),
        @APIResponse(
            responseCode = "500",
            description = "Internal Server Error",
            content = @Content(mediaType = MediaType.APPLICATION_JSON))
      })
  public Uni<InternalResponse> findById(
      @Valid
          @RequestBody(
              description = "JSON с кодом ФИАС",
              required = true,
              content =
                  @Content(
                      mediaType = MediaType.APPLICATION_JSON,
                      schema = @Schema(implementation = FiasRequest.class)))
          FiasRequest request) {
    return service.getById(request);
  }

  @POST
  @Path("/find-by-kladr")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(
      summary = "Получить JSON по коду КлАдр",
      description = "Получить информацию в формате JSON по коду КлАдр")
  @APIResponses(
      value = {
        @APIResponse(
            responseCode = "200",
            description = "OK",
            content =
                @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = InternalResponse.class))),
        @APIResponse(
            responseCode = "500",
            description = "Internal Server Error",
            content = @Content(mediaType = MediaType.APPLICATION_JSON))
      })
  public Uni<InternalResponse> findByKladrId(
      @Valid
          @RequestBody(
              description = "JSON с кодом КлАдр",
              required = true,
              content =
                  @Content(
                      mediaType = MediaType.APPLICATION_JSON,
                      schema = @Schema(implementation = FiasRequest.class)))
          FiasRequest request) {
    return service.getByKladrId(request);
  }
}
