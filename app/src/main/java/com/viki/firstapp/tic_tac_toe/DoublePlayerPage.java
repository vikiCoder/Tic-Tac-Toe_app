package com.viki.firstapp.tic_tac_toe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DoublePlayerPage extends AppCompatActivity {

    Button b[][] = new Button[3][3];
    static Box box[][] = new Box[3][3];
    static TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doubleplayer_page);

        b[0][0] = (Button) findViewById(R.id.b00);
        b[0][1] = (Button) findViewById(R.id.b01);
        b[0][2] = (Button) findViewById(R.id.b02);
        b[1][0] = (Button) findViewById(R.id.b10);
        b[1][1] = (Button) findViewById(R.id.b11);
        b[1][2] = (Button) findViewById(R.id.b12);
        b[2][0] = (Button) findViewById(R.id.b20);
        b[2][1] = (Button) findViewById(R.id.b21);
        b[2][2] = (Button) findViewById(R.id.b22);
        status = (TextView) findViewById(R.id.status);

        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++)
                box[i][j] = new Box(b[i][j]);


        Button reset = (Button) findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                reset();
            }
        });

        Button back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                reset();
                finish();
            }
        });
       }

    public static String status()
    {
        String msg = String.format("%c won", Box.turn);
        boolean endgame = false;

        if(Box.turndone == 9)
        {
            msg = String.format("Match Draw !!!");
            endgame = true;
        }

        for(int i=0; i<3; i++)
        {
            if( ( (box[i][0].value==box[i][1].value)&&(box[i][0].value==box[i][2].value)&&(box[i][0].value!=' ') )
                    || ( (box[0][i].value==box[1][i].value)&&(box[0][i].value==box[2][i].value)&&(box[0][i].value!=' ') ) )
            {
                msg = String.format("%c won", Box.turn);
                endgame = true;
                break;
            }
        }

        if( ( (box[0][0].value==box[1][1].value)&&(box[0][0].value==box[2][2].value)&&(box[0][0].value!=' ') )
                || ( (box[0][2].value==box[1][1].value)&&(box[0][2].value==box[2][0].value)&&(box[0][2].value!=' ') ) )
        {
            msg = String.format("%c won", Box.turn);
            endgame = true;
        }

        if(!endgame)
        {
            Box.changeTurn();
            msg = String.format("%c's turn", Box.turn);
        }

        if(endgame)
        {
            for(int i=0; i<3; i++) {
                for (int j = 0; j < 3; j++)
                    box[i][j].isChangable = false;
            }
        }

        status.setText(msg);
        return msg;
    }

    private void reset()
    {
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                box[i][j].value = ' ';
                b[i][j].setBackgroundResource(R.drawable.b);
                box[i][j].isChangable = true;
            }

            Box.turn = 'X';
            Box.turndone = 0;
            status.setText("X's turn");
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        reset();
        finish();
        return super.onKeyDown(keyCode, event);
    }
}
