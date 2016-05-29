package com.sezzh.smood.io.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sezzh on 29/05/16.
 */
public class ServiceGenerator {
    private static OkHttpClient.Builder httpClient =
            new OkHttpClient.Builder();
    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(ApiConstants.API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    //RestAPi adapter.
    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(httpClient.build()).build();
        return retrofit.create(serviceClass);
    }


}
