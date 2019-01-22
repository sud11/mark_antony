package com.sud.markantony;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Font path
        String fontPath = "fonts/Brotherhood_Script.ttf";
        // text view label
        TextView txtAppname = (TextView) findViewById(R.id.appName);
        // Loading Font Face
        Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
        // Applying font
        txtAppname.setTypeface(tf);

        ImageButton button1 = (ImageButton) findViewById(R.id.button1);
        ImageButton button2 = (ImageButton) findViewById(R.id.button2);
        ImageButton button3 = (ImageButton) findViewById(R.id.button3);
        ImageButton button4 = (ImageButton) findViewById(R.id.button4);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                http://api.funtranslations.com/translate/shakespeare.json?text=
                Intent ins = new Intent(getApplicationContext(), TranslateActivity.class);
                startActivity(ins);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ins = new Intent(getApplicationContext(),InsultActivity.class);
                startActivity(ins);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ins = new Intent(getApplicationContext(), QuotesActivity.class);
                startActivity(ins);
            }

            });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ins = new Intent(getApplicationContext(), QuickTranslate.class);
                startActivity(ins);
            }
        });

        createQuotesDump();
        createInsultsDump();
        createTranslationsDump();

    }

    void createQuotesDump()
    {
        String[] values = new String[] { "‘We are such stuff as dreams are made on, and our little life is rounded with a sleep.’", " ‘The evil that men do lives after them; The good is oft interrèd with their bones.’", "'I would give all my fame for a pot of ale, and safety.'", "'Better a witty fool, than a foolish wit.'","'Men at some time are masters of their fates: The fault, dear Brutus, is not in our stars, But in ourselves, that we are underlings.'","'Come what come may, time and the hour runs through the roughest day.'","'Have more than thou showest, Speak less than thou knowest, Lend less than thou owest, Ride more than thou goest, Learn more than thou trowest, Set less than thou throwest.'","T'he more pity that fools may not speak wisely what wise men do foolishly.'","'‘Cowards die many times before their deaths; the valiant never taste of death but once.’"};
        final ArrayList<String> list = new ArrayList<String>();
        for(int i=0; i<values.length; i++)
        {
            list.add(values[i]);
        }

        FileOutputStream fout = null;
        try {
            fout = openFileOutput("quotes_dump", Context.MODE_APPEND);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(list);
            oos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void createInsultsDump()
    {
        String[] values = new String[] { "Thou wayward unwash'd knave!", "Thou villainous onion-eyed codpiece!", "Thou droning motley-minded miscreant!", "You starvelling, you eel-skin, you dried neat's-tongue, you bull's-pizzle, you stock-fish--O for breath to utter what is like thee!-you tailor's-yard, you sheath, you bow-case, you vile standing tuck!","Thou villainous spur-galled hugger-mugger!","Thou art a very ragged Wart.","Thou art so leaky that we must leave thee to thy sinking.","Hast thou never an eye in thy head?","Thou artless rude-growing giglet!","[Thou] leathern-jerkin, crystal-button, knot-pated, agatering, puke-stocking, caddis-garter, smooth-tongue, Spanish pouch!"};
        final ArrayList<String> list = new ArrayList<String>();
        for(int i=0; i<values.length; i++)
        {
            list.add(values[i]);
        }

        FileOutputStream fout = null;
        try {
            fout = openFileOutput("insults_dump", Context.MODE_APPEND);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(list);
            oos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    void createTranslationsDump()
    {
        String[] values = new String[] { "trans A", "trans B", "trans C", "trans D"};
        final ArrayList<String> list = new ArrayList<String>();
        for(int i=0; i<values.length; i++)
        {
            list.add(values[i]);
        }

        FileOutputStream fout = null;
        try {
            fout = openFileOutput("translations_dump", Context.MODE_APPEND);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(list);
            oos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
