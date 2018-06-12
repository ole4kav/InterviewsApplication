package com.example.olga.interviewsapplication.ui.second.list;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.olga.interviewsapplication.R;
import com.example.olga.interviewsapplication.adapters.SentencesAdapter;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity implements ListInterface.View {

    Button addNewItemButton;
    RecyclerView recyclerView;

    ListPresenter presenter;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initialization();
        setInit();
        setListeners();
        presenter.screenCreated(context);
    }

    private void initialization() {
        addNewItemButton = findViewById(R.id.btnAddNew);
        recyclerView = findViewById(R.id.recycleList);
    }

    private void setInit() {
        presenter = new ListPresenter(this);
        context = this;
    }

    private void setListeners() {
        addNewItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.addBtnPressed(context);
            }
        });
    }

    @Override
    public void showList(ArrayList<String> arrayList,
                         DividerItemDecoration dividerItemDecoration, SentencesAdapter adapter) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(dividerItemDecoration);
    }


    @Override
    public void showToast(int position, SentencesAdapter adapter) {
        Toast.makeText(this, adapter.getItem(position), Toast.LENGTH_LONG).show();
    }
}
