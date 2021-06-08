package as.edu.utn.frba.dds.qmp.dominio.sugerencia;

import as.edu.utn.frba.dds.qmp.dominio.servicioClima.AccuWeatherAPI;
import as.edu.utn.frba.dds.qmp.dominio.Atuendo;
import as.edu.utn.frba.dds.qmp.dominio.prenda.Prenda;
import as.edu.utn.frba.dds.qmp.dominio.servicioClima.ServicioClima;
import org.json.JSONObject;

import java.util.List;
import java.util.stream.Collectors;

public class SugerenciaClimaticaDeAtuendo extends GeneradorSugerencias{
  private ServicioClima apiClima;
  private String lugar;

  public SugerenciaClimaticaDeAtuendo(ServicioClima apiClima, String lugar) {
    super();
    this.apiClima = apiClima;
    this.lugar = lugar;
  }

  public List<Atuendo> sugerencias(List<Prenda> prendasGuardarropa) {
    JSONObject clima = apiClima.getWeather(lugar);
    int temperatura = clima.getJSONObject("Temperature").getInt("Value");
    List<Prenda> prendasValidas = prendasGuardarropa.stream().filter(prenda -> prenda.acordeATemperatura(temperatura)).collect(Collectors.toList());
    return this.generadorSugerenciasDesde(prendasValidas);
  }
}
