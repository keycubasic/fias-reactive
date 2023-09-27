package org.keycube.fiasservice;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeIn;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;
import org.eclipse.microprofile.openapi.annotations.security.SecuritySchemes;

@ApplicationPath("/fias-reactive")
@OpenAPIDefinition(
    info =
        @Info(
            title = "FIAS Reactive",
            description =
                "Сервис получения информации по адресу из справочников ФИАС (с резервным сервисом DaData)",
            version = "1.0.0",
                contact = @Contact(
                        name = "Константинов Константин Константинович",
                        email = "keycube@mail.ru"
                )
        )
)
@SecuritySchemes({
  @SecurityScheme(
      securitySchemeName = "keycloak",
      type = SecuritySchemeType.OPENIDCONNECT,
      openIdConnectUrl = ""),
  @SecurityScheme(
      securitySchemeName = "jwt",
      apiKeyName = "Authorization",
      scheme = "Bearer",
      type = SecuritySchemeType.HTTP,
      in = SecuritySchemeIn.HEADER)
})
public class FiasApplication extends Application {}
