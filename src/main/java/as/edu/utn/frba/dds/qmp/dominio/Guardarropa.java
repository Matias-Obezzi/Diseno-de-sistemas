package as.edu.utn.frba.dds.qmp.dominio;

import as.edu.utn.frba.dds.qmp.dominio.prenda.Prenda;
import as.edu.utn.frba.dds.qmp.dominio.sugerencia.GeneradorSugerencias;
import as.edu.utn.frba.dds.qmp.dominio.sugerencia.SugerenciaClimatica;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Guardarropa {
  private String id;
  private List<Prenda> prendas;
  private List<Prenda> prendasSugeridas;
  private List<String> idUsuarios;
  private String descripcion;

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

  public void nuevaPrenda(Prenda prenda, String idUsuario) {
    if(!this.idUsuarios.contains(idUsuario)) {
      this.nuevaSugerencia(prenda);
    } else {
      this.prendas.add(prenda);
    }
  }

  public void nuevaSugerencia(Prenda prenda) {
    this.prendasSugeridas.add(prenda);
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

  public void nuevoUsuario(String idUsuario) {
    idUsuarios.add(idUsuario);
  }

  public boolean guardarropasDeUsuario(String idUsuario) {
    return idUsuarios.contains(idUsuario);
  }

  public String id() {
    return this.id;
  }

  public void descripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public String descripcion() {
    return this.descripcion;
  }
}
