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
import com.example.alumiio.adapters.RecadoAdapter;
import com.example.alumiio.listeners.AlunoListener;
import com.example.alumiio.listeners.RecadoListener;
import com.example.alumiio.models.AlumioSingleton;
import com.example.alumiio.models.Recado;

import java.util.ArrayList;
import java.util.Objects;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentListRecados extends Fragment {

    ListView listView;

    SearchView searchView;

    ArrayAdapter<Recado> recadoArrayAdapter;

    private ArrayList<Recado> recados;

    private AlunoListener alunoListener;

    private RecadoListener recadoListener;

    String[] data = {"sou algo",
                     "Sou nada",
                    "Sou uma algo",
    };

    public FragmentListRecados() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        AlumioSingleton.getInstance(getContext()).setRecadoListener(recadoListener);

        recados = AlumioSingleton.getInstance(getContext()).getRecadosBD();

        View view = inflater.inflate(R.layout.fragment_fragment_list_recados, container, false);

        listView = view.findViewById(R.id.idListview);


        //Clicar na ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                                Intent intent = new Intent(getContext(), TurmaActivity.class);
                                                startActivity(intent);
                                            }
        });

        recadoArrayAdapter = new ArrayAdapter<Recado> (Objects.requireNonNull(getActivity()),android.R.layout.simple_list_item_2, recados);


        //TODO: ATERAR O ID DO FRAGMENTO
        listView.setAdapter(new RecadoAdapter(getContext(), recados));
        return view;
    }


}
