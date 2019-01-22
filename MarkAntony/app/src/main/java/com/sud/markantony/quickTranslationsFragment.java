package com.sud.markantony;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link quickTranslationsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link quickTranslationsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class quickTranslationsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_quick_translations, container, false);
        ListView listView = (ListView) view.findViewById(R.id.listView);

        String[] values = null;
        ArrayList<String> list = new ArrayList<String>();
        try {
            FileInputStream fin = getActivity().openFileInput("translations_dump");
            ObjectInputStream ois = new ObjectInputStream(fin);
            list = (ArrayList<String>) ois.readObject();
            Log.d("pup", list.get(0));

        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),R.layout.simple_list_view,list);
        listView.setAdapter(adapter);
        return view;
    }

}
