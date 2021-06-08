package as.edu.utn.frba.dds.qmp.repositories;

import as.edu.utn.frba.dds.qmp.dominio.Usuario;
import as.edu.utn.frba.dds.qmp.dominio.guardarropa.Guardarropa;
import as.edu.utn.frba.dds.qmp.exceptions.RepositorioExcepcion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioUsuarios implements RepositorioBase<Usuario> {
  private static RepositorioUsuarios repositorio;
  private List<Usuario> usuarios = new ArrayList<>();

  public static RepositorioUsuarios getRepositorio() {
    if (repositorio == null) {
      repositorio = new RepositorioUsuarios();
    }
    return repositorio;
  }

  public List<Usuario> todo() {
    return this.usuarios;
  }

  public void agregar(Usuario usuario) {
    this.usuarios.add(usuario);
  }
}
