package org.keycube.fiasservice.internal.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Data
@Builder
@Jacksonized
@AllArgsConstructor
@Schema(name = "Suggestion", description = "Предложение результатов поиска")
public class InternalSuggestion {

  @Schema(description = "Адрес строкой")
  String value;

  @Schema(description = "Адрес строкой расширенный")
  @JsonProperty("unrestricted_value")
  String unrestrictedValue;

  @Schema(description = "Данные по адресу")
  InternalData data;
}
