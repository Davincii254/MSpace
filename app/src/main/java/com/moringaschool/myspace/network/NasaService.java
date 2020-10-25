package com.moringaschool.myspace.network;

import com.moringaschool.myspace.Constants;
import com.moringaschool.myspace.models.Apods;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NasaService {
    public static void findApods(String date, Callback callback){
    OkHttpClient client = new OkHttpClient.Builder()
            .build();

    HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.API_BASE_URL).newBuilder();
    urlBuilder.addQueryParameter(Constants.NASA_DATE_QUERY_PARAMETER, date);
    String url = urlBuilder.build().toString();

    Request request = new Request.Builder()
            .url(url)
            .header("Authorization", Constants.API_KEY)
            .build();

    Call call = client.newCall(request);
    call.enqueue(callback);
}

    public ArrayList<Apods> processResults(Response response){
        ArrayList<Apods> apod = new ArrayList<>();
        try{
            String jsonData = response.body().string();
            JSONObject yelpJSON = new JSONObject(jsonData);
            JSONArray apodsJSON = yelpJSON.getJSONArray("apods");
            if (response.isSuccessful()){
                for (int i = 0; i < apodsJSON.length(); i++){
                    JSONObject apodJSON = apodsJSON.getJSONObject(i);
                    String copyright = apodJSON.getString("copyright");
                    String date = apodJSON.optString("date", "date not available");
                    String explanation = apodJSON.getString("explanation");
                    String hdurl = apodJSON.getString("hdurl");
                    String media_type = apodJSON.getString("media_type");
                    String service_version = apodJSON.getString("service_version");
                    String title = apodJSON.getString("title");
                    String url = apodJSON.getString("url");
                    Apods apods = new Apods(copyright, date, explanation, hdurl,
                            media_type, service_version, title, url);
                    apods.add(apods);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return apod;
    }
}

