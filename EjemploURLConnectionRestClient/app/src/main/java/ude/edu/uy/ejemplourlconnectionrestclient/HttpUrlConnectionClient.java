package ude.edu.uy.ejemplourlconnectionrestclient;


import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpUrlConnectionClient {
    public static final String GET = "GET";
    public static final String POST = "POST";
    private static final String TAG = "HttpUrlConnectionClient";

    public RestDataDto sendGetOkHttp(String urlServer) {
        OkHttpClient client = new OkHttpClient();
        RestDataDto restDataDto = new RestDataDto();

        Request request = new Request.Builder()
                .url(urlServer)
                .build();
        try {
            Response response = client.newCall(request).execute();

            if (!response.isSuccessful()){
                throw new IOException("Unexpected code " + response);
            }

            JSONObject jsonObject = new JSONObject(response.body().string());

            restDataDto.setType(jsonObject.getString("type"));
            JSONObject value = jsonObject.getJSONObject("value");
            if (null != value) {
                restDataDto.setId(value.getInt("id"));
                restDataDto.setQuote(value.getString("quote"));
            }
        } catch (Exception e) {
            Log.e(TAG, "Error en comunicacion", e);
        }
        return restDataDto;
    }

    public RestDataDto sendGet(String urlServer) {
        URL url;
        RestDataDto restDataDto = null;
        try {
            url = new URL(urlServer);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod(GET);
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            while (null != (inputLine = in.readLine())) {
                restDataDto = new RestDataDto();
                Log.i(TAG, "Llegando " + inputLine);
                JSONObject jsonObject = new JSONObject(inputLine);
                restDataDto.setType(jsonObject.getString("type"));
                JSONObject value = jsonObject.getJSONObject("value");
                if (null != value) {
                    restDataDto.setId(value.getInt("id"));
                    restDataDto.setQuote(value.getString("quote"));
                }
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return restDataDto;
    }

    /*Ejemplo de llamada:
    JSONObject jsonObject=new JSONObject();
        try {
            jsonObject.put("id","15");
            jsonObject.put("nombre","Marc");
            jsonObject.put("email","marc@test.com");
            jsonObject.put("edad","47");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        httpUrlConnectionClient.sendPost("http://192.168.1.46:8080/persona/",jsonObject.toString());*/
    public String sendPost(String urlServer, String args) {
        StringBuffer result = new StringBuffer();
        String inputLine;
        try {
            URL url = new URL(urlServer);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod(POST);
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty("charset", "utf-8");
            OutputStreamWriter out = new OutputStreamWriter(httpURLConnection.getOutputStream());
            out.write("persona=" + args);
            out.close();
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            while (null != (inputLine = in.readLine())) {
                result.append(inputLine);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
