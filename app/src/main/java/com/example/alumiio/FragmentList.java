package com.example.alumiio;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentList extends Fragment {

    ListView listView;

    SearchView searchView;

    ArrayAdapter<String> adapter;

    String[] data = {"sou algo",
                     "Sou nada",
                    "Sou uma algo",
    };


    public FragmentList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_fragment_list, container, false);

        listView = (ListView) view.findViewById(R.id.idListview);

        adapter = new ArrayAdapter<String> (Objects.requireNonNull(getActivity()),android.R.layout.simple_list_item_1,data);
        listView.setAdapter(adapter);
        return view;
    }

}
