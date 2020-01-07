package com.example.quizzer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

public class bookmarkActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_bookmark );
        Toolbar toolbar =findViewById ( R.id.toolbar );
        setSupportActionBar ( toolbar );
        getSupportActionBar ().setTitle ( "Bookmarks" );
        getSupportActionBar ().setDisplayHomeAsUpEnabled ( true );
        recyclerView=findViewById (R.id.rv_bookmarks );
        LinearLayoutManager layoutManager=new LinearLayoutManager ( this );
        layoutManager.setOrientation ( RecyclerView.VERTICAL );
        recyclerView.setLayoutManager ( layoutManager );


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId ()==android.R.id.home){
            finish ();
        }
        return super.onOptionsItemSelected ( item );
    }
}
