package com.example.alumiio;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.alumiio.Views.TurmaActivity;
import com.example.alumiio.adapters.TesteAdapter;
import com.example.alumiio.listeners.TesteListener;
import com.example.alumiio.models.AlumioSingleton;
import com.example.alumiio.models.Teste;

import java.util.ArrayList;
import java.util.Objects;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentListTestes extends Fragment {

    ListView listView;

    SearchView searchView;

    ArrayAdapter<Teste> testeArrayAdapter;

    private ArrayList<Teste> testes;

    private TesteListener testeListener;

    String[] data = {"sou algo",
                     "Sou nada",
                    "Sou uma algo",
    };

    public FragmentListTestes() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        AlumioSingleton.getInstance(getContext()).setTesteListener(testeListener);

        testes = AlumioSingleton.getInstance(getContext()).getTestesBD();

        View view = inflater.inflate(R.layout.fragment_fragment_list_testes, container, false);

        listView = (ListView) view.findViewById(R.id.idListview);


        //Clicar na ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                                Intent intent = new Intent(getContext(), TurmaActivity.class);
                                                startActivity(intent);
                                            }
        });

        testeArrayAdapter = new ArrayAdapter<Teste> (Objects.requireNonNull(getActivity()),android.R.layout.simple_list_item_2, testes);


        //TODO: ATERAR O ID DO FRAGMENTO
        listView.setAdapter(new TesteAdapter(getContext(), testes));
        return view;
    }


}
