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
        buildSentList(context, arrayList);
    }

    @Override
    public void screenCreated(Context context) {
        arrayList = sentencesList.buildList();
        buildSentList(context, arrayList);
    }

    private void buildSentList(Context context, ArrayList<String> arrayList) {
        ////ArrayList<String> arrayList = buildTmpSentList();
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(context,
                LinearLayoutManager.VERTICAL);
        adapter = new SentencesAdapter(context, arrayList);
        adapter.setClickListener(this);
        view.showList(arrayList, dividerItemDecoration, adapter);
    }

/*
    private ArrayList<String> buildTmpSentList() {
        ArrayList tmpListSentList = new ArrayList();
        tmpListSentList.add(new TmpSentence("Example 1"));
        tmpListSentList.add(new TmpSentence("Example 2"));
        tmpListSentList.add(new TmpSentence("Example 3"));
        return tmpListSentList;
    }
     */


    @Override
    public void onItemClick(View mView, int position) {
        view.showToast(position, adapter);
    }
}
