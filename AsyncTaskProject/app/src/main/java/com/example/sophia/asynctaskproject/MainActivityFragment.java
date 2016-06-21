package com.example.sophia.asynctaskproject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {


    public MainActivityFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ImagePull iop = new ImagePull();
        iop.execute();
        Bitmap result = null;
        try {
            result = iop.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        final ImageView img = (ImageView) rootView.findViewById(R.id.imageView);
        img.setImageBitmap(result);
        return rootView;
    }
}
