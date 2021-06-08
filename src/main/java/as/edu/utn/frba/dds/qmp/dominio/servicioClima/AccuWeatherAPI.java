package as.edu.utn.frba.dds.qmp.dominio.servicioClima;
import org.json.JSONObject;

import java.util.*;

public class AccuWeatherAPI implements ServicioClima{
  private List<JSONObject> sugerencias;

  public List<JSONObject> ultimasSugerencias() {
    return sugerencias;
  }

  public JSONObject climaEn(String ciudad) {
    JSONObject respuesta = new JSONObject();
    respuesta.append("DateTime", "2019-05-03T01:00:00-03:00");
    respuesta.append("EpochDateTime", 1556856000);
    respuesta.append("WeatherIcon", 33);
    respuesta.append("IconPhrase", "Clear");
    respuesta.append("IsDaylight", false);
    respuesta.append("PrecipitationProbability", 0);
    respuesta.append("MobileLink", "http://m.accuweather.com/en/ar/villa-vil/7984/");
    respuesta.append("Link", "http://www.accuweather.com/en/ar/villa-vil/7984");
    respuesta.append(
      "Temperature",
      new JSONObject()
        .append("Value", 57)
        .append("Unit", "F")
        .append("UnitType", 18)
    );
    return respuesta;
  }
}