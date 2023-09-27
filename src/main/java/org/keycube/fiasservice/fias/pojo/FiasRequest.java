package org.keycube.fiasservice.fias.pojo;

import javax.validation.constraints.NotNull;
import lombok.Data;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Data
@Schema(name = "Request", description = "Тело запроса к сервису")
public class FiasRequest {

  @Schema(required = true, description = "Данные запроса")
  @NotNull
  String query;
}
