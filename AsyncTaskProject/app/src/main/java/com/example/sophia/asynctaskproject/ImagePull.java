package com.example.sophia.asynctaskproject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImagePull extends AsyncTask<Void,Void,Bitmap> {

    @Override
    protected Bitmap doInBackground(Void... params) {
        try {
            URL url = new URL("https://raw.githubusercontent.com/Remille/CS6392016/master/AsyncTaskProject/South_Manhattan_skyline_-_October_2013.JPG");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            InputStream in = con.getInputStream();
            Bitmap bmps = BitmapFactory.decodeStream(in);
            return bmps;
        }

        catch (Exception e) {
            Log.e("Image","Failed to load image",e);
            Log.e("error",e.getMessage());
        }
        return null;
    }
}
