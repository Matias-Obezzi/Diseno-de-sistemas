package as.edu.utn.frba.dds.qmp.dominio.sugerencia;

import as.edu.utn.frba.dds.qmp.dominio.servicioClima.AccuWeatherAPI;
import as.edu.utn.frba.dds.qmp.dominio.Atuendo;
import as.edu.utn.frba.dds.qmp.dominio.prenda.Prenda;
import as.edu.utn.frba.dds.qmp.dominio.servicioClima.ServicioClima;
import org.json.JSONObject;

import java.util.List;
import java.util.stream.Collectors;

public class SugerenciaClimatica extends GeneradorSugerencias{
  private String lugar;

  public SugerenciaClimatica(String lugar) {
    super();
    this.lugar = lugar;
  }

  public List<Atuendo> sugerencias(List<Prenda> prendasGuardarropa) throws Exception {
    // Aca en realidad deberia de tomar la api seteada en un configuracion o algo similar en lugar de siempre
    // accuWeather. Queda para futura implementacion :)
    ServicioClima apiClima = new AccuWeatherAPI();
    JSONObject clima = apiClima.getWeather(lugar);
    int temperatura = clima.getJSONObject("Temperature").getInt("Value");
    List<Prenda> prendasValidas = prendasGuardarropa.stream().filter(prenda -> prenda.acordeATemperatura(temperatura)).collect(Collectors.toList());
    return this.generadorSugerenciasDesde(prendasValidas);
  }
}
