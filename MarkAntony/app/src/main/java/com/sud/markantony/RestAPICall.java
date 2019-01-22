package com.sud.markantony;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by hema on 1/5/17.
 */
public class RestAPICall extends AsyncTask<String, Integer, String> {
    private Context context;
    private String translatedText;
    public AsyncResponse delegate = null;
    public RestAPICall(Context applicationContext) {
        this.context = context;
    }

    public RestAPICall() {
        // for the sake of it
    }

    @Override
    protected String doInBackground(String... params) {
        URL url = null;
        try {
            Log.d("HEY","params[0]]");
            String tempURL = params[0];
            tempURL = tempURL.replaceAll(" ","%20");
            url = new URL(tempURL);

            Log.d("url is ",url.toString());
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();

            InputStream in = urlConnection.getInputStream();
            String result = convertStreamToString(in);

            JSONObject jsonObj = new JSONObject(result);
            JSONObject contents = jsonObj.getJSONObject("contents");
            translatedText = contents.getString("translated");
            Log.d("HEY",translatedText.substring(0,10));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
    @Override
    protected void onPostExecute(String s) {
        delegate.processFinish(translatedText);
    }
}
