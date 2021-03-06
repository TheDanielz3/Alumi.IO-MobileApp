package com.example.alumiio.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.alumiio.R;
import com.example.alumiio.models.Turma;

import java.util.ArrayList;

public class TurmaAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Turma> turmas;

    public TurmaAdapter(Context context, ArrayList<Turma> turmas) {
        this.context = context;
        this.turmas = turmas;
    }

    @Override
    public int getCount() {
        return turmas.size();
    }

    @Override
    public Object getItem(int position) {
        return turmas.get(position);
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
            convertView = inflater.inflate(R.layout.fragment_fragment_list_turmas,null);

        }
        ViewHolderList viewHolderList = (ViewHolderList) convertView.getTag();


        if (viewHolderList == null){
            viewHolderList = new ViewHolderList(convertView);
            convertView.setTag(viewHolderList);
        }
        viewHolderList.update(turmas.get(position));
        return convertView;
    }
    private class ViewHolderList{ //Dar acesso aos Componetes Visuais

    private TextView textView;

        public ViewHolderList(View convertView)
        {
            textView = convertView.findViewById(R.id.textViewOnLV_turmas_Letra);
        }
        public void update(Turma turma)
        {
            textView.setText(turma.getLetra());
        }
    }
}
