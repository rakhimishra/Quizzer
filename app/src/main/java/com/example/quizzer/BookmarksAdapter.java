package com.example.quizzer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookmarksAdapter extends RecyclerView.Adapter<BookmarksAdapter.Viewholder> {
    private List<QuestionModel> list;

    public BookmarksAdapter(List<QuestionModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from ( parent.getContext () ).inflate ( R.layout.bookmarks_item,parent,false );

        return new Viewholder (view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
    holder.setdata ( list.get ( position ).getQuestion (),list.get ( position ).getCorrectANS () );
    }

    @Override
    public int getItemCount() {
        return list.size ();
    }


    class Viewholder extends RecyclerView.ViewHolder{
        private TextView question,answer;
        public Viewholder(@NonNull View itemView) {
            super ( itemView );
            question=itemView.findViewById ( R.id.Question );
            answer=itemView.findViewById ( R.id.answer );
        }
        private void setdata(String Question,String answer){
            this.question.setText ( Question );
            this.answer.setText ( answer );
        }
    }

}
