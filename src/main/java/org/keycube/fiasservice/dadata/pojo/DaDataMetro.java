package org.keycube.fiasservice.dadata.pojo;

import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Setter
@Schema(name = "Metro (DaData)", description = "Ближайшая станция метро")
public class DaDataMetro {

  @Schema(description = "Название станции")
  String name;

  @Schema(description = "Название линии")
  String line;

  @Schema(description = "Расстояние до станции в километрах")
  double distance;
}
