package com.moringaschool.myspace.network;

import com.moringaschool.myspace.Constants;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.moringaschool.myspace.Constants.API_BASE_URL;

public class NasaClient {
    private static Retrofit retrofit = null;

    public static NasaApi getClient() {

        if (retrofit == null) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
            okHttpClient
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .client(okHttpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(NasaApi.class);
    }
}