package com.example.alumiio.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.alumiio.R;
import com.example.alumiio.models.Tpc;

import java.util.ArrayList;

public class TpcAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Tpc> tpcs;

    public TpcAdapter(Context context, ArrayList<Tpc> tpcs) {
        this.context = context;
        this.tpcs = tpcs;
    }

    @Override
    public int getCount() {
        return tpcs.size();
    }

    @Override
    public Object getItem(int position) {
        return tpcs.get(position);
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
        viewHolderList.update(tpcs.get(position));
        return convertView;


    }
    public void refresh()
    {

    }
    private class ViewHolderList{ //Dar acesso aos Componetes Visuais

    private TextView textView;

        public ViewHolderList(View convertView)
        {
            textView = convertView.findViewById(R.id.textViewOnLV_tpc_descricao);
        }
        public void update(Tpc tpc)
        {
            textView.setText(tpc.getDescricao());
        }
    }
}
