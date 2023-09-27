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
@Schema(name = "Data", description = "Данные по адресу")
public class InternalData {

  @Schema(description = "Индекс")
  @JsonProperty("postal_code")
  String postalCode;

  @Schema(description = "КЛАДР-код адреса")
  @JsonProperty("kladr_id")
  String kladrId;

  @Schema(description = "ФИАС-код адреса (идентификатор ФИАС)")
  @JsonProperty("fias_id")
  String fiasId;

  @Schema(description = "Страна")
  String country;

  @Schema(description = "ISO-код страны")
  @JsonProperty("country_iso_code")
  String countryIsoCode;

  @Schema(description = "КЛАДР-код региона")
  @JsonProperty("region_kladr_id")
  String regionKladrId;

  @Schema(description = "КЛАДР-код города")
  @JsonProperty("city_kladr_id")
  String cityKladrId;

  @Schema(description = "КЛАДР-код населенного пункта")
  @JsonProperty("settlement_kladr_id")
  String settlementKladrId;

  @Schema(description = "КЛАДР-код улицы")
  @JsonProperty("street_kladr_id")
  String streetKladrId;

  @Schema(description = "ФИАС-код улицы")
  @JsonProperty("street_fias_id")
  String streetFiasId;

  @Schema(description = "Улица")
  String street;

  @Schema(description = "Дом")
  String house;

  @Schema(description = "Корпус (аналог block c block_type 'к')")
  String build;

  @Schema(description = "Cтроение (аналог block c block_type 'стр')")
  @JsonProperty("struc")
  String struct;

  @Schema(description = "Квартира")
  String flat;

  @Schema(description = "Уровень детализации, до которого адрес найден в ФИАС")
  @JsonProperty("fias_level")
  String fiasLevel;
}
