package com.example.quizzer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import static com.example.quizzer.R.layout.activity_categories_;

public class Categories_Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    String imageurl,title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( activity_categories_);
        Toolbar toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("categories");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView=findViewById(R.id.rv);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        List<category_model> list;
        list = new ArrayList<>();
        list.add(new category_model(imageurl="",title="category1"));
        list.add(new category_model(imageurl="",title="category2"));
        list.add(new category_model(imageurl="",title="category3"));
        list.add(new category_model(imageurl="",title="category4"));
        list.add(new category_model(imageurl="",title="category5"));
        list.add(new category_model(imageurl="",title="category6"));
        list.add(new category_model(imageurl="",title="category7"));



        CategoryAdapter adapter=new CategoryAdapter(list);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
