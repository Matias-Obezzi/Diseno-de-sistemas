package as.edu.utn.frba.dds.qmp.domain;

import as.edu.utn.frba.dds.qmp.domain.accionConfigurable.AccionConfigurable;
import as.edu.utn.frba.dds.qmp.domain.guardarropa.Guardarropa;
import as.edu.utn.frba.dds.qmp.domain.prenda.Prenda;
import as.edu.utn.frba.dds.qmp.services.sugerencia.GeneradorSugerencias;
import as.edu.utn.frba.dds.qmp.repositories.RepositorioGuardarropas;
import as.edu.utn.frba.dds.qmp.services.sugerencia.SugerenciasDiarias;

import java.util.*;

public class Usuario {
  Sugerencia sugerenciaDiaria;
  List<AccionConfigurable> accionesConfigurables;

  public void agregarAccionConfigurable (AccionConfigurable accionConfigurable) {
    accionesConfigurables.add(accionConfigurable);
  }

  public void ejecutarAccionesConfigurables() {
    accionesConfigurables.forEach(accionConfigurable -> accionConfigurable.aplicar(this));
  }

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
  public Sugerencia sugerencias(GeneradorSugerencias generadorSugerencias, Guardarropa guardarropa) {
    // Chiche para verificar que el usuario pueda acceder a las prendas
    guardarropa.validarPermisosUsuario(this);
    return generadorSugerencias.generadorSugerenciasDesde(guardarropa.prendas());
  }

  public void sugerenciaDiaria() {
    List<Guardarropa> guardarropas = RepositorioGuardarropas.getRepositorio().obtenerGuardarropasDueño(this);
    List<Atuendo> atuendosSugeridos = new ArrayList<>();
    guardarropas.forEach(guardarropa -> {
      Sugerencia sugerenciaTemp= new SugerenciasDiarias().sugerencias(guardarropa.prendas());
      atuendosSugeridos.addAll(sugerenciaTemp.atuendos());
    });
    this.sugerenciaDiaria = new Sugerencia(atuendosSugeridos);
  }
}
