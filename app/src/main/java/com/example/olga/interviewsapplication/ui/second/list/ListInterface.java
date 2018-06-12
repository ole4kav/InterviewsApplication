package com.example.olga.interviewsapplication.ui.second.list;

import android.content.Context;
import android.support.v7.widget.DividerItemDecoration;

import com.example.olga.interviewsapplication.adapters.SentencesAdapter;

import java.util.ArrayList;

public interface ListInterface {

    interface View {
        void showList(ArrayList<String> arrayList,
                      DividerItemDecoration dividerItemDecoration, SentencesAdapter adapter);
        void showToast(int position, SentencesAdapter adapter);
    }

    interface Presenter {
        void addBtnPressed (Context context);
        void screenCreated (Context context);
    }

    interface Model {}
}
