package com.example.alumiio.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.alumiio.models.Recado;

import java.util.ArrayList;

public class RecadoAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;

    private ArrayList<Recado> recados;
    @Override
    public int getCount() {
        return recados.size();
    }

    @Override
    public Object getItem(int i) {
        return recados.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
