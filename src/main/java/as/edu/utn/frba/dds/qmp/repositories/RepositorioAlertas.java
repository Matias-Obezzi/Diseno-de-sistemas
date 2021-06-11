package as.edu.utn.frba.dds.qmp.repositories;

import as.edu.utn.frba.dds.qmp.domain.alerta.Alerta;
import as.edu.utn.frba.dds.qmp.services.AlertaService;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioAlertas implements RepositorioBase<Alerta> {
  private static RepositorioAlertas repositorio;
  private List<Alerta> alertas = new ArrayList<>();

  public static RepositorioAlertas getRepositorio() {
    if (repositorio == null) {
      repositorio = new RepositorioAlertas();
    }
    return repositorio;
  }

  public List<Alerta> todo() {
    return this.alertas;
  }

  public List<Alerta> deCiudad(String ciudad) {
    return alertas.stream().filter(alerta -> alerta.esCiudad(ciudad)).collect(Collectors.toList());
  }

  public void agregar(Alerta alerta) {
    this.alertas.add(alerta);
  }

  public void eliminarDeCiudad(String ciudad) {
    alertas = alertas.stream().filter(alerta -> !alerta.esCiudad(ciudad)).collect(Collectors.toList());
  }
}
