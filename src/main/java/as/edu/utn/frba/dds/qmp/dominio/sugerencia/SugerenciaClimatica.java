package as.edu.utn.frba.dds.qmp.dominio.sugerencia;

import as.edu.utn.frba.dds.qmp.dominio.servicioClima.AccuWeatherAPI;
import as.edu.utn.frba.dds.qmp.dominio.Atuendo;
import as.edu.utn.frba.dds.qmp.dominio.prenda.Prenda;
import as.edu.utn.frba.dds.qmp.dominio.sugerencia.generadorSugerencias.GeneradorSugerencias;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SugerenciaClimatica {
  public List<Atuendo> sugerenciasClimaticas(String lugar, List<Prenda> prendasGuardarropa) {
    AccuWeatherAPI apiClima = new AccuWeatherAPI();
    // Lo pase de lista a 1 porque en un lugar hay solo un tiempo a la vez. Aunque no se pq se me hace que la
    // lista de tiempos es la lista de tiempo en X horario (a las 11 hace 23 grados, a las 14 hace 26 y asi).
    // No le preste mucha bola al "api", simplemente "consumo" y me quedo con lo q necesito.
    // En caso de que sea como digo arriba (tiempo por horario) verificaria que para todos los tiempos se cumpla
    // que las prendas sean validas
    Map<String, Object> clima = apiClima.getWeather(lugar).get(0);
    // Si, esta horripilante :\
    // No se me ocurrio mejor forma de sacarlo y convertirlos que casteando (?
    int temperatura = (int)((HashMap<String, Object>) clima.get("Temperature")).get("value");
    List<Prenda> prendasValidas = prendasGuardarropa.stream().filter(prenda -> prenda.acordeATemperatura(temperatura)).collect(Collectors.toList());
    return new GeneradorSugerencias().generadorSugerenciasDesde(prendasValidas);
  }
}
