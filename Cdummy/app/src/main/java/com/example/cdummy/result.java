package com.example.cdummy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class result extends AppCompatActivity {

    public void textdisplay(String filename, TextView textView){
        String str="";
        try {
            InputStream inputStream = getAssets().open(filename);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            str=new String(buffer);
        } catch (IOException e){
            e.printStackTrace();
        }
        //if code for "program-name only"
        if (filename.contains("ProgramName")){
            str="Program : "+str;
        }
        textView.setText(str);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        String s=intent.getStringExtra("key");

        String name ="ProgramName"+s;
        String program ="Program"+s;
        String output ="Output"+s;

        //display code
        textdisplay(name , (TextView) findViewById(R.id.textView1) );
        textdisplay(program , (TextView) findViewById(R.id.textView2) );
        textdisplay(output , (TextView) findViewById(R.id.textView4) );
    }
}