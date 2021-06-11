package as.edu.utn.frba.dds.qmp.services;

import as.edu.utn.frba.dds.qmp.domain.alerta.Alerta;
import as.edu.utn.frba.dds.qmp.services.clima.ServicioClima;
import as.edu.utn.frba.dds.qmp.repositories.RepositorioAlertas;
import org.json.JSONObject;

import java.util.List;

public class AlertaService {
  ServicioClima servicioClima;

  public AlertaService(ServicioClima servicioClima) {
    this.servicioClima = servicioClima;
  }

  public void consultarActualizar (String ciudad) {
    RepositorioAlertas repositorioAlertas = RepositorioAlertas.getRepositorio();
    repositorioAlertas.eliminarDeCiudad(ciudad);
    repositorioAlertas.agregar(servicioClima.alertasEn(ciudad));
  }

  public List<Alerta> ultimasAlertas (String ciudad) {
    return RepositorioAlertas.getRepositorio().deCiudad(ciudad);
  }
}
