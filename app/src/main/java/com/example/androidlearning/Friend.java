package com.example.androidlearning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Friend extends AppCompatActivity {
    ListView listView;
    Button back;
    String contacts[]={"Sai ram _Gatla  ","Sandeep_Nani  ","Varshith  ","Niraj  ","Himanshu  ","Rohith","Akshay","bhai","Bro","Prasadh Sir"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);
        listView=(ListView)findViewById(R.id.listView);
        back=(Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Personalinfo.class));
            }
        });
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.addingcolors,contacts);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);
        listView.setSelector(R.color.yellow);
    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        menu.setHeaderTitle("Friends in need");
    }
    public boolean onContextItemSelected(@NonNull MenuItem item){
        if(item.getItemId()==R.id.call){
        Toast.makeText(getApplicationContext(),"adding friend",Toast.LENGTH_LONG).show();
    }
    else if(item.getItemId()==R.id.sms){
        Toast.makeText(getApplicationContext(),"don't recommend friend",Toast.LENGTH_LONG).show();
    }else{
        return false;
    }
        return true;
    }

}
