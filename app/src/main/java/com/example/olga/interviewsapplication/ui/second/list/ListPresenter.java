package com.example.olga.interviewsapplication.ui.second.list;

import android.content.Context;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.olga.interviewsapplication.Sentences;
import com.example.olga.interviewsapplication.adapters.SentencesAdapter;

import java.util.ArrayList;

public class ListPresenter implements ListInterface.Presenter, SentencesAdapter.ItemClickListener {

    private ListInterface.View view;
    ArrayList<String> arrayList = new ArrayList<>();
    Sentences sentencesList = new Sentences();
    SentencesAdapter adapter;

    public ListPresenter(ListActivity mView) {
        view = mView;
    }

    @Override
    public void addBtnPressed(Context context) {
        arrayList.add("test");
        buildList(context, arrayList);
    }

    @Override
    public void screenCreated(Context context) {
        arrayList = sentencesList.buildList();
        buildList(context, arrayList);
    }

    private void buildList(Context context, ArrayList<String> nArrayList) {
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(context,
                LinearLayoutManager.VERTICAL);
        adapter = new SentencesAdapter(context, nArrayList);
        adapter.setClickListener(this);
        view.showList(nArrayList, dividerItemDecoration, adapter);
    }

    @Override
    public void onItemClick(View mView, int position) {
        view.showToast(position, adapter);
    }
}
