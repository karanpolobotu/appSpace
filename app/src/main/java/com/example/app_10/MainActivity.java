//AUTHOR: KARAN POLOBOTU
//DATE: JUNE 7TH, 2020
//Personal project
package com.example.app_10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button Exit = (Button) findViewById(R.id.Quit);
        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });

        final Button Scanner = (Button) findViewById(R.id.Scan);
        Scanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CameraActivity.class);
                startActivity(intent);
            }
        });

        final Button ManualSearch = (Button) findViewById(R.id.search);
        ManualSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, searchActivity.class);
                startActivity(intent);
            }
        });
    }
}