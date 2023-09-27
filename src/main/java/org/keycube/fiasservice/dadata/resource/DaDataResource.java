package org.keycube.fiasservice.dadata.resource;

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
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.keycube.fiasservice.dadata.client.DaDataClient;
import org.keycube.fiasservice.dadata.pojo.DaDataResponse;
import org.keycube.fiasservice.fias.pojo.FiasRequest;

@Path("/dadata")
@Tag(name = "3. External Resource (DaData)")
public class DaDataResource {

  @Inject @RestClient
  DaDataClient client;

  @POST
  @Path("/find-by-str")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(
      summary = "API подсказок по адресам",
      description = "https://dadata.ru/api/suggest/address/")
  @APIResponses(
      value = {
        @APIResponse(
            responseCode = "200",
            description = "OK",
            content =
                @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = DaDataResponse.class))),
        @APIResponse(
            responseCode = "500",
            description = "Internal Server Error",
            content = @Content(mediaType = MediaType.APPLICATION_JSON))
      })
  public Uni<DaDataResponse> findByStr(
      @Valid
          @RequestBody(
              description = "JSON с адресом строкой",
              required = true,
              content =
                  @Content(
                      mediaType = MediaType.APPLICATION_JSON,
                      schema = @Schema(implementation = FiasRequest.class)))
          FiasRequest request) {
    return client.suggestAddress(request).map(response -> DaDataResponse.from(response));
  }

  @POST
  @Path("/find-by-id")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(summary = "Адрес по коду", description = "https://dadata.ru/api/find-address/")
  @APIResponses(
      value = {
        @APIResponse(
            responseCode = "200",
            description = "OK",
            content =
                @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = DaDataResponse.class))),
        @APIResponse(
            responseCode = "500",
            description = "Internal Server Error",
            content = @Content(mediaType = MediaType.APPLICATION_JSON))
      })
  public Uni<DaDataResponse> findById(
      @Valid
          @RequestBody(
              description = "JSON с кодом ФИАС или КлАдр",
              required = true,
              content =
                  @Content(
                      mediaType = MediaType.APPLICATION_JSON,
                      schema = @Schema(implementation = FiasRequest.class)))
          FiasRequest request) {
    return client.findByIdAddress(request).map(response -> DaDataResponse.from(response));
  }

  @POST
  @Path("/find-by-id-dpct")
  @Deprecated
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(
      summary = "Адрес в ФИАС по идентификатору",
      description = "https://dadata.ru/api/find-fias/")
  @APIResponses(
      value = {
        @APIResponse(
            responseCode = "200",
            description = "OK",
            content =
                @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = DaDataResponse.class))),
        @APIResponse(
            responseCode = "500",
            description = "Internal Server Error",
            content = @Content(mediaType = MediaType.APPLICATION_JSON))
      })
  public Uni<DaDataResponse> findByIdHints(
      @Valid
          @RequestBody(
              description = "JSON с кодом ФИАС или КлАдр",
              required = true,
              content =
                  @Content(
                      mediaType = MediaType.APPLICATION_JSON,
                      schema = @Schema(implementation = FiasRequest.class)))
          FiasRequest request) {
    return client.findByIdFias(request).map(response -> DaDataResponse.from(response));
  }
}
