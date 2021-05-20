package as.edu.utn.frba.dds.qmp.dominio.servicioClima;

import as.edu.utn.frba.dds.qmp.exceptions.ServicioClimaException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class ServicioClima<T> {
  private String apiUrl;
  private String token;

  public ServicioClima(String apiUrl, String token) {
    // Token deberia tener cabecera (bearer, basic, etc)
    this.apiUrl = apiUrl;
    this.token = token;
  }
  public JSONObject getWeather(String ciudad) throws Exception {
    StringBuilder resultado = new StringBuilder();
    URL url = new URL(this.apiUrl);
    HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
    conexion.setRequestMethod("GET");
    conexion.setRequestProperty("Authorization", this.token);
    BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
    String linea;
    while ((linea = rd.readLine()) != null) {
      resultado.append(linea);
    }
    rd.close();
    return new JSONObject().getJSONObject(resultado.toString());
  }

  private static String readAll(Reader rd) throws Exception {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    return sb.toString();
  }
}
