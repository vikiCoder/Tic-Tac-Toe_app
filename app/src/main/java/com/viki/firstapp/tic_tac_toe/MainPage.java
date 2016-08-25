package com.viki.firstapp.tic_tac_toe;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_page);

        final MainPage current = this;

        Button play = (Button) findViewById(R.id.double_player);
        Button help = (Button) findViewById(R.id.help);
        Button about = (Button) findViewById(R.id.about);
        Button exit = (Button) findViewById(R.id.exit);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View view) {
                Intent doubleplayerView = new Intent(current, DoublePlayerPage.class);
                startActivity(doubleplayerView);
            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent helpView = new Intent(current, HelpPage.class);
                startActivity(helpView);
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View view) {
                Intent aboutView = new Intent(current, AboutPage.class);
                startActivity(aboutView);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    new AlertDialog.Builder(current)
                            .setMessage("Are you sure you want to exit?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    System.exit(0);
                                }
                            })
                            .setNegativeButton("No", null)
                            .show();
                }
        });
    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        moveTaskToBack(true);
//        System.exit(0);
//        return super.onKeyDown(keyCode, event);
//    }

    private Toast toast;
    private long lastBackPressTime = 0;
    @Override
    public void onBackPressed() {
        if (this.lastBackPressTime < System.currentTimeMillis() - 4000) {
            toast = Toast.makeText(this, "Press again to exit Tic-Tac-Toe", Toast.LENGTH_LONG);
            toast.show();
            this.lastBackPressTime = System.currentTimeMillis();
        } else {
            System.exit(0);
        }
    }
}
