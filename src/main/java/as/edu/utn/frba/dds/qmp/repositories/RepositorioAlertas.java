package as.edu.utn.frba.dds.qmp.repositories;

import as.edu.utn.frba.dds.qmp.dominio.Usuario;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioAlertas implements RepositorioBase<JSONObject> {
  private static RepositorioAlertas repositorio;
  private List<JSONObject> alertas = new ArrayList<>();

  public static RepositorioAlertas getRepositorio() {
    if (repositorio == null) {
      repositorio = new RepositorioAlertas();
    }
    return repositorio;
  }

  public List<JSONObject> todo() {
    return this.alertas;
  }

  public List<JSONObject> deCiudad(String ciudad) {
    return alertas.stream().filter(alerta -> alerta.get("ciudad").equals(ciudad)).collect(Collectors.toList());
  }

  public void agregar(JSONObject alerta) {
    this.alertas.add(alerta);
  }
}
