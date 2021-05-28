package as.edu.utn.frba.dds.qmp.repositories;

import as.edu.utn.frba.dds.qmp.dominio.Guardarropa;
import as.edu.utn.frba.dds.qmp.exceptions.RepositorioExcepcion;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioGuardarropas {
  private List<Guardarropa> guardarropas;

  public Guardarropa obtenerPorGuardaropaId(String idGuardarropa) {
    List<Guardarropa> guardarropas = this.guardarropas.stream().filter(guardarropa -> guardarropa.id() == idGuardarropa).collect(Collectors.toList());
    if(guardarropas.size() == 0)
      throw new RepositorioExcepcion("No se encontro un guardarropas para ese id");
    return guardarropas.get(0);
  }

  public List<Guardarropa> obtenerPorUsuarioId(String idUsuario) {
    List<Guardarropa> guardarropasUsuario = this.guardarropas.stream().filter(guardarropa -> guardarropa.guardarropasDeUsuario(idUsuario)).collect(Collectors.toList());
    return guardarropasUsuario;
  }

  public void nuevo(Guardarropa guardarropa) {
    this.guardarropas.add(guardarropa);
  }

}
