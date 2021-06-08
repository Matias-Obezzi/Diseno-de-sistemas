package as.edu.utn.frba.dds.qmp.repositories;

import as.edu.utn.frba.dds.qmp.domain.Usuario;

import java.util.ArrayList;
import java.util.List;

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
