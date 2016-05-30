package com.sezzh.smood.io.api;

import com.sezzh.smood.io.models.ColorModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by sezzh on 29/05/16.
 */
public interface SmoodClient {

    @GET("/colors/")
    Call<List<ColorModel>> getResourceColors();

    @POST("/colors/")
    Call<ColorModel> createResourceColor(
            @Body ColorModel color
    );

}
