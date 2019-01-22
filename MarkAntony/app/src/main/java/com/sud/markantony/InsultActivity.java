package com.sud.markantony;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class InsultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insult);
        final TextView insultBox = (TextView) findViewById(R.id.insultBox);
        final TextView sourceBox = (TextView) findViewById(R.id.sourceBox);
        ImageView tauntMe = (ImageView) findViewById(R.id.tauntMe);
        final String siteUrl = "http://www.pangloss.com/seidel/Shaker/index.html";
        String fontPath = "fonts/Savoye LET Plain1.0.ttf";

        // text view label
        Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
        insultBox.setTypeface(tf);
        sourceBox.setTypeface(tf);
        (new ParseURL(getApplicationContext(), insultBox,sourceBox)).execute(new String[]{siteUrl});

        tauntMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                (new ParseURL(getApplicationContext(), insultBox,sourceBox)).execute(new String[]{siteUrl});
            }
        });

    }


}
