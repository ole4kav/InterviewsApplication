package com.example.olga.interviewsapplication.managers;

import java.util.ArrayList;

import retrofit2.Response;

public interface TmpManagerInt {

     interface Listener{

         void downloadSentencesSuccess(Response<ArrayList<String>> downloadResponse);
         void downloadSentencesFailure();
    }
    void downloadItem (Listener listener);
}
