package com.example.olga.interviewsapplication.ui.main;

import android.content.Context;
import android.content.Intent;

public interface MainInterface {

    interface View {
        void askPermission(String permission);
        void startCameraActivityForResult(Intent intent);
        void startLibraryActivityForResult(Intent intent);
        void startListActivity(Intent intent);

    }

    interface Presenter {
        void cameraBtnPressed(Context context);
        void libraryBtnPressed(Context context);
        void locationBtnPressed();
        void internetBtnPressed();
        void popupBtnPressed();
        void listBtnPressed(Context context);


        void onCameraActivityResult(int requestCode, int resultCode, Intent data);
    }

    interface Model {

    }
}
