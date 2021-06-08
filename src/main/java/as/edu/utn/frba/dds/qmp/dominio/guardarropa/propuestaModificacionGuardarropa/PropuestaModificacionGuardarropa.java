package as.edu.utn.frba.dds.qmp.dominio.guardarropa.propuestaModificacionGuardarropa;

import as.edu.utn.frba.dds.qmp.dominio.Usuario;
import as.edu.utn.frba.dds.qmp.dominio.guardarropa.Guardarropa;
import as.edu.utn.frba.dds.qmp.dominio.prenda.Prenda;

public abstract class PropuestaModificacionGuardarropa {
  protected Prenda prenda;
  protected Usuario usuario;
  protected boolean aplicada = false;

  public PropuestaModificacionGuardarropa(Prenda prenda, Usuario usuario) {
    this.prenda = prenda;
    this.usuario = usuario;
  }

  public boolean aplicada () {
    return this.aplicada;
  }

  public abstract void aplicar(Guardarropa guardarropa);

  public abstract void deshacer(Guardarropa guardarropa);
}
