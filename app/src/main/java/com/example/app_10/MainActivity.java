//AUTHOR: KARAN POLOBOTu
//DATE: JUNE 7TH, 2020
//Personal project
package com.example.app_10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.IOException;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

import java.text.SimpleDateFormat;
import java.util.*;

import java.util.HashMap;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button Exit = (Button) findViewById(R.id.Quit);
        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                // your handler code here
                finish();
                System.exit(0);
            }
        });

        final Button Scanner = (Button) findViewById(R.id.Scan);
        Scanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CameraActivity.class));
            }

        });

        final Button ManualSearch = (Button) findViewById(R.id.DropDown);
        Scanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                // your handler code here
            }
        });
    }




    //WEBSCRAPER FUNCTIONS, USE LATER FOR SCANNING
    public static void main(String[] args) {
        try {

            int j = 0;
            int k = 0;
            int f = 0;

            String[] Key = new String[59];

            String[] keyfinder;

            String[] valuefinder;

            String newKey = "";

            String[] Value = new String[59];

            Elements[] newLinks = new Elements[59];

            Document doc = Jsoup.connect("https://earth911.com/recycling-center-search-guides/?utm_source=earth911-header&utm_medium=top-navigation-menu&utm_campaign=top-nav-recycle-guide-button").userAgent("Mozilla/17.0").get();
            Elements subtemp = doc.select("div.x-accordion-body");
            Elements link = doc.select("a.href");

            for (Element intemp : subtemp) {
                newLinks[j] = (intemp.getElementsByAttribute("href"));
                //System.out.println(newLinks[j]);
                keyfinder = String.valueOf(newLinks[j]).split(">");
                valuefinder = String.valueOf(newLinks[j]).split("=");
                for (int g = 2; g < valuefinder.length; g += 4) {
                    String newStr = valuefinder[g].replace(" target", "");
                    Value[f] = newStr;
                    //System.out.println((Value[f]));
                    f++;
                }

                for (int i = 1; i < keyfinder.length; i += 2) {
                    //System.out.println((keyfinder[i]).replace("</a", ""));
                    newKey = (keyfinder[i]).replace("</a", "");
                    Key[k] = (newKey);
                    k++;
                }
            }

            j++;


            Value[Value.length - 1] = "https://earth911.com/recycling-guide/how-to-recycle-christmas-trees/";
            //time to create hashmap/dictionary, then search feature
            HashMap dB = new HashMap();

            for (int a = 0; a < Key.length;a++) {
                dB.put(Key[a], Value[a]);
            }

        }
        catch(IOException e) {e.printStackTrace();}
    }
}