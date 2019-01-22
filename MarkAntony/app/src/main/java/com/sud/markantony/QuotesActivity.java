package com.sud.markantony;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Random;

public class QuotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);
        final TextView quoteBox = (TextView) findViewById(R.id.quoteBox);

        ImageView quoteMe = (ImageView) findViewById(R.id.quoteMe);
        String fontPath = "fonts/Savoye LET Plain1.0.ttf";

        // text view label
        Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
        quoteBox.setTypeface(tf);

        quoteMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> list = new ArrayList<String>();
                try {
                    FileInputStream fin = getApplicationContext().openFileInput("quotes_dump");
                    ObjectInputStream ois = new ObjectInputStream(fin);
                    list = (ArrayList<String>) ois.readObject();
                    Random r = new Random();

                    quoteBox.setText(list.get(r.nextInt(list.size())));


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
