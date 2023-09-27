package org.keycube.fiasservice.dadata.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Setter
@Schema(name = "Suggestion (DaData)", description = "Предложение результатов поиска")
public class DaDataSuggestion {
  @Schema(description = "Адрес строкой")
  String value;

  @Schema(description = "Адрес строкой расширенный")
  @JsonProperty("unrestricted_value")
  String unrestrictedValue;

  @Schema(description = "Данные по адресу")
  DaDataData data;
}
