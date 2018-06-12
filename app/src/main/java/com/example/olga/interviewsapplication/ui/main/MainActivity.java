package com.example.olga.interviewsapplication.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.olga.interviewsapplication.Consts;
import com.example.olga.interviewsapplication.R;

public class MainActivity extends AppCompatActivity implements MainInterface.View {

    Button cameraButton;
    Button libraryButton;
    Button locationButton;
    Button internetButton;
    Button popupButton;
    Button listButton;
    MainPresenter presenter;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialization();
        setInit();
        setListeners();
    }

    private void setInit() {
        presenter = new MainPresenter(this);
        context = this;
    }

    private void initialization() {
        cameraButton = findViewById(R.id.btnCamera);
        libraryButton = findViewById(R.id.btnLibrary);
        locationButton = findViewById(R.id.btnLocation);
        internetButton = findViewById(R.id.btnInternet);
        popupButton = findViewById(R.id.btnPopUp);
        listButton = findViewById(R.id.btnList);
    }

    private void setListeners() {
        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.cameraBtnPressed(context);
            }
        });
        libraryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.libraryBtnPressed(context);
            }
        });
        locationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.locationBtnPressed();
            }
        });
        internetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.internetBtnPressed();
            }
        });
        popupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.popupBtnPressed();
            }
        });
        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.listBtnPressed(context);
            }
        });
    }

    @Override
    public void askPermission(String permission) {
        ActivityCompat.requestPermissions(this, new String[] { permission }, 1);
    }


    @Override
    public void startCameraActivityForResult(Intent intent) {
        startActivityForResult(intent, Consts.Main.REQUEST_CAMERA);
    }

    @Override
    public void startLibraryActivityForResult(Intent intent) {
        startActivityForResult(Intent.createChooser(intent, getString(R.string.library_title)), Consts.Main.SELECT_FILE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        presenter.onCameraActivityResult(resultCode, resultCode, data);
    }

    @Override
    public void startListActivity(Intent intent) {
        startActivity(intent);
    }

}
