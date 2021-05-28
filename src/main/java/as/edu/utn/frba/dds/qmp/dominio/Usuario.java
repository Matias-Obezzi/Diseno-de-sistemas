package as.edu.utn.frba.dds.qmp.dominio;

import as.edu.utn.frba.dds.qmp.dominio.guardarropa.Guardarropa;
import as.edu.utn.frba.dds.qmp.dominio.guardarropa.propuestaModificacionGuardarropa.PropuestaModificacionGuardarropa;
import as.edu.utn.frba.dds.qmp.dominio.prenda.Prenda;
import as.edu.utn.frba.dds.qmp.dominio.servicioClima.ServicioClima;
import as.edu.utn.frba.dds.qmp.dominio.sugerencia.GeneradorSugerencias;
import as.edu.utn.frba.dds.qmp.exceptions.RepositorioExcepcion;
import as.edu.utn.frba.dds.qmp.exceptions.UsuarioException;
import as.edu.utn.frba.dds.qmp.repositories.RepositorioGuardarropas;

import java.util.*;
import java.util.Arrays;

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
    this.nuevoGuardarropa("");
  }

  public void nuevoGuardarropa(String descripcion) {
    this.nuevoGuardarropa(descripcion, Arrays.AsList());
  }

  public void nuevoGuardarropa(String descripcion, List<Prenda> prendas) {
    this.repositorioGuardarropas.nuevo(new Guardarropa(this.id, descripcion, prendas));
  }

  public void nuevaPrenda(Prenda prenda, String idGuardarropa) throws UsuarioException {
    Guardarropa guardarropa = this.guardarropaPorId(idGuardarropa);
    if(!guardarropa.guardarropasDeUsuario(this.id)) {
      throw new UsuarioException("No te encuentras entre los usuarios del guardarropa por lo que no posee permisos suficientes");
    }
    guardarropa.nuevaPrenda(prenda);
  }

  public void nuevaPropuestaModificacionGuardarropa(PropuestaModificacionGuardarropa propuesta, String idGuardarropa) throws RepositorioExcepcion {
    this.guardarropaPorId(idGuardarropa).nuevaPropuesta(propuesta);
  }

  public Guardarropa guardarropaPorId(String idGuardarropa) throws RepositorioExcepcion {
    return this.repositorioGuardarropas.obtenerPorGuardaropaId(idGuardarropa);
  }

  public List<Guardarropa> guardarropasUsuario() {
    return this.repositorioGuardarropas.obtenerPorUsuarioId(this.id);
  }

  public List<Atuendo> sugerenciasClimaticas(String idGuardarropa) throws Exception  {
    Guardarropa guardarropa = this.guardarropaPorId(idGuardarropa);
    return guardarropa.sugerencias(this.generadorSugerencias);
  }
}
