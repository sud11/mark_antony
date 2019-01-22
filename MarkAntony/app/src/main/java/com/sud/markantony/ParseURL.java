package com.sud.markantony;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by hema on 28/4/17.
 */
public class ParseURL extends AsyncTask<String, View, String[]>{

    private Context context;
    private TextView insultBox;
    private TextView sourceBox;
    public ParseURL(Context context, TextView insultBox, TextView sourceBox){
        this.context = context;
        this.insultBox = insultBox;
        this.sourceBox = sourceBox;
    }
    @Override
    protected String[] doInBackground(String... strings) {
        StringBuffer buffer = new StringBuffer();
        String ins="";
        String insFrom="";
        try
        {
            Log.d("JSwa", "Connecting to [" + strings[0] + "]");
            Document doc = Jsoup.connect(strings[0]).get();
            Log.d("JSwa", "Connected to ["+strings[0]+"]");
            // Get document (HTML page) title
            String title = doc.title();
            Log.d("JSwA", "Title ["+title+"]");

            //Element content = doc.getElementById("p");
            String pConcatenated="";
            Elements p= doc.getElementsByTag("p");
            Element insult = p.get(0);
            Element takenFrom = p.get(1);
            ins=insult.text();
            insFrom=takenFrom.text();
            pConcatenated = '"' +insult.text() + '"'+"  - " + takenFrom.text();
            Log.d("concat",pConcatenated);
            buffer.append(pConcatenated);

        }
        catch(Throwable t) {
            t.printStackTrace();
        }
    return new String[] {ins,insFrom};
    //return buffer.toString();
    }
    @Override
    protected void onPostExecute(String s[]) {
        super.onPostExecute(s);
        insultBox.setText("\u201C"+s[0]+"\u201D");
        sourceBox.setText(s[1]);

    }

}
