package as.edu.utn.frba.dds.qmp.dominio.guardarropa;

import as.edu.utn.frba.dds.qmp.dominio.Atuendo;
import as.edu.utn.frba.dds.qmp.dominio.guardarropa.propuestaModificacionGuardarropa.PropuestaModificacionGuardarropa;
import as.edu.utn.frba.dds.qmp.dominio.prenda.Prenda;
import as.edu.utn.frba.dds.qmp.dominio.sugerencia.GeneradorSugerencias;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Guardarropa {
  private String id;
  private String descripcion;
  private List<Prenda> prendas;
  private List<String> idUsuarios;
  private List<PropuestaModificacionGuardarropa> propuestaPendientes;
  private List<PropuestaModificacionGuardarropa> propuestaAceptadas;

  public Guardarropa(String idUsuario) {
    this(idUsuario,"");
  }

  public Guardarropa(String idUsuario, String descripcion) {
    this(idUsuario, descripcion, Arrays.asList());
  }

  public Guardarropa(String idUsuario, String descripcion, List<Prenda> prendas) {
    this.idUsuarios.add(idUsuario);
    this.descripcion = descripcion;
    this.prendas = prendas;
    this.id = UUID.randomUUID().toString();
  }

  public void nuevaPrenda(Prenda prenda) {
    this.prendas.add(prenda);
  }

  public void quitarPrenda(Prenda prenda) {
    this.prendas.remove(prenda);
  }

  public void nuevaPropuesta(PropuestaModificacionGuardarropa propuesta) {
    this.propuestaPendientes.add(propuesta);
  }

  public void aceptarPropuesta(PropuestaModificacionGuardarropa propuesta) {
    propuesta.aplicar(this);
    this.propuestaAceptadas.add(propuesta);
    this.propuestaPendientes.remove(propuesta);
  }

  public void rechazarPropuesta(PropuestaModificacionGuardarropa propuesta) {
    this.propuestaPendientes.remove(propuesta);
  }

  public void deshacerPropuesta(PropuestaModificacionGuardarropa propuesta) {
    propuesta.deshacer(this);
    this.propuestaPendientes.add(propuesta);
    this.propuestaAceptadas.remove(propuesta);
  }

  public void nuevoUsuario(String idUsuario) {
    idUsuarios.add(idUsuario);
  }

  public void descripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public List<Prenda> prendas() {
    return this.prendas;
  }

  public List<Atuendo> sugerencias(GeneradorSugerencias generadorSugerencias) throws Exception {
    return generadorSugerencias.sugerencias(this.prendas);
  }

  public List<String> idUsuarios() {
    return this.idUsuarios;
  }

  public boolean guardarropasDeUsuario(String idUsuario) {
    return idUsuarios.contains(idUsuario);
  }

  public String id() {
    return this.id;
  }

  public String descripcion() {
    return this.descripcion;
  }
}
