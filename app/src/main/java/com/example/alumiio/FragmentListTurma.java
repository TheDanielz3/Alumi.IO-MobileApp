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
import com.example.alumiio.adapters.TurmaAdapter;
import com.example.alumiio.listeners.TurmaListener;
import com.example.alumiio.models.AlumioSingleton;
import com.example.alumiio.models.Turma;

import java.util.ArrayList;
import java.util.Objects;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentListTurma extends Fragment {

    ListView listView;

    SearchView searchView;

    ArrayAdapter<Turma> turmaArrayAdapter;

    private ArrayList<Turma> turmas;

    private TurmaListener turmaListener;

    String[] data = {"sou algo",
                     "Sou nada",
                    "Sou uma algo",
    };

    public FragmentListTurma() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        AlumioSingleton.getInstance(getContext()).setTurmaListener(turmaListener);

        turmas = AlumioSingleton.getInstance(getContext()).getTurmasBD();

        View view = inflater.inflate(R.layout.fragment_fragment_list_turmas, container, false);

        listView = (ListView) view.findViewById(R.id.idListview);


        //Clicar na ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                Turma valor_Listview = (Turma) listView.getItemAtPosition(position);
                                                Intent intent = new Intent(getContext(), TurmaActivity.class);
                                                intent.putExtra("VALOR_LETRA",valor_Listview.getLetra());
                                                startActivity(intent);

                                             //   System.out.println("-->" + valor_Listview.getLetra());
                                            }
        });

        turmaArrayAdapter = new ArrayAdapter<Turma> (Objects.requireNonNull(getActivity()),android.R.layout.simple_list_item_2, turmas);


        //TODO: ATERAR O ID DO FRAGMENTO
        listView.setAdapter(new TurmaAdapter(getContext(), turmas));
        return view;
    }


}
