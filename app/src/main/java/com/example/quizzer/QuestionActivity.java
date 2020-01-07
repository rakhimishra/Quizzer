package com.example.quizzer;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class QuestionActivity extends AppCompatActivity {
    private TextView Question,noindicator;
    private LinearLayout optionscontainer;
    private FloatingActionButton bookmarkbtn;
    private Button sharebtn,nextbtn;
    private int count=0;
    private List<QuestionModel> list;
    private int position=0;
    private int score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_question );
        androidx.appcompat.widget.Toolbar toolbar=findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );
        Question = findViewById( R.id.Question );
        noindicator = findViewById( R.id.no_indicator );
        optionscontainer = findViewById( R.id.options_container );
        bookmarkbtn = findViewById( R.id.bookmark_btn );
        sharebtn = findViewById( R.id.share_btn );
        nextbtn = findViewById( R.id.next_btn );
        list =new ArrayList<>(  );
        list.add( new QuestionModel( "What is the capital of India ? ","Delhi","Goa","patna","lucknow","Delhi" ) );
        list.add( new QuestionModel( "What is the national animal of India ?" ,"Lion","Tiger","monkey","jaguar","Lion" ) );
        list.add( new QuestionModel( "What is the national bird of India ?" ,"Peacock","Sparrow","Kingfisher","Parrot","Peacock" ) );
        list.add( new QuestionModel( "What is the national Flower Of India?" ,"Lotus","Rose","Marigold","Sunflower","Lotus" ) );
        list.add( new QuestionModel( "What is the national Tree of India?","Banyan","Mango","Guava","oak","Banyan" ) );
        list.add( new QuestionModel( "What is the national game of India ?","Hockey","Cricket","football","Volleyball","Hockey" ) );
        list.add( new QuestionModel( "How many states are in India ?","28","29","30","31","28" ) );
        list.add( new QuestionModel( "How many Union Territories are in India ?","7","9","8","6","9" ) );


        for(int i=0;i<4;i++){
            optionscontainer.getChildAt(i ).setOnClickListener( new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void onClick(View v) {
                    checkanswer((Button)v);
                }
            } );
        }

        playAnim( Question,0,list.get( position ).getQuestion() );
        nextbtn.setOnClickListener( new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                nextbtn.setEnabled(false );
                nextbtn.setAlpha(0.7f);
                enableoption( true );
                position++;
                if (position==list.size()){
                    Intent scoreIntent=new Intent( QuestionActivity.this,score_Activity.class );
                    scoreIntent.putExtra( "score",score );
                    scoreIntent.putExtra( "total",list.size());
                    startActivity( scoreIntent );
                    finish ();
                    return;
                }
                count=0;
                playAnim(Question,0,list.get( position ).getQuestion());
            }
        } );
    }
    private void playAnim(final  View view , final int value, final String data){
        view.animate().alpha( value ).scaleX( value ).scaleY( value ).setDuration( 500 ).setStartDelay( 100 ).setInterpolator( new DecelerateInterpolator( )).setListener( new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                if (value == 0 && count<4){
                    String option=" ";
                    if (count==0){
                        option=list.get( position ).getOptionA();
                    }else if (count==1){
                        option=list.get( position ).getOptionB();
                    }else if (count==2){
                        option=list.get( position ).getOptionC();
                    }else if (count==3){
                        option=list.get( position ).getOptionD();
                    }
                        playAnim( optionscontainer.getChildAt( count ), 0,option );
                        count++;
                    }
            }

            @Override
            public void onAnimationEnd(Animator animation) {

                if (value==0){
                    try {
                        ((TextView)view).setText(data);
                        noindicator.setText( position+1+"/"+list.size() );
                    }catch (ClassCastException ex){
                        ((Button)view).setText(data);
                    }
                    view.setTag( data );
                    playAnim( view,1,data);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        } );

    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void checkanswer(Button selectedoption) {
        enableoption( false );
        nextbtn.setEnabled( true );
        nextbtn.setAlpha( 1 );
        if (selectedoption.getText().toString().equals( list.get( position ).getCorrectANS() )){
            selectedoption.setBackgroundTintList( ColorStateList.valueOf( Color.parseColor( "#4CAF50" ) ) );
            score++;
        //correct answer
    }else {
            selectedoption.setBackgroundTintList( ColorStateList.valueOf( Color.parseColor( "#ff0000" ) ) );
            Button correctoption=(Button) optionscontainer.findViewWithTag( list.get( position ).getCorrectANS() );
            correctoption.setBackgroundTintList( ColorStateList.valueOf( Color.parseColor( "#4CAF50" ) ) );
            //incorrect answer
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void enableoption(boolean enabled){
        for(int i=0;i<4;i++){
            optionscontainer.getChildAt(i ).setEnabled( enabled );
            if (enabled){
                optionscontainer.getChildAt( i ).setBackgroundTintList( ColorStateList.valueOf( Color.parseColor( "#989898" ) ) );
            }
        }

    }

}
