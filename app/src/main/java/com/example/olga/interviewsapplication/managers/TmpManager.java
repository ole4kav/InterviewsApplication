package com.example.olga.interviewsapplication.managers;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TmpManager implements TmpManagerInt {
    /*
    override fun downloadSentences(sentenceLanguage: String,
                                   listener: DownloadSentencesManagerInterface.DownloadListener) {
        val call = RetrofitInterface.Factory.instance?.getSent(sentenceLanguage)
        call?.enqueue(object : Callback<ArrayList<String>> {
            override fun onResponse(call: Call<ArrayList<String>>, response: Response<ArrayList<String>>) {
                listener.downloadSentencesSuccess(response, sentenceLanguage)
            }
            override fun onFailure(call: Call<ArrayList<String>>, t: Throwable) {
                Log.d(TAG, t.message)
                listener.downloadSentencesFailure()
            }
        })
    }
     */
    //listener: DownloadSentencesManagerInterface.DownloadListener
    @Override
    public void downloadItem(final Listener listener) {
        TmpRetrofitInt service = TmpRetrofitInt.Factory.getInstance();
        Call<ArrayList<String>> call = service.getSent("eng");

        call.enqueue(new Callback<ArrayList<String>>() {
            @Override
            public void onResponse(Call<ArrayList<String>> call, Response<ArrayList<String>> response) {
                listener.downloadSentencesSuccess(response);
            }
            @Override
            public void onFailure(Call<ArrayList<String>> call, Throwable t) {
                listener.downloadSentencesFailure();
            }
        });
    }
}
