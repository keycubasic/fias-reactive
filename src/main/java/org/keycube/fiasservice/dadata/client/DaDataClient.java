package org.keycube.fiasservice.dadata.client;

import io.quarkus.oidc.client.filter.OidcClientFilter;
import io.smallrye.mutiny.Uni;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.keycube.fiasservice.fias.pojo.FiasRequest;

@Path("/suggestions/api/4_1/rs")
@RegisterRestClient(configKey = "dadata")
@OidcClientFilter
public interface DaDataClient {

  // Подсказки по адресу
  @POST
  @Path("suggest/address")
  Uni<String> suggestAddress(@RequestBody FiasRequest request);

  // Поиск по коду ФИАС или КЛАДР
  @POST
  @Path("findById/address")
  Uni<String> findByIdAddress(@RequestBody FiasRequest request);

  // Поиск по идентификатору ФИАС или КЛАДР
  @POST
  @Path("findById/fias")
  Uni<String> findByIdFias(@RequestBody FiasRequest request);
}
