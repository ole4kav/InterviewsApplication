package com.example.olga.interviewsapplication.managers;

import java.util.ArrayList;

import retrofit2.Response;

public class TmpPresenterCallRetrofti implements TmpManagerInt.Listener{


    private void callRetrofit() {
        TmpManager tmp = new TmpManager();
        tmp.downloadItem(this);
    }

    @Override
    public void downloadSentencesSuccess(Response<ArrayList<String>> downloadResponse) {

           // String videoKey = downloadResponse.body().get(0);//getVideos().getResults().get(0).getKey();
            //saveDataToSingleton(nowPosition, videoKey);
    }

    @Override
    public void downloadSentencesFailure() {

    }



}
