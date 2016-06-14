package com.example.sophia.imageviewer;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/**
 * A placeholder fragment containing a simple view.
 */
public class DogImageViewerFragment extends Fragment {



    public DogImageViewerFragment() {
    }

    int[] images;
    int state = 0;

    {
        images = new int[]{R.drawable.big_and_little_dog,
                R.drawable.bow_bow,
                R.drawable.cavalier_king_charles_spaniel_trio,
                R.drawable.golden_retriever_eating_pigs_foot,
                R.drawable.terrier_mixed_breed_dog};
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dog_image_viewer, container, false);
        final ImageView img = (ImageView) rootView.findViewById(R.id.imageView);
        Button button = (Button)rootView.findViewById(R.id.button);
        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (state > 4) {
                    state = 0;
                }
                img.setImageResource(images[state]);
                final int i = state++;
            }
        });
        return rootView;
    }
}
