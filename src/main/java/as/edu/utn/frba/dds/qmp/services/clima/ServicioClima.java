package as.edu.utn.frba.dds.qmp.services.clima;

import java.util.List;

import as.edu.utn.frba.dds.qmp.domain.alerta.Alerta;
import as.edu.utn.frba.dds.qmp.services.notificacion.Notificacion;
import org.json.JSONObject;

public abstract class ServicioClima {
  public abstract JSONObject climaEn(String ciudad);

  public abstract Alerta alertaEn(String ciudad);

  public abstract List<Alerta> ultimasAlertas(String ciudad);
}
