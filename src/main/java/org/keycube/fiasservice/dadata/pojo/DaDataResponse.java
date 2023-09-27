package org.keycube.fiasservice.dadata.pojo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import lombok.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.keycube.fiasservice.exception.FiasApplicationException;

@Getter
@Setter
@Schema(name = "Response (DaData)", description = "Тело ответа от сервиса DaData")
public class DaDataResponse {

  @Schema(description = "Предложения результатов поиска")
  List<DaDataSuggestion> suggestions;

  public static DaDataResponse from(String suggestions) {
    try {
      ObjectMapper objectMapper = new ObjectMapper();
      return objectMapper.readValue(suggestions, DaDataResponse.class);
    } catch (JsonProcessingException | IllegalArgumentException e) {
      throw new FiasApplicationException(
          "Ошибка десериализации ответа от сервиса DaData: " + e.getMessage());
    }
  }
}
