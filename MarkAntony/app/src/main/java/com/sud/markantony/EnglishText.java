package com.sud.markantony;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EnglishText.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EnglishText#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EnglishText extends Fragment implements View.OnClickListener {
    View view;
    ImageView clearText;
    EditText englishText;
    Recycler_View_Adapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_english_text, container, false);
        clearText = (ImageView) view.findViewById(R.id.clearText);
        clearText.setOnClickListener(this);
        englishText = (EditText) view.findViewById(R.id.englishText);
        return view;
    }


    @Override
    public void onClick(View v) {
        englishText.setText("");
        //dapter.insert(0, new Data("admin", "asdasd", R.drawable.main_bg));
    }

    public void setSiblingAdapter(Recycler_View_Adapter adapter)
    {
        this.adapter = adapter;
    }

    public String getEnglishText() {
        return englishText.getText().toString();
    }
}
