package org.keycube.fiasservice.internal.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.vertx.mutiny.sqlclient.Row;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.keycube.fiasservice.exception.FiasApplicationException;

@Data
@Builder
@Jacksonized
@AllArgsConstructor
@Schema(name = "Response", description = "Тело ответа от сервиса")
public class InternalResponse {

  @Schema(description = "Предложения результатов поиска")
  List<InternalSuggestion> suggestions;

  @Schema(description = "Источник результата")
  @JsonProperty("result_source")
  String resultSource;

  public static InternalResponse from(Row row) {
    String suggestions = row.getString("suggestions");
    try {
      ObjectMapper objectMapper = new ObjectMapper();
      return objectMapper.readValue(suggestions, InternalResponse.class);
    } catch (JsonProcessingException | IllegalArgumentException e) {
      throw new FiasApplicationException(
          "Ошибка десериализации результата от функции fias_utils.GetFIASFullJSON. Получено: "
              + suggestions);
    }
  }
}
