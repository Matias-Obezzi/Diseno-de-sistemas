package as.edu.utn.frba.dds.qmp.exceptions;

import as.edu.utn.frba.dds.qmp.dominio.prenda.Categoria;

public class ServicioClimaException extends RuntimeException {
  public ServicioClimaException(String mensaje) {
    super(mensaje);
  }
}
