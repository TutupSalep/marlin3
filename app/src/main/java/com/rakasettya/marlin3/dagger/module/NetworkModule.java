package com.rakasettya.marlin3.dagger.module;

import android.app.Application;
import android.content.Context;
import com.rakasettya.marlin3.data.api.NetworkService;
import com.rakasettya.marlin3.data.api.Service;
import com.rakasettya.marlin3.data.sqlite.dao.DAOSqlite;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dagger.Module;
import dagger.Provides;
import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;
import javax.inject.Singleton;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {
  String BASE_URL;

  public NetworkModule(String BASE_URL) {
    this.BASE_URL = BASE_URL;
  }

    @Provides
    @Singleton
    Retrofit provideCall(Context context) {
    File cacheDir = context.getCacheDir();
    Cache cache  = new Cache(cacheDir, 10 * 1024 * 1024);;
    HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    OkHttpClient okHttpClient = new OkHttpClient.Builder()
          .addInterceptor(loggingInterceptor)
          .addInterceptor((Chain chain) -> {
            Request original = chain.request();
            // Customize the request
            Request request = original.newBuilder()
                .header("Content-Type", "application/json")
                .header("Accept","application/json")
                .header("Authorization", "BearereyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hcGkubWFybGluYm9va2luZy5uZXRcL2F1dGhcL2xvZ2luIiwiaWF0IjoxNTM0MjM4NTk1LCJleHAiOjE1MzY3NzY1OTUsIm5iZiI6MTUzNDIzODU5NSwianRpIjoieTROYVdwWUhCUGtESTVqUCIsInN1YiI6NDI0NiwicHJ2IjoiODdlMGFmMWVmOWZkMTU4MTJmZGVjOTcxNTNhMTRlMGIwNDc1NDZhYSJ9.WVvdGmzzbeT4OATqorFF0RVILRWC5D8lVdhFcyxLTOk")
                .build();
            okhttp3.Response response = chain.proceed(request);
            response.cacheResponse();
            // Customize or return the response
            return response;
          })
          .cache(cache)
          .build();
      Gson gson = new GsonBuilder()
        .setLenient()
        .create();
      return new Retrofit.Builder()
          .baseUrl(BASE_URL)
          .client(okHttpClient)
          .addConverterFactory(GsonConverterFactory.create(gson))
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .build();
    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    public NetworkService providesNetworkService(
        Retrofit retrofit) {
      return retrofit.create(NetworkService.class);
    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    public Service providesService(
        NetworkService networkService) {
      return new Service(networkService);
    }

}
