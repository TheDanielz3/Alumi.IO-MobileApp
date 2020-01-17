package com.example.alumiio.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.alumiio.R;
import com.example.alumiio.models.Teste;

import java.util.ArrayList;

public class TesteAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Teste> testes;


    public TesteAdapter(Context context, ArrayList<Teste> testes) {
        this.context = context;
        this.testes = testes;
    }

    @Override
    public int getCount() {
        return testes.size();
    }

    @Override
    public Object getItem(int position) {
        return testes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(inflater == null)
        {
            inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.fragment_fragment_list_alunos,null);

        }
        ViewHolderList viewHolderList = (ViewHolderList) convertView.getTag();


        if (viewHolderList == null){
            viewHolderList = new ViewHolderList(convertView);
            convertView.setTag(viewHolderList);
        }
        viewHolderList.update(testes.get(position));
        return convertView;
    }
    public void refresh()
    {

    }

    private class ViewHolderList{ //Dar acesso aos Componetes Visuais

        private TextView textView;


        public ViewHolderList(View convertView)
        {
            textView = convertView.findViewById(R.id.textViewOnLV_teste_descicao);
        }
        public void update(Teste teste)
        {
            textView.setText(teste.getDescricao());
        }
    }
}
