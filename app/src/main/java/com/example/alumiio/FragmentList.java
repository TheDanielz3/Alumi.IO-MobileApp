package com.example.alumiio;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.alumiio.Views.TurmaActivity;
import com.example.alumiio.adapters.AlunoAdapter;
import com.example.alumiio.adapters.TurmaAdapter;
import com.example.alumiio.listeners.AlunoListener;
import com.example.alumiio.models.AlumioSingleton;
import com.example.alumiio.models.Aluno;

import java.util.ArrayList;
import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentList extends Fragment {

    ListView listView;

    SearchView searchView;

    ArrayAdapter<String> adapter;

    private ArrayList<Aluno> alunos;

    private AlunoListener alunoListener;

    private AlunoAdapter alunoAdapter;

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

        AlumioSingleton.getInstance(getContext()).setAlunoListener(alunoListener);

        alunos = AlumioSingleton.getInstance(getContext()).getAlunosBD();


        //books = SingletonBookManager.getInstance(getApplicationContext()).getBooksDB();
        //bookListAdapter = new BookListAdapter(this, books);
        //listViewBookList.setAdapter(bookListAdapter);

        View view = inflater.inflate(R.layout.fragment_fragment_list, container, false);

            listView = (ListView) view.findViewById(R.id.idListview);


        //Clicar na ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                                Intent intent = new Intent(getContext(), TurmaActivity.class);
                                                startActivity(intent);
                                            }
                                        });

        adapter = new ArrayAdapter<String> (Objects.requireNonNull(getActivity()),android.R.layout.simple_list_item_1,data);

        listView.setAdapter(adapter);
        return view;
    }


}
