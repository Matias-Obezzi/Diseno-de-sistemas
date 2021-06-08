package as.edu.utn.frba.dds.qmp.repositories;

import as.edu.utn.frba.dds.qmp.dominio.Usuario;
import as.edu.utn.frba.dds.qmp.dominio.guardarropa.Guardarropa;
import as.edu.utn.frba.dds.qmp.exceptions.RepositorioExcepcion;

import java.util.List;
import java.util.stream.Collectors;

public class RepositorioGuardarropas {
  private static RepositorioGuardarropas repositorio;
  private List<Guardarropa> guardarropas;

  public static RepositorioGuardarropas getRepositorio() {
    if(repositorio == null) {
      repositorio = new RepositorioGuardarropas();
    }
    return repositorio;
  }

  public List<Guardarropa> obtenerGuardarropasDueño(Usuario dueño) {
    List<Guardarropa> guardarropas = this.guardarropas.stream().filter(guardarropa -> guardarropa.dueño().equals(dueño)).collect(Collectors.toList());
    if(guardarropas.size() == 0)
      throw new RepositorioExcepcion("No se encontro un guardarropas de ese usuario");
    return guardarropas;
  }

  public void nuevo(Guardarropa guardarropa) {
    this.guardarropas.add(guardarropa);
  }
}
