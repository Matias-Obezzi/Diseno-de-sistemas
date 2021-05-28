package as.edu.utn.frba.dds.qmp.dominio.guardarropa.sugerenciaGuardarropa;

import as.edu.utn.frba.dds.qmp.dominio.guardarropa.Guardarropa;
import as.edu.utn.frba.dds.qmp.dominio.prenda.Prenda;

public class PropuestaModificacionQuitar extends PropuestaModificacionGuardarropa {
  public PropuestaModificacionQuitar(Prenda prenda, String idUsuario) {
    super(prenda, idUsuario);
  }

  public void aplicar(Guardarropa guardarropa) {
    guardarropa.quitarPrenda(this.prenda);
  }

  @Override
  public void deshacer(Guardarropa guardarropa) {
    guardarropa.nuevaPrenda(this.prenda);
  }
}
