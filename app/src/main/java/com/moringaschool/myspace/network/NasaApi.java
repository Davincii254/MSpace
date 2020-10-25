package com.moringaschool.myspace.network;


import com.moringaschool.myspace.models.Apods;
import com.moringaschool.myspace.models.Asteroids;
import com.moringaschool.myspace.models.EarthImages;
import com.moringaschool.myspace.models.Images;
import com.moringaschool.myspace.models.MarsRoverPhotosEarthDays;
import com.moringaschool.myspace.models.TechTransfer;
import com.moringaschool.myspace.models.Techport;

import java.util.List;
import retrofit2.Call;
//import okhttp3.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NasaApi {
    @GET("apod/")
     Call <List<Apods>> getApods(
    @Query("date") String date,
    @Query("hd") String hd,
    @Query("api_key") String apiKey
    );

    @GET("neo/rest/")
    Call<List<Asteroids>> getAsteroids(
            @Query("start_date") String start_date,
            @Query("end_date") String end_date,
            @Query("api_key") String apiKey
    );

    @GET("planetary/earth/imagery/")
    Call<List<EarthImages>> getEarthImage(
            @Query("lon") String lon,
            @Query("lat") String lat,
            @Query("dim") String dim,
            @Query("date") String date,
            @Query("cloud_score") String cloud_score,
            @Query("api_key") String apiKey
    );

    @GET(" https://images-api.nasa.gov")
    Call<List<Images>> getImage(
            @Query("api_key") String apiKey
    );

    @GET("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?earth_date&api_key=8RVaXYWs7HPc5GqaGjAhbPrTREKfzezB4YslyNTp")
    Call<List<MarsRoverPhotosEarthDays>> getMarsRoverPhotosEarthDays(
            @Query("mars") String earth_date,
            @Query("camera") String camera,
            @Query("page") String page,
            @Query("api_key") String apiKey
    );

    @GET("https://api.nasa.gov/techport/api/projects/{id_parameter}?api_key=8RVaXYWs7HPc5GqaGjAhbPrTREKfzezB4YslyNTp")
    Call<List<Techport>> getTechport_(
            @Query("id_parameter") String id_parameter,
            @Query("api_key") String apiKey
    );

    @GET("https://api.nasa.gov/techtransfer/patent/?engine&api_key=8RVaXYWs7HPc5GqaGjAhbPrTREKfzezB4YslyNTp")
    Call<List<TechTransfer>> getTechTransfer_(
            @Query("patent") String patent,
            @Query("patent_issued") String patent_issued,
            @Query("software") String software,
            @Query("Spinoff") String Spinoff,
            @Query("api_key") String apiKey
    );

}
