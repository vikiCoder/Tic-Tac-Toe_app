package com.viki.firstapp.tic_tac_toe;

import android.view.View;
import android.widget.Button;

import java.io.Serializable;

public class Box  {

    static byte turn = 'X', turndone=0;
    public boolean isChangable = true;
    public byte value = ' ';
    private Button btn;

    public Box(Button b){
        btn = b;
        Handler handler = new Handler();
        btn.setOnClickListener(handler);
    }

    static public void changeTurn()
    {
        if(turn == 'X') turn = 'O';
        else turn ='X';
    }

    public void setSign()
    {
        if(isChangable)
        {
            if(turn=='X') btn.setBackgroundResource(R.drawable.x);
            else btn.setBackgroundResource(R.drawable.o);
            isChangable = false;
            value = turn;
            turndone++;
            DoublePlayerPage.status();
        }
    }

    private class Handler implements View.OnClickListener{
        @Override
        public void onClick(View view){
            setSign();
        }
    }
}