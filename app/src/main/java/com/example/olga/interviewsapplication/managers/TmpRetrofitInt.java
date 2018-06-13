package com.example.olga.interviewsapplication.managers;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TmpRetrofitInt {

    String baseUrl = "https://api.themoviedb.org/3/movie/";

    /*
    @GET("popular?api_key=87c877dbed3d5205550bcd07ad899478&language=en-US&page=1")
    Call<PopularMoviePojo> getPopularResults();

    @GET("{id}?api_key=dc310ae1f74743b9985a714c9e201984&language=en-US&append_to_response=videos")
    Call<PopularMovieDetailPojo> getItemResults(@Path("id") Integer id);
    */

    @GET("{lng}.json")
    Call<ArrayList<String>>getSent(@Path("language") String sentenceLanguage);


    //factory
    class Factory {
        private static TmpRetrofitInt service;

        public static TmpRetrofitInt getInstance() {
            if (service == null) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                service = retrofit.create(TmpRetrofitInt.class);
                return service;
            } else {
                return service;
            }
        }
    }

}
