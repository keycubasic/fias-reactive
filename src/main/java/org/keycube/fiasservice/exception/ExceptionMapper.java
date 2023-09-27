package org.keycube.fiasservice.exception;

import static org.jboss.resteasy.reactive.RestResponse.Status.INTERNAL_SERVER_ERROR;
import static org.jboss.resteasy.reactive.RestResponse.Status.UNAUTHORIZED;

import javax.inject.Inject;
import javax.ws.rs.NotAuthorizedException;
import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

public class ExceptionMapper {

  @Inject Logger log;

  @ServerExceptionMapper
  public RestResponse<String> mapFiasException(FiasApplicationException exception) {
    log.error(exception.name);
    return RestResponse.status(INTERNAL_SERVER_ERROR, exception.name);
  }

  @ServerExceptionMapper
  public RestResponse<String> mapAuthException(NotAuthorizedException exception) {
    log.error(exception.getMessage());
    return RestResponse.status(UNAUTHORIZED, exception.getMessage());
  }
}
