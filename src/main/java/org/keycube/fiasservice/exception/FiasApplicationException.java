package org.keycube.fiasservice.exception;

public class FiasApplicationException extends RuntimeException {
  static final long serialVersionUID = 540L;
  public final String name;

  public FiasApplicationException(String name) {
    this.name = name;
  }
}
