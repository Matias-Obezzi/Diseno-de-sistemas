package as.edu.utn.frba.dds.qmp.dominio.servicioClima;

import as.edu.utn.frba.dds.qmp.exceptions.ServicioClimaException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

public interface ServicioClima {

  public JSONObject getWeather(String ciudad);
}
