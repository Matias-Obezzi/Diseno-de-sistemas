package as.edu.utn.frba.dds.qmp.domain.guardarropa;

import as.edu.utn.frba.dds.qmp.domain.Usuario;
import as.edu.utn.frba.dds.qmp.domain.guardarropa.propuestaModificacionGuardarropa.PropuestaModificacionGuardarropa;
import as.edu.utn.frba.dds.qmp.domain.prenda.Prenda;
import as.edu.utn.frba.dds.qmp.exceptions.PropuestaModificacionGuardarropaException;
import as.edu.utn.frba.dds.qmp.exceptions.UsuarioException;

import java.util.List;

public class Guardarropa {
  private Usuario dueño;
  private List<Usuario> invitados;

  private String descripcion;

  private List<Prenda> prendas;
  private List<PropuestaModificacionGuardarropa> propuestaPendientes;

  public Guardarropa(Usuario dueño, String descripcion, List<Prenda> prendas) {
    this.dueño = dueño;
    this.descripcion = descripcion;
    this.prendas = prendas;
  }

  public void agregarPrenda(Prenda prenda, Usuario usuario) {
    validarPermisosUsuario(usuario);
    this.prendas.add(prenda);
  }

  public void quitarPrenda(Prenda prenda, Usuario usuario) {
    validarPermisosUsuario(usuario);
    this.prendas.remove(prenda);
  }

  public void agregarPropuesta(PropuestaModificacionGuardarropa propuesta) {
    this.propuestaPendientes.add(propuesta);
  }

  public void aceptarPropuesta(PropuestaModificacionGuardarropa propuesta) {
    evaluarEstadoPropuesta(propuesta, false);
    propuesta.aplicar(this);
  }

  public void deshacerPropuesta(PropuestaModificacionGuardarropa propuesta) {
    evaluarEstadoPropuesta(propuesta, true);
    propuesta.deshacer(this);
  }

  public void rechazarPropuesta(PropuestaModificacionGuardarropa propuesta) {
    evaluarEstadoPropuesta(propuesta, false);
    this.propuestaPendientes.remove(propuesta);
  }

  public void agregarInvitado(Usuario usuario) {
    this.invitados.add(usuario);
  }

  public void descripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public List<Prenda> prendas() {
    return this.prendas;
  }

  public Usuario dueño() {
    return this.dueño;
  }

  public List<Usuario> invitados() {
    return this.invitados;
  }

  public boolean guardarropasDeUsuario(Usuario usuario) {
    return this.dueño.equals(usuario);
  }

  public boolean usuarioEnGuardarropa(Usuario usuario) {
    return this.dueño.equals(usuario) || this.invitados.contains(usuario);
  }

  public void validarPermisosUsuario(Usuario usuario) {
    if(!this.usuarioEnGuardarropa(usuario)) {
      throw new UsuarioException("No te encuentras entre los usuarios del guardarropa por lo que no posee permisos suficientes");
    }
  }

  public String descripcion() {
    return this.descripcion;
  }

  private void evaluarEstadoPropuesta(PropuestaModificacionGuardarropa prouesta, boolean estado) {
    if(prouesta.aplicada() != estado) {
      throw new PropuestaModificacionGuardarropaException("No se puede realizar la acción debido a su estado");
    }
  }
}
