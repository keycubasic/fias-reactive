package org.keycube.fiasservice.health;

import static org.jboss.resteasy.reactive.RestResponse.Status.NOT_FOUND;

import javax.inject.Inject;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.health.Liveness;
import org.keycube.fiasservice.internal.service.InternalService;

@Liveness
public class LivenessCheck implements HealthCheck {

  @Inject
  InternalService service;

  @Override
  public HealthCheckResponse call() {
    HealthCheckResponseBuilder builder =
        HealthCheckResponse.named("Oracle database connection health check");
    try {
      String dummy = service.healthCheck().await().indefinitely();
      builder = builder.up().withData("DUMMY", dummy);
    } catch (Exception e) {
      builder = builder.down().withData("DUMMY", NOT_FOUND.getReasonPhrase());
    }
    return builder.build();
  }
}
