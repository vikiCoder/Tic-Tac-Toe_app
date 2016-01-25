package com.viki.firstapp.tic_tac_toe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread change = new Thread(){
            public void run(){
                try{
                    sleep(5000);
                } catch(InterruptedException e){
                    System.out.println("Error in thread change");
                }
                Intent startMainPage = new Intent("com.viki.firstapp.FIRSTPAGE");
                startActivity(startMainPage);
            }
        };
        change.start();
    }
}
