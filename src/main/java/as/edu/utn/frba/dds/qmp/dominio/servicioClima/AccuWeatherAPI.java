package as.edu.utn.frba.dds.qmp.dominio.servicioClima;
import org.json.JSONObject;

import java.util.*;

public final class AccuWeatherAPI extends ServicioClima{

  // Si, lo se. Esta no es la "API" que dejaron en el documento. Opte por cambiar el tipo de dato que
  // responde por uno mas acorde a la consumision de una api. Gracias a esto ultimo, el admin puede
  // "crear" consumidores de api. No se me ocurrio otra forma de que todos sean implementacion de la misma
  // interfaz

  public AccuWeatherAPI() {
    super("http://dataservice.accuweather.com/locations/v1/adminareas", "Hola soy un token");
  }

  @Override
  public final JSONObject getWeather(String ciudad) {
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