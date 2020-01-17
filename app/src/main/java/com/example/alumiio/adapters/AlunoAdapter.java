package com.example.alumiio.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.alumiio.R;
import com.example.alumiio.models.Aluno;

import java.util.ArrayList;

public class AlunoAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;

    private ArrayList<Aluno> alunos;

    public AlunoAdapter(Context context, ArrayList<Aluno> alunos) {
        this.context = context;
        this.alunos = alunos;
    }

    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Object getItem(int position) {
        return alunos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
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
        viewHolderList.update(alunos.get(position));
        return convertView;
    }

    public void refresh(ArrayList<Aluno> alunos)
    {

        this.alunos = alunos;
        notifyDataSetChanged();

    }
    private class ViewHolderList {// acesso aos componentes visuais

        private TextView textView;


        public ViewHolderList(View convertView) {
            textView  = convertView.findViewById(R.id.textViewOnLV_aluno_nome);
        }
        public void update(Aluno aluno)
        {
            textView.setText(aluno.getNome());
        }


    }
}
