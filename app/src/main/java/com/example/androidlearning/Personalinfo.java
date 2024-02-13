package com.example.androidlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class Personalinfo extends AppCompatActivity {
ImageView image;
TextView gamewon,gamelost,gamedraw,username;
Button back,logout;
int won=0,draw=0,lose=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalinfo);

        Bundle extras = getIntent().getExtras();
        String s=extras.getString("username");
        username=(TextView)findViewById(R.id.user);
        username.setText(s.toUpperCase());
       gamedraw=(TextView) findViewById(R.id.gamedraw);
       gamelost=(TextView) findViewById(R.id.gameloose);
       gamewon=(TextView) findViewById(R.id.gamewon);
       back=(Button) findViewById(R.id.back);
       logout=(Button) findViewById(R.id.LogOut);
       back.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(getApplicationContext(), MainActivity.class));
           }
       });
       logout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(getApplicationContext(), LoginActivity.class));
           }
       });
         won=won+extras.getInt("gameswon",0);
        lose=lose+extras.getInt("gameslose",0);
         draw=draw+extras.getInt("gamesdraw",0);
        Toast.makeText(getApplicationContext(), "username:"+s,Toast.LENGTH_SHORT).show();
        gamedraw.setText(Integer.toString(draw));
        gamewon.setText(Integer.toString(won));
        gamelost.setText(Integer.toString(lose));
        image=(ImageView) findViewById(R.id.settings);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup=new PopupMenu(getApplicationContext(),image);
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
                popup.setOnMenuItemClickListener(new  PopupMenu.OnMenuItemClickListener() {
               @Override
                public boolean onMenuItemClick(MenuItem item) {
                      if(item.getItemId()==R.id.three)
                      {
                          startActivity(new Intent(getApplicationContext(),Code.class));
                      }
                      else if(item.getItemId()==R.id.two)
                      {
                          startActivity(new Intent(getApplicationContext(),Friend.class));
                      }
                    return true;
                    }
                    });
                popup.show();
            }
        });
    }

}