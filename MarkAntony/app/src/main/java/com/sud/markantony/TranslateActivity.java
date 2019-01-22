package com.sud.markantony;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;



public class TranslateActivity extends AppCompatActivity implements AsyncResponse {
    RecyclerView recyclerView;
    private Recycler_View_Adapter adapter;
    private String m_Text = "";
    RestAPICall myAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);


        List<Data> data = fill_with_data();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        adapter = new Recycler_View_Adapter(data, getApplication());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //this is to delegate/listener back to this class
        final TranslateActivity temp = this;

        final EnglishText fragment = (EnglishText) getSupportFragmentManager().findFragmentById(R.id.englishTextFragment);
        fragment.setSiblingAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myAsyncTask = new RestAPICall(getApplicationContext());
                myAsyncTask.delegate = temp;
                String url = "https://api.funtranslations.com/translate/shakespeare.json?text=" + fragment.getEnglishText();
                myAsyncTask.execute(url);
            }
        });


        //  Modify the DefaultItemAnimator
        //  RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        //  itemAnimator.setAddDuration(1000);
        //  itemAnimator.setRemoveDuration(1000);
        //  recyclerView.setItemAnimator(itemAnimator);

    }

    /*

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    */
    //Create a list of Data objects
    public List<Data> fill_with_data() {

        List<Data> data = new ArrayList<>();

        data.add(new Data("Shakespeare", "Go on. Type something.", R.drawable.will_dude));
        return data;
    }


    @Override
    public void processFinish(String output) {
        Toast.makeText(getApplicationContext(), output, Toast.LENGTH_LONG).show();
        Log.d("HEy in translate", output.substring(0, 7));
        adapter.insert(0, new Data("translated text",output,R.drawable.will_dude));
    }
}