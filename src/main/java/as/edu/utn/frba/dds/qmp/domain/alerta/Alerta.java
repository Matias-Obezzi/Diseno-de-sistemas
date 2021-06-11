package as.edu.utn.frba.dds.qmp.domain.alerta;

import as.edu.utn.frba.dds.qmp.domain.alerta.tipoAlerta.AlertaGranizo;
import as.edu.utn.frba.dds.qmp.domain.alerta.tipoAlerta.AlertaTormenta;
import as.edu.utn.frba.dds.qmp.domain.alerta.tipoAlerta.TipoAlerta;
import org.json.JSONObject;

public class Alerta {
  private JSONObject datos;
  private TipoAlerta tipo;

  public Alerta(JSONObject datos) {
    this.datos = datos;
    switch (datos.getString("tipo")){
      case "tormenta":
      case "TORMENTA":
        this.tipo = new AlertaTormenta();
        break;
      case "granizo":
      case "GRANIZO":
        this.tipo = new AlertaGranizo();
        break;
    }
  }

  public JSONObject datos() {
    return this.datos;
  }

  public TipoAlerta tipoAlerta() {
    return this.tipo;
  }

  public boolean esCiudad(String ciudad) {
    return this.datos.getString("ciudad").equals(ciudad);
  }
}
