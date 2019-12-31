package com.example.alumiio.Views.ui.turmaactivity2;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alumiio.R;

//import com.example.alumiio.Views.R;

public class TurmaActivity2Fragment extends Fragment {

    private TurmaActivity2ViewModel mViewModel;

    public static TurmaActivity2Fragment newInstance() {
        return new TurmaActivity2Fragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //Fixme: deu um erro com o R.layout.turma_activity2_fragment
        return inflater.inflate(R.layout.turma_activity2_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(TurmaActivity2ViewModel.class);
        // TODO: Use the ViewModel
    }

}
