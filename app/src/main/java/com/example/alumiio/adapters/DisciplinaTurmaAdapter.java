package com.example.alumiio.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.alumiio.R;
import com.example.alumiio.models.Aluno;
import com.example.alumiio.models.Disciplina_Turma;

import java.util.ArrayList;

public class DisciplinaTurmaAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;

    private ArrayList<Disciplina_Turma> disciplinaTurmas;

    public DisciplinaTurmaAdapter(Context context, ArrayList<Disciplina_Turma> disciplinaTurmas) {
        this.context = context;
        this.disciplinaTurmas = disciplinaTurmas;
    }

    @Override
    public int getCount() {
        return disciplinaTurmas.size();
    }

    @Override
    public Object getItem(int position) {
        return disciplinaTurmas.get(position);
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
            convertView = inflater.inflate(R.layout.fragment_fragment_list,null);

        }
        ViewHolderList viewHolderList = (ViewHolderList) convertView.getTag();


        if (viewHolderList == null){
            viewHolderList = new ViewHolderList(convertView);
            convertView.setTag(viewHolderList);
        }
        viewHolderList.update(disciplinaTurmas.get(position));
        return convertView;
    }

    public void refresh(ArrayList<Disciplina_Turma> disciplinaTurmas)
    {
        this.disciplinaTurmas = disciplinaTurmas;
        notifyDataSetChanged();
    }
    private class ViewHolderList {// acesso aos componentes visuais

        //Ver isto
        private TextView textView;


        public ViewHolderList(View convertView) {
            textView  = convertView.findViewById(R.id.textViewOnLV);

        }
        public void update(Disciplina_Turma disciplinaTurma)
        {
            textView.setText(disciplinaTurma.getId_professor());
        }


    }
}
