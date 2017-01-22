package com.example.singgih.chatappsexample.Services;

import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.lang.reflect.Modifier;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by singgih on 1/17/2017.
 */

public class Service {
    public static final String BASE_URL = "http://188.166.211.222:9090/";

    public static Retrofit getRetrofit() {
        OkHttpClient okClient = new OkHttpClient.Builder()
                .addInterceptor(
                        new Interceptor() {
                            @Override
                            public Response intercept(Chain chain) throws IOException {
                                Request original = chain.request();
                                Request request = original.newBuilder()
                                        .method(original.method(), original.body())
                                        .build();
                                return chain.proceed(request);
                            }
                        }
                ).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okClient)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder()
                        .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
                        .serializeNulls()
                        .create()))
                .build();
        return retrofit;
    }
}
