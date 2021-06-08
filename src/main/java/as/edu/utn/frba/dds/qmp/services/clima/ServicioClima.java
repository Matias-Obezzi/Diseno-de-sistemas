package as.edu.utn.frba.dds.qmp.services.clima;

import java.util.List;

import org.json.JSONObject;

public interface ServicioClima {
  public JSONObject climaEn(String ciudad);

  public JSONObject alertasEn(String ciudad);

  public List<JSONObject> ultimasAlertas(String ciudad);
}
