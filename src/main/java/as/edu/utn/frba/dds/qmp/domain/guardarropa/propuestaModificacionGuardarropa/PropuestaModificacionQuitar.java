package as.edu.utn.frba.dds.qmp.domain.guardarropa.propuestaModificacionGuardarropa;

import as.edu.utn.frba.dds.qmp.domain.Usuario;
import as.edu.utn.frba.dds.qmp.domain.guardarropa.Guardarropa;
import as.edu.utn.frba.dds.qmp.domain.prenda.Prenda;

public class PropuestaModificacionQuitar extends PropuestaModificacionGuardarropa {
  public PropuestaModificacionQuitar(Prenda prenda, Usuario usuario) {
    super(prenda, usuario);
  }

  public void aplicar(Guardarropa guardarropa) {
    this.aplicada = true;
    guardarropa.quitarPrenda(this.prenda, this.usuario);
  }

  @Override
  public void deshacer(Guardarropa guardarropa) {
    this.aplicada = false;
    guardarropa.agregarPrenda(this.prenda, this.usuario);
  }
}
