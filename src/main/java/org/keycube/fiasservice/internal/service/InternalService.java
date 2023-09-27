package org.keycube.fiasservice.internal.service;

import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.oracleclient.OraclePool;
import io.vertx.mutiny.sqlclient.Tuple;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.jboss.logging.Logger;
import org.keycube.fiasservice.fias.pojo.FiasRequest;
import org.keycube.fiasservice.internal.pojo.InternalResponse;

@ApplicationScoped
public class InternalService {

  @Inject Logger log;

  @Inject OraclePool client;

  private static final String preparedSql =
      "select fias_utils.GetFIASFullJSON(?, ?) as suggestions from dual";

  public Uni<InternalResponse> getByStr(FiasRequest request) {
    return get(request, 0);
  }

  public Uni<InternalResponse> getById(FiasRequest request) {
    return get(request, 1);
  }

  public Uni<InternalResponse> getByKladrId(FiasRequest request) {
    return get(request, 2);
  }

  public Uni<InternalResponse> get(FiasRequest request, int type) {
    return client
        .preparedQuery(preparedSql)
        .execute(Tuple.of(request.getQuery(), type))
        .map(set -> set.iterator().next())
        .map(InternalResponse::from);
  }

  public Uni<String> healthCheck() {
    log.info("Oracle database connection health checked");
    return client
        .preparedQuery("select * from dual")
        .execute()
        .map(set -> set.iterator().next())
        .map(row -> row.getString("dummy"));
  }
}
