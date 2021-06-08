package as.edu.utn.frba.dds.qmp.repositories;

import as.edu.utn.frba.dds.qmp.dominio.Usuario;

import java.util.List;

public interface RepositorioBase<T> {
  public static RepositorioBase getRepositorio() {
    return null;
  }

  public List<T> todo();

  public void agregar(T dato);
}