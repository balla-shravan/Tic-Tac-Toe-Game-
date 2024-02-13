package com.example.androidlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,game,logout,clear;
    String b1,b2,b3,b4,b5,b6,b7,b8,b9;
    ImageView image;
    int flag=0;
    int games_played=0;
    String gamecheck="";
    int games_won=0;
    int games_draw=0;
    int game_loose=0;
    int c=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i=getIntent();
        String username=i.getStringExtra("userbhai");
        Init();

        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearbuttons();
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearbuttons();
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(), Personalinfo.class);
                intent.putExtra("username",username);
                intent.putExtra("gameswon",games_won);
                intent.putExtra("gameslose",game_loose);
                intent.putExtra("gamesdraw",games_draw);
                startActivity(intent);
            }
        });
    }

    private void Init() {
        bt1=(Button)findViewById(R.id.bt1);
        bt2=(Button)findViewById(R.id.bt2);
        bt3=(Button)findViewById(R.id.bt3);
        bt4=(Button)findViewById(R.id.bt4);
        bt5=(Button)findViewById(R.id.bt5);
        bt6=(Button)findViewById(R.id.bt6);
        bt7=(Button)findViewById(R.id.bt7);
        bt8=(Button)findViewById(R.id.bt8);
        bt9=(Button)findViewById(R.id.bt9);
        game=(Button)findViewById(R.id.game);
        logout=(Button) findViewById(R.id.LogOut);
        clear=(Button) findViewById(R.id.cleargame);
        image=(ImageView) findViewById(R.id.personal);
    }
    public void check(View view)
    {
       Button btn=(Button) view;
       if(btn.getText().toString().equals("")) {
           c++;

           if (flag == 0) {
               btn.setText("X");
               flag = 1;
           } else {
               btn.setText("O");
               flag = 0;
           }
           if (c > 4) {
               b1 = bt1.getText().toString();
               b2 = bt2.getText().toString();
               b3 = bt3.getText().toString();
               b4 = bt4.getText().toString();
               b5 = bt5.getText().toString();
               b6 = bt6.getText().toString();
               b7 = bt7.getText().toString();
               b8 = bt8.getText().toString();
               b9 = bt9.getText().toString();


               if (b1.equals(b2) && b2.equals(b3) && !b1.equals(" ")) {
                   Toast.makeText(this, "winner:  " + b1, Toast.LENGTH_LONG).show();
                   gamecheck=b1;
                   clearbuttons();
               } else if (b4.equals(b5) && b5.equals(b6) && !b4.equals(" ")) {
                   Toast.makeText(this, "winner:  " + b4, Toast.LENGTH_LONG).show();
                   gamecheck=b4;
                   clearbuttons();
               } else if (b7.equals(b8) && b8.equals(b9) && !b7.equals(" ")) {
                   Toast.makeText(this, "winner:  " + b7, Toast.LENGTH_LONG).show();
                   gamecheck=b7;
                   clearbuttons();
               } else if (b1.equals(b4) && b4.equals(b7) && !b1.equals(" ")) {
                   Toast.makeText(this, "winner:  " + b1, Toast.LENGTH_LONG).show();
                   gamecheck=b1;
                   clearbuttons();
               } else if (b2.equals(b5) && b5.equals(b8) && !b2.equals(" ")) {
                   Toast.makeText(this, "winner:  " + b2, Toast.LENGTH_LONG).show();
                   gamecheck=b2;
                   clearbuttons();
               } else if (b3.equals(b6) && b6.equals(b9) && !b3.equals(" ")) {
                   Toast.makeText(this, "winner:  " + b3, Toast.LENGTH_LONG).show();
                   gamecheck=b3;
                   clearbuttons();
               } else if (b1.equals(b5) && b5.equals(b9) && !b1.equals(" ")) {
                   Toast.makeText(this, "winner:  " + b1, Toast.LENGTH_LONG).show();
                   gamecheck=b1;
                   clearbuttons();
               } else if (b3.equals(b5) && b5.equals(b7) && !b3.equals(" ")) {
                   Toast.makeText(this, "winner:  " + b3, Toast.LENGTH_LONG).show();
                   gamecheck=b3;
                   clearbuttons();
               }
               else if(c==9)
               {
                   Toast.makeText(this, "draw" , Toast.LENGTH_LONG).show();
                   games_draw++;
                   clearbuttons();
               }
               if(gamecheck.equals("X"))
               {
                   games_won++;
               }
               else {
                   game_loose++;
               }
           }

       }
       games_played++;
    }

    private void clearbuttons() {
        bt1.setText("");
        bt2.setText("");
        bt3.setText("");
        bt4.setText("");
        bt5.setText("");
        bt6.setText("");
        bt7.setText("");
        bt8.setText("");
        bt9.setText("");
        flag=0;
        c=0;
    }



}