package org.keycube.fiasservice.log;

import io.quarkus.logging.LoggingFilter;
import java.util.logging.Filter;
import java.util.logging.LogRecord;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@LoggingFilter(name = "fias-filter")
public final class LogFilter implements Filter {

  private final String part;

  public LogFilter(@ConfigProperty(name = "fias-filter.part") String part) {
    this.part = part;
  }

  @Override
  public boolean isLoggable(LogRecord record) {
    return !record.getMessage().contains(part);
  }
}
