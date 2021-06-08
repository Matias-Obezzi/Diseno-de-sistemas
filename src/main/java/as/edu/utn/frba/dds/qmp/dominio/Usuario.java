package as.edu.utn.frba.dds.qmp.dominio;

import as.edu.utn.frba.dds.qmp.dominio.guardarropa.Guardarropa;
import as.edu.utn.frba.dds.qmp.dominio.prenda.Prenda;
import as.edu.utn.frba.dds.qmp.dominio.sugerencia.GeneradorSugerencias;
import as.edu.utn.frba.dds.qmp.repositories.RepositorioGuardarropas;
import java.util.*;

public class Usuario {
  public void nuevoGuardarropa(String descripcion, List<Prenda> prendas) {
    RepositorioGuardarropas.getRepositorio().agregar(new Guardarropa(this, descripcion, prendas));
  }

  public List<Guardarropa> guardarropasUsuario() {
    return RepositorioGuardarropas.getRepositorio().obtenerGuardarropasDueño(this);
  }

  /**
   * Generador de cualquier tipo de sugerencias, recibe el
   * generador y el guardarropa (al cual debe tener acceso
   * el usuario) para devolver las sugerencias.
   */
  public List<Atuendo> sugerencias(GeneradorSugerencias generadorSugerencias, Guardarropa guardarropa) {
    // Chiche para verificar que el usuario pueda acceder a las prendas
    guardarropa.validarPermisosUsuario(this);
    return generadorSugerencias.generadorSugerenciasDesde(guardarropa.prendas());
  }
}
