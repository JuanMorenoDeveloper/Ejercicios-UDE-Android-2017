package ude.edu.uy.ejemplourlconnectionrestclient;

import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@Config(manifest = Config.NONE)
@RunWith(RobolectricTestRunner.class)
public class ServiceIntegrationTest {

  @Test
  public void givenUrl_whenCallServer_thenJSONResponse() throws IOException, JSONException {
    String urlServer = "http://gturnquist-quoters.cfapps.io/api/1";
    ConnectionManager manager = mock(ConnectionManager.class);
    String expected = "{\"type\":\"success\",\"value\":{\"id\":1,\"quote\":\"Working with Spring Boot is like pair-programming with the Spring developers.\"}}";
    JSONObject object = new JSONObject(expected);
    //Stub
    when(manager.invokeJSONObject(expected)).thenReturn(object);

    JSONObject respuesta = manager.invokeJSONObject(expected);

    assertTrue(respuesta.getString("type").equals("success"));
//    JSONObject obj = new JSONObject("..");
//    //type
//    String type=obj.getString("type");
//    JSONObject inner = (JSONObject) obj.get("value");
//    //id
//    int id=inner.getInt("id");
//    //quote
//    String quote=inner.getString("quote");
//    ServicioDTO dto=new ServicioDTO(type,id,quote);
//    dto.id;
//    dto.quoute;
//    dto.type;
  }

  class ServicioDTO {

    String type;
    int id;
    String quoute;

    public ServicioDTO(String type, int id, String quoute) {
      this.type = type;
      this.id = id;
      this.quoute = quoute;
    }
  }

  @Test
  public void givenUrl_whenCallServer_thenResponse() throws Exception {
    String urlServer = "http://gturnquist-quoters.cfapps.io/api/1";
    String respuesta = new ConnectionManager(urlServer).invoke();
    String expected = "{\"type\":\"success\",\"value\":{\"id\":1,\"quote\":\"Working with Spring Boot is like pair-programming with the Spring developers.\"}}";

    assertTrue(respuesta.equals(expected));
  }

  public class ConnectionManager {

    private String urlServer;

    public ConnectionManager(String urlServer) {
      this.urlServer = urlServer;
    }

    public JSONObject invokeJSONObject(String datos) throws JSONException {
      return new JSONObject(datos);
    }

    public String invoke() throws IOException, JSONException {
      //Definimos URL al servidor
      URL url = new URL(urlServer);
      HttpURLConnection connection =
          (HttpURLConnection) url.openConnection();
      //Defino datos a negociar con el servidor
      connection.setRequestProperty("Content-Type",
          "application/json;charset=UTF-8");
      //Defino el metodo de llamada al servidor
      connection.setRequestMethod("GET");
      BufferedReader scanner = new BufferedReader(
          new InputStreamReader(connection.getInputStream()));
      String input;
      StringBuffer buffer = new StringBuffer();
      while ((input = scanner.readLine()) != null) {
        buffer.append(input);
      }
      scanner.close();
      return buffer.toString();
    }
  }
}