package com.example.helloworld.client;

import com.example.helloworld.api.Demo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by lordukthar on 2017-08-15.
 */
public interface DemoResourceService {
        @Headers({ "Accept: application/json" })


        @GET("/demo/futures")
        Call<Demo> getDemoFuture();


}
