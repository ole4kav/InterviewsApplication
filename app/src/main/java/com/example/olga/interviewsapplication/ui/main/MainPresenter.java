package com.example.olga.interviewsapplication.ui.main;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;

import com.example.olga.interviewsapplication.Consts;
import com.example.olga.interviewsapplication.R;
import com.example.olga.interviewsapplication.ui.second.list.ListActivity;

import static android.app.Activity.RESULT_OK;

public class MainPresenter implements MainInterface.Presenter {

    private MainInterface.View view;

    public MainPresenter(MainActivity mView) {
        view = mView;
    }


    @Override
    public void cameraBtnPressed(Context context) {
        openCamera(context);
    }
    @Override
    public void libraryBtnPressed(Context context) {
        openImageGallery(context);
    }
    @Override
    public void locationBtnPressed() {

    }
    @Override
    public void internetBtnPressed() {

    }
    @Override
    public void popupBtnPressed() {

    }
    @Override
    public void listBtnPressed(Context context) {
        Intent intent = new Intent(context, ListActivity.class);
        view.startListActivity(intent);
    }

    private void openCamera(Context context) {
        if (ifPermissionDenied(context, Manifest.permission.CAMERA)) {
            view.askPermission(Manifest.permission.CAMERA); // add answer listener to open camera after accepted permission
        } else {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            view.startCameraActivityForResult(intent);
        }
    }

    private void openImageGallery(Context context) {
        if (ifPermissionDenied(context, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            view.askPermission(Manifest.permission.READ_EXTERNAL_STORAGE); // add answer listener to open gallery after accepted permission
        } else {
            Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType(context.getString(R.string.gallery_type));
            view.startLibraryActivityForResult(intent);
        }
    }

    private boolean ifPermissionDenied(Context context, String permission ) {
        return PackageManager.PERMISSION_DENIED == ActivityCompat.checkSelfPermission(context, permission);
    }

    @Override
    public void onCameraActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == Consts.Main.REQUEST_CAMERA) {
                /*
                Bitmap thumbnail = UIhelper.CameraCode(data);
                petImageView.setBackgroundResource(0);
                petImageView.setImageBitmap(thumbnail);
                petImageView.setAlpha(1.0f);
                image = thumbnail;
                */
            }
            if (requestCode == Consts.Main.SELECT_FILE) {
                /*
                Bitmap bm = UIhelper.SelectPhoto(data, this);
                petImageView.setBackgroundResource(0);
                petImageView.setImageBitmap(bm);
                petImageView.setAlpha(1.0f);
                image = bm;
                 */
            }
        }
    }

    /*
    public static Bitmap CameraCode(Intent data){
        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
        File destination = new File(Environment.getExternalStorageDirectory(), System.currentTimeMillis() + ".jpg");
        FileOutputStream fo;
        try {
            destination.createNewFile();
            fo = new FileOutputStream(destination);
            fo.write(bytes.toByteArray());
            fo.close();
        }
        catch (FileNotFoundException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}
        return thumbnail;
    }

    public static Bitmap SelectPhoto(Intent data, Context context){
        Uri selectedImageUri = data.getData();
        String[] projection = {MediaStore.MediaColumns.DATA};
        CursorLoader cursorLoader = new CursorLoader(context, selectedImageUri, projection, null, null, null);
        Cursor cursor = cursorLoader.loadInBackground();
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
        cursor.moveToFirst();
        String selectedImagePath = cursor.getString(column_index);
        Bitmap bm;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(selectedImagePath, options);
        final int REQUIRED_SIZE = 200;
        int scale = 1;
        while (options.outWidth / scale / 2 >= REQUIRED_SIZE && options.outHeight / scale / 2 >= REQUIRED_SIZE) {scale *= 2;}
        options.inSampleSize = scale;
        options.inJustDecodeBounds = false;
        bm = BitmapFactory.decodeFile(selectedImagePath, options);
        return bm;
    }
     */

}
