package com.amitraj.themoviedbapp;

import android.app.Application;

import com.amitraj.themoviedbapp.network.IRetrofit;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by AmitRaj on 12-Sep-17.
 */

public class BaseApplication extends Application {

  private static volatile IRetrofit IRETROFIT = null;

  @Override
  public void onCreate() {
    super.onCreate();

    // configuring the font for calligraphy
    try {
      CalligraphyConfig.initDefault(
          new CalligraphyConfig.Builder().setDefaultFontPath("fonts/font.ttf")
              .setFontAttrId(R.attr.fontPath)
              .build());
    } catch (Exception e) {
      e.printStackTrace();
    }

  }



  public static synchronized IRetrofit getRetrofitAPI() {

    GsonBuilder gsonBuilder = new GsonBuilder();
//    gsonBuilder.setExclusionStrategies(new ExclusionStrategy() {
//      @Override
//      public boolean shouldSkipField(FieldAttributes f) {
//        return f.getDeclaringClass().equals(RealmObject.class);
//      }
//
//      @Override
//      public boolean shouldSkipClass(Class<?> clazz) {
//        return false;
//      }
//    });
//    gsonBuilder.registerTypeAdapter(new TypeToken<RealmList<RealmString>>() {
//    }.getType(), RealmStringListTypeAdapter.INSTANCE);

    Gson gson = gsonBuilder.create();

    OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();

    if (BuildConfig.DEBUG) {
      HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
      loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
      httpClientBuilder.addInterceptor(loggingInterceptor);
    }
//    httpClientBuilder.addInterceptor(new HeaderInterceptor(getHeader()));

    IRETROFIT = new Retrofit.Builder().baseUrl(IRetrofit.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .callFactory(httpClientBuilder.build())
        .build()
        .create(IRetrofit.class);

    return IRETROFIT;
  }

//  private static RequestHeader getHeader(){
//    RequestHeader header = null;
//      header = new RequestHeader();
//      header.setHeaderName("Authtoken");
//      header.setHeaderValue("E60M4Gsc-h4Q8plqQ26PgOmVUKIwR6kOAHiAFl7cGzI");
//    return header;
//  }
}
