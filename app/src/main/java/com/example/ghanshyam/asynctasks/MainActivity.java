package com.example.ghanshyam.asynctasks;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView res;
    Button btnAsync;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res = (TextView)findViewById(R.id.txtResult);
        btnAsync = (Button)findViewById(R.id.btnAsync);
        btnAsync.setOnClickListener((view) -> {
            new BackgroundTask(res).execute();
        });
    }
}


 class BackgroundTask extends AsyncTask<Void, Integer, String> {

     TextView res;

     BackgroundTask(TextView textView) {
         res = textView;
     }
    @Override
    protected String doInBackground(Void... voids) {
        for (int i = 1; i < 100000; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i % 1000 == 0)
                publishProgress(i);
        }
        return "All Done";
    }


     @Override
     protected void onProgressUpdate(Integer... values) {
         super.onProgressUpdate(values);
         res.append("" + values);

     }
 }
