package com.example.alumiio.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.alumiio.R;
import com.example.alumiio.models.Recado;

import java.util.ArrayList;

public class RecadoAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Recado> recados;

    public RecadoAdapter(Context context, ArrayList<Recado> recados) {
        this.context = context;
        this.recados = recados;
    }

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
            convertView = inflater.inflate(R.layout.fragment_fragment_list_recados,null);

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

        private TextView textView;


        public ViewHolderList(View convertView)
        {
            textView = convertView.findViewById(R.id.textViewOnLV_recados_topico);
        }
        public void update(Recado recado)
        {
            textView.setText(recado.getTopico());
        }
    }

}
