package as.edu.utn.frba.dds.qmp.dominio;

import as.edu.utn.frba.dds.qmp.dominio.prenda.Prenda;
import as.edu.utn.frba.dds.qmp.dominio.servicioClima.ServicioClima;
import as.edu.utn.frba.dds.qmp.dominio.sugerencia.GeneradorSugerencias;
import as.edu.utn.frba.dds.qmp.repositories.RepositorioGuardarropas;

import java.util.*;

public class Usuario {
  private String id;
  private final ServicioClima servicioClimatico;
  private final RepositorioGuardarropas repositorioGuardarropas;
  private final GeneradorSugerencias generadorSugerencias;

  public Usuario(ServicioClima servicioClima,
                 RepositorioGuardarropas repositorioGuardarropas,
                 GeneradorSugerencias generadorSugerencias) {
    this.servicioClimatico = servicioClima;
    this.repositorioGuardarropas = repositorioGuardarropas;
    this.generadorSugerencias = generadorSugerencias;
    this.id = UUID.randomUUID().toString();
  }

  public void nuevoGuardarropa() {
    this.repositorioGuardarropas.nuevo(new Guardarropa(this.id));
  }

  public void nuevaPrenda(Prenda prenda, String idGuardarropa) {
    this.guardarropaPorId(idGuardarropa).nuevaPrenda(prenda);
  }

  public Guardarropa guardarropaPorId(String idGuardarropa) {
    return this.repositorioGuardarropas.obtenerPorGuardaropaId(idGuardarropa);
  }

  public List<Guardarropa> guardarropasUsuario() {
    return this.repositorioGuardarropas.obtenerPorUsuarioId(this.id);
  }

  public List<Atuendo> sugerenciasClimaticas(String idGuardarropa) throws Exception {
    Guardarropa guardarropa = this.guardarropaPorId(idGuardarropa);
    return guardarropa.sugerencias(this.generadorSugerencias);
  }
}
