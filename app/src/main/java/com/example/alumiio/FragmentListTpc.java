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
import com.example.alumiio.Views.ViewDetailsTpcActivity;
import com.example.alumiio.adapters.TpcAdapter;
import com.example.alumiio.listeners.TpcListener;
import com.example.alumiio.models.AlumioSingleton;
import com.example.alumiio.models.Tpc;

import java.util.ArrayList;
import java.util.Objects;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentListTpc extends Fragment {

    ListView listView;

    SearchView searchView;

    ArrayAdapter<Tpc> tpcArrayAdapter;

    private ArrayList<Tpc> tpcs;

    private TpcListener tpcListener;

    String[] data = {"sou algo",
                     "Sou nada",
                    "Sou uma algo",
    };

    public FragmentListTpc() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        AlumioSingleton.getInstance(getContext()).setTpcListener(tpcListener);

        tpcs = AlumioSingleton.getInstance(getContext()).getTpcsBD();

        View view = inflater.inflate(R.layout.fragment_fragment_list_tpcs, container, false);

        listView = (ListView) view.findViewById(R.id.idListview);


        //Clicar na ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                                Tpc tpc;
                                                 tpc = (Tpc) parent.getAdapter().getItem(position);
                                                Intent intent = new Intent(getContext(), ViewDetailsTpcActivity.class);
                                                intent.putExtra("ID_DO_TPC",tpc.getId());
                                                startActivity(intent);
                                            }
        });

        tpcArrayAdapter = new ArrayAdapter<Tpc> (Objects.requireNonNull(getActivity()),android.R.layout.simple_list_item_2, tpcs);

        //TODO: ATERAR O ID DO FRAGMENTO
        listView.setAdapter(new TpcAdapter(getContext(), tpcs));
        return view;
    }


}
