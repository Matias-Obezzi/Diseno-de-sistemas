package as.edu.utn.frba.dds.qmp.dominio;

import as.edu.utn.frba.dds.qmp.dominio.guardarropa.Guardarropa;
import as.edu.utn.frba.dds.qmp.dominio.prenda.Prenda;
import as.edu.utn.frba.dds.qmp.dominio.servicioClima.ServicioClima;
import as.edu.utn.frba.dds.qmp.dominio.sugerencia.GeneradorSugerencias;
import as.edu.utn.frba.dds.qmp.repositories.RepositorioGuardarropas;
import java.util.*;

public class Usuario {
  private final ServicioClima servicioClimatico;
  private final GeneradorSugerencias generadorSugerencias;

  public Usuario(ServicioClima servicioClima,
                 GeneradorSugerencias generadorSugerencias) {
    this.servicioClimatico = servicioClima;
    this.generadorSugerencias = generadorSugerencias;
  }

  public void nuevoGuardarropa(String descripcion, List<Prenda> prendas) {
    RepositorioGuardarropas.getRepositorio().nuevo(new Guardarropa(this, descripcion, prendas));
  }

  public List<Guardarropa> guardarropasUsuario() {
    return RepositorioGuardarropas.getRepositorio().obtenerGuardarropasDueño(this);
  }

  public List<Atuendo> sugerenciasClimaticas(Guardarropa guardarropa) throws Exception  {
    return guardarropa.sugerencias(this.generadorSugerencias);
  }
}
