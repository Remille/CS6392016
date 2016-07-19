package edu.pace.cs6392016.sophia.cs639firebase;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private Button btnSubmit;
    private EditText etId, etName;
    private Firebase rootRef;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        etId = (EditText)rootView.findViewById(R.id.idInput);
        etName = (EditText)rootView.findViewById(R.id.nameInput);
        btnSubmit = (Button)rootView.findViewById(R.id.button);

        Firebase.setAndroidContext(getContext());

        btnSubmit.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootRef = new Firebase("https://cs639firebase-35651.firebaseio.com/");
                String id = etId.getText().toString().trim();
                String name = etName.getText().toString().trim();

                Student st = new Student(id,name);
                rootRef.push().setValue(st);
            }
        });

        return rootView;
    }
}
