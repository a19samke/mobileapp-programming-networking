package com.example.networking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    Barg b = new Barg("K2");
    Barg b2 = new Barg("Matterhorn","Mount Everest" ,8884);






}

