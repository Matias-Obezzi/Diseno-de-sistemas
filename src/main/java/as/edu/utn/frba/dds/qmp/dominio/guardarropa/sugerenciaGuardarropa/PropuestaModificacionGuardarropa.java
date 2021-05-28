package as.edu.utn.frba.dds.qmp.dominio.guardarropa.sugerenciaGuardarropa;

import as.edu.utn.frba.dds.qmp.dominio.guardarropa.Guardarropa;
import as.edu.utn.frba.dds.qmp.dominio.prenda.Prenda;

public abstract class PropuestaModificacionGuardarropa {
  protected Prenda prenda;
  protected String idUsuario;

  public PropuestaModificacionGuardarropa(Prenda prenda, String idUsuario) {
    this.prenda = prenda;
    this.idUsuario = idUsuario;
  }

  public abstract void aplicar(Guardarropa guardarropa);

  public abstract void deshacer(Guardarropa guardarropa);
}
