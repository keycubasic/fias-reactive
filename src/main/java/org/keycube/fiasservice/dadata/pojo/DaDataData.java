package org.keycube.fiasservice.dadata.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Setter
@Schema(name = "Data (DaData)", description = "Данные по адресу")
public class DaDataData {

  @Schema(description = "Индекс")
  @JsonProperty("postal_code")
  String postalCode;

  @Schema(description = "Страна")
  String country;

  @Schema(description = "ISO-код страны")
  @JsonProperty("country_iso_code")
  String countryIsoCode;

  @Schema(description = "Федеральный округ")
  @JsonProperty("federal_district")
  String federalDistrict;

  @Schema(description = "ФИАС-код региона")
  @JsonProperty("region_fias_id")
  String regionFiasId;

  @Schema(description = "КЛАДР-код региона")
  @JsonProperty("region_kladr_id")
  String regionKladrId;

  @Schema(description = "ISO-код региона")
  @JsonProperty("region_iso_code")
  String regionIsoCode;

  @Schema(description = "Регион с типом")
  @JsonProperty("region_with_type")
  String regionWithType;

  @Schema(description = "Тип региона (сокращенный)")
  @JsonProperty("region_type")
  String regionType;

  @Schema(description = "Тип региона")
  @JsonProperty("region_type_full")
  String regionTypeFull;

  @Schema(description = "Регион")
  String region;

  @Schema(description = "ФИАС-код района")
  @JsonProperty("area_fias_id")
  String areaFiasId;

  @Schema(description = "КЛАДР-код района")
  @JsonProperty("area_kladr_id")
  String areaKladrId;

  @Schema(description = "Район в регионе с типом")
  @JsonProperty("area_with_type")
  String areaWithType;

  @Schema(description = "Тип района в регионе (сокращенный)")
  @JsonProperty("area_type")
  String areaType;

  @Schema(description = "Тип района в регионе")
  @JsonProperty("area_type_full")
  String areaTypeFull;

  @Schema(description = "Район в регион")
  String area;

  @Schema(description = "ФИАС-код города")
  @JsonProperty("city_fias_id")
  String cityFiasId;

  @Schema(description = "КЛАДР-код города")
  @JsonProperty("city_kladr_id")
  String cityKladrId;

  @Schema(description = "Город с типом")
  @JsonProperty("city_with_type")
  String cityWithType;

  @Schema(description = "Тип города (сокращенный)")
  @JsonProperty("city_type")
  String cityType;

  @Schema(description = "Тип города")
  @JsonProperty("city_type_full")
  String cityTypeFull;

  @Schema(description = "Город")
  String city;

  @Schema(description = "Административный округ (только для Москвы)")
  @JsonProperty("city_area")
  String cityArea;

  @Schema(description = "ФИАС-код района города (заполняется, только если район есть в ФИАС")
  @JsonProperty("city_district_fias_id")
  String cityDistrictFiasId;

  @Schema(description = "КЛАДР-код района города (не заполняется)")
  @JsonProperty("city_district_kladr_id")
  String cityDistrictKladrId;

  @Schema(description = "Район города с типом")
  @JsonProperty("city_district_with_type")
  String cityDistrictWithType;

  @Schema(description = "Тип района города (сокращенный)")
  @JsonProperty("city_district_type")
  String cityDistrictType;

  @Schema(description = "Тип района города")
  @JsonProperty("city_district_type_full")
  String cityDistrictTypeFull;

  @Schema(description = "Район города")
  @JsonProperty("city_district")
  String cityDistrict;

  @Schema(description = "ФИАС-код населенного пункта")
  @JsonProperty("settlement_fias_id")
  String settlementFiasId;

  @Schema(description = "КЛАДР-код населенного пункта")
  @JsonProperty("settlement_kladr_id")
  String settlementKladrId;

  @Schema(description = "Населенный пункт с типом")
  @JsonProperty("settlement_with_type")
  String settlementWithType;

  @Schema(description = "Тип населенного пункта (сокращенный)")
  @JsonProperty("settlement_type")
  String settlementType;

  @Schema(description = "Тип населенного пункта")
  @JsonProperty("settlement_type_full")
  String settlementTypeFull;

  @Schema(description = "Населенный пункт")
  String settlement;

  @Schema(description = "Код ФИАС план. структуры")
  @JsonProperty("planning_structure_fias_id")
  String planningStructureFiasId;

  @Schema(description = "Код КЛАДР план. структуры")
  @JsonProperty("planning_structure_kladr_id")
  String planningStructureKladrId;

  @Schema(description = "Планировочная структура с типом")
  @JsonProperty("planning_structure_with_type")
  String planningStructureWithType;

  @Schema(description = "Тип планировочной структуры (сокращенный)")
  @JsonProperty("planning_structure_type")
  String planningStructureType;

  @Schema(description = "Тип планировочной структуры")
  @JsonProperty("planning_structure_type_full")
  String planningStructureTypeFull;

  @Schema(description = "Планировочная структура")
  @JsonProperty("planning_structure")
  String planningStructure;

  @Schema(description = "ФИАС-код улицы")
  @JsonProperty("street_fias_id")
  String streetFiasId;

  @Schema(description = "КЛАДР-код улицы")
  @JsonProperty("street_kladr_id")
  String streetKladrId;

  @Schema(description = "Улица с типом")
  @JsonProperty("street_with_type")
  String streetWithType;

  @Schema(description = "Тип улицы (сокращенный)")
  @JsonProperty("street_type")
  String streetType;

  @Schema(description = "Тип улицы")
  @JsonProperty("street_type_full")
  String streetTypeFull;

  @Schema(description = "Улица")
  String street;

  @Schema(description = "ФИАС-код земельного участка")
  @JsonProperty("stead_fias_id")
  String steadFiasId;

  @Schema(description = "КЛАДР-код земельного участка")
  @JsonProperty("stead_kladr_id")
  String steadKladrId;

  @Schema(description = "Кадастровый номер земельного участка")
  @JsonProperty("stead_cadnum")
  String steadCadnum;

  @Schema(description = "= «уч»")
  @JsonProperty("stead_type")
  String steadType;

  @Schema(description = "= «участок»")
  @JsonProperty("stead_type_full")
  String steadTypeFull;

  @Schema(description = "Номер земельного участка")
  String stead;

  @Schema(description = "ФИАС-код дома")
  @JsonProperty("house_fias_id")
  String houseFiasId;

  @Schema(description = "КЛАДР-код дома")
  @JsonProperty("house_kladr_id")
  String houseKladrId;

  @Schema(description = "Кадастровый номер дома")
  @JsonProperty("house_cadnum")
  String houseCadnum;

  @Schema(description = "Тип дома (сокращенный)")
  @JsonProperty("house_type")
  String houseType;

  @Schema(description = "Тип дома")
  @JsonProperty("house_type_full")
  String houseTypeFull;

  @Schema(description = "Дом")
  String house;

  @Schema(description = "Тип корпуса/строения (сокращенный)")
  @JsonProperty("block_type")
  String blockType;

  @Schema(description = "Тип корпуса/строения")
  @JsonProperty("block_type_full")
  String blockTypeFull;

  @Schema(description = "Корпус/строение")
  String block;

  @Schema(description = "Тип строения")
  @JsonProperty("building_type")
  String buildingType;

  @Schema(description = "Строение")
  String building;

  @Schema(description = "Кадастровый номер")
  @JsonProperty("cadastral_number")
  String cadastralNumber;

  @Schema(description = "Подъезд")
  String entrance;

  @Schema(description = "Этаж")
  String floor;

  @Schema(description = "ФИАС-код квартиры")
  @JsonProperty("flat_fias_id")
  String flatFiasId;

  @Schema(description = "Кадастровый номер квартиры")
  @JsonProperty("flat_cadnum")
  String flatCadnum;

  @Schema(description = "Тип квартиры (сокращенный)")
  @JsonProperty("flat_type")
  String flatType;

  @Schema(description = "Тип квартиры")
  @JsonProperty("flat_type_full")
  String flatTypeFull;

  @Schema(description = "Квартира")
  String flat;

  @Schema(description = "Площадь квартиры")
  @JsonProperty("flat_area")
  String flatArea;

  @Schema(description = "Рыночная стоимость м²")
  @JsonProperty("square_meter_price")
  String squareMeterPrice;

  @Schema(description = "Рыночная стоимость квартиры")
  @JsonProperty("flat_price")
  String flatPrice;

  @Schema(description = "ФИАС-код комнаты")
  @JsonProperty("room_fias_id")
  String roomFiasId;

  @Schema(description = "Кадастровый номер комнаты")
  @JsonProperty("room_cadnum")
  String roomCadnum;

  @Schema(description = "Тип комнаты (сокращенный)")
  @JsonProperty("room_type")
  String roomType;

  @Schema(description = "Тип комнаты")
  @JsonProperty("room_type_full")
  String roomTypeFull;

  @Schema(description = "Комната")
  String room;

  @Schema(description = "Абонентский ящик")
  @JsonProperty("postal_box")
  String postalBox;

  @Schema(description = "ФИАС-код (он же код ГАР) адреса для России")
  @JsonProperty("fias_id")
  String fiasId;

  @Schema(description = "Иерархический код адреса в ФИАС")
  @JsonProperty("fias_code")
  String fiasCode;

  @Schema(description = "Уровень детализации, до которого адрес найден в ФИАС (ГАР)")
  @JsonProperty("fias_level")
  String fiasLevel;

  @Schema(description = "Признак актуальности адреса в ФИАС")
  @JsonProperty("fias_actuality_state")
  String fiasActualityState;

  @Schema(description = "КЛАДР-код")
  @JsonProperty("kladr_id")
  String kladrId;

  @Schema(description = "Идентификатор объекта в базе GeoNames")
  @JsonProperty("geoname_id")
  String geonameId;

  @Schema(description = "Признак центра района или региона")
  @JsonProperty("capital_marker")
  String capitalMarker;

  @Schema(description = "Код ОКАТО")
  String okato;

  @Schema(description = "Код ОКТМО")
  String oktmo;

  @Schema(description = "Код ИФНС для физических лиц")
  @JsonProperty("tax_office")
  String taxOffice;

  @Schema(description = "Код ИФНС для организаций")
  @JsonProperty("tax_office_legal")
  String taxOfficeLegal;

  @Schema(description = "Часовой пояс")
  String timezone;

  @Schema(description = "Координаты: широта")
  @JsonProperty("geo_lat")
  String geoLat;

  @Schema(description = "Координаты: долгота")
  @JsonProperty("geo_lon")
  String geoLon;

  @Schema(description = "Внутри кольцевой?")
  @JsonProperty("beltway_hit")
  String beltwayHit;

  @Schema(description = "Расстояние от кольцевой в километрах")
  @JsonProperty("beltway_distance")
  String beltwayDistance;

  @Schema(description = "Список ближайших станций метро")
  List<DaDataMetro> metro;

  @Schema(description = "")
  String divisions;

  @Schema(description = "Код точности координат")
  @JsonProperty("qc_geo")
  String qcGeo;

  @Schema(description = "Код пригодности к рассылке")
  @JsonProperty("qc_complete")
  String qcComplete;

  @Schema(description = "Признак наличия дома в ФИАС")
  @JsonProperty("qc_house")
  String qcHouse;

  @Schema(description = "Список исторических названий объекта нижнего уровня")
  @JsonProperty("history_values")
  List<String> historyValues;

  @Schema(description = "Нераспознанная часть адреса")
  @JsonProperty("unparsed_parts")
  String unparsedParts;

  @Schema(description = "Исходный адрес одной строкой")
  String source;

  @Schema(description = "Код проверки адреса")
  String qc;

  // Вычисляемые поля для InternalData
  @JsonIgnore String build;

  @JsonIgnore String struct;

  public String getBuild() {
    if (blockType != null && blockType.equals("к")) {
      return block;
    }
    return build;
  }

  public String getStruct() {
    if (blockType != null && blockType.equals("стр")) {
      return block;
    }
    return struct;
  }
}
