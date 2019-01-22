package com.sud.markantony;

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
 * {@link quickQuotesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link quickQuotesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class quickQuotesFragment extends Fragment {
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_quick_quotes, container, false);

        ListView listView = (ListView) view.findViewById(R.id.listView);

        String[] values = new String[] { "quote 1", "quote2", "quote3"};
        ArrayList<String> list = new ArrayList<String>();
        try {
            FileInputStream fin = getActivity().openFileInput("quotes_dump");
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
