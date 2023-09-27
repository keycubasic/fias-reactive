package org.keycube.fiasservice.fias.service;

import io.smallrye.mutiny.Uni;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.keycube.fiasservice.fias.pojo.FiasRequest;
import org.keycube.fiasservice.dadata.client.DaDataClient;
import org.keycube.fiasservice.dadata.pojo.DaDataResponse;
import org.keycube.fiasservice.internal.pojo.InternalResponse;
import org.keycube.fiasservice.internal.service.InternalService;
import org.keycube.fiasservice.mapper.FiasMapper;

@RequestScoped
public class FiasService {

  @Inject @RestClient DaDataClient daDataClient;

  @Inject InternalService internalService;

  @Inject FiasMapper mapper;

  public Uni<InternalResponse> getByStr(FiasRequest request) {
    return internalService
        .get(request, 0)
        .flatMap(response -> checkSuggestionsAndRecoverWithDaDataSuggestAddress(request, response))
        .onFailure()
        .recoverWithUni(daDataSuggestAddressInternal(request));
  }

  public Uni<InternalResponse> getById(FiasRequest request) {
    return internalService
        .get(request, 1)
        .flatMap(response -> checkSuggestionsAndRecoverWithDaDataFindByIdAddress(request, response))
        .onFailure()
        .recoverWithUni(daDataFindByIdAddressInternal(request));
  }

  public Uni<InternalResponse> getByKladrId(FiasRequest request) {
    return internalService
        .get(request, 2)
        .flatMap(response -> checkSuggestionsAndRecoverWithDaDataFindByIdAddress(request, response))
        .onFailure()
        .recoverWithUni(daDataFindByIdAddressInternal(request));
  }

  private Uni<InternalResponse> daDataSuggestAddressInternal(FiasRequest request) {
    return daDataClient
        .suggestAddress(request)
        .map(response -> mapper.daDataResponseToInternalResponse(DaDataResponse.from(response)))
        .flatMap(
            item -> {
              item.setResultSource("DaData");
              return Uni.createFrom().item(item);
            });
  }

  private Uni<InternalResponse> daDataFindByIdAddressInternal(FiasRequest request) {
    return daDataClient
        .findByIdAddress(request)
        .map(response -> mapper.daDataResponseToInternalResponse(DaDataResponse.from(response)))
        .flatMap(
            item -> {
              item.setResultSource("DaData");
              return Uni.createFrom().item(item);
            });
  }

  private Uni<InternalResponse> checkSuggestionsAndRecoverWithDaDataSuggestAddress(
      FiasRequest request, InternalResponse response) {
    if (response.getSuggestions().size() == 0) {
      return daDataSuggestAddressInternal(request);
    } else {
      response.setResultSource("Oracle");
      return Uni.createFrom().item(response);
    }
  }

  private Uni<InternalResponse> checkSuggestionsAndRecoverWithDaDataFindByIdAddress(
      FiasRequest request, InternalResponse response) {
    if (response.getSuggestions().size() == 0) {
      return daDataFindByIdAddressInternal(request);
    } else {
      response.setResultSource("Oracle");
      return Uni.createFrom().item(response);
    }
  }
}
