package org.appLibreria.dominio;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Devolucion {

  private LocalDate fechaEntrega;

  public Devolucion(LocalDate fechaEntrega) {
    this.fechaEntrega = fechaEntrega;
  }

  public LocalDate getFechaEntrega() {
    return fechaEntrega;
  }

  public void setFechaEntrega(LocalDate fechaEntrega) {
    this.fechaEntrega = fechaEntrega;
  }

  public void retraso(LocalDate fchDevolucionReal) {
    if (fchDevolucionReal.isAfter(this.getFechaEntrega())) {
      long diferenciaEnDias = ChronoUnit.DAYS.between(this.getFechaEntrega(), fchDevolucionReal);
      long multa = diferenciaEnDias * 1000;
      System.out.println(String.format(
              "Multa corresponde a $%s, por los dias de retraso %s",
              multa, diferenciaEnDias));
    }
  }
}
