package com.example.quizzer;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class gridadapter extends BaseAdapter {
    private int sets;

    public gridadapter(int sets) {
        this.sets = sets;
    }

    @Override
    public int getCount() {
        return sets;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        View view;
        if (convertView==null){
            view= LayoutInflater.from( parent.getContext() ).inflate( R.layout.set_item,parent,false );
        }else {
            view=convertView;
        }
        view.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(new Intent(v.getContext(), QuestionActivity.class));

            }
        });

        ((TextView)view.findViewById( R.id.textview )).setText(String.valueOf( position+1));
        return view;
    }
}
