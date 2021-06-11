package as.edu.utn.frba.dds.qmp.domain;

import as.edu.utn.frba.dds.qmp.repositories.RepositorioAlertas;
import as.edu.utn.frba.dds.qmp.repositories.RepositorioUsuarios;
import as.edu.utn.frba.dds.qmp.services.clima.ServicioClima;

public class Empleado {
  public void sugerenciasDiariasUsuarios() {
    RepositorioUsuarios.getRepositorio().todo().forEach(Usuario::sugerenciaDiaria);
  }
}
