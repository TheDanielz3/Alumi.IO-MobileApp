package com.example.alumiio.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.alumiio.R;
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
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        if(inflater == null)
        {
            inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.fragment_fragment_list,null);

        }
        ViewHolderList viewHolderList = (ViewHolderList) convertView.getTag();


        if (viewHolderList == null){
            viewHolderList = new ViewHolderList(convertView);
            convertView.setTag(viewHolderList);
        }
        viewHolderList.update(recados.get(position));
        return convertView;
    }
    public void refresh(ArrayList<Recado> recados)
    {
        this.recados = recados;
        notifyDataSetChanged();
    }
    private class ViewHolderList{ //Dar acesso aos Componetes Visuais
    


        public ViewHolderList(View convertView)
        {

        }
        public void update(Recado recado)
        {

        }
    }

}
