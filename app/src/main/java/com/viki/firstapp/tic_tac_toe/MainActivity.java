package com.viki.firstapp.tic_tac_toe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

public class MainActivity extends AppCompatActivity {

    private Thread change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent startMainPage = new Intent(this, MainPage.class);

        change = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                } catch(Exception e){
                    System.out.println("Error in thread change");
                }

                startActivity(startMainPage);
                finish();
            }
        };
        change.start();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        System.exit(0);
        return super.onKeyDown(keyCode, event);
    }
}
