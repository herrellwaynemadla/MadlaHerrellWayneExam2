package com.madla.madlaherrellwayneexam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        setTitle("SUMMARY");
        FileInputStream file1 = null;
        FileInputStream file2 = null;
        Button button1 = (Button) findViewById(R.id.btnPrevious);
        Button button2 = (Button) findViewById(R.id.btnSend);
        TextView view1 = (TextView) findViewById(R.id.commentsView);
        TextView subjView = (TextView) findViewById(R.id.subjectList);
        button1.setOnClickListener (new View.OnClickListener(){
            public void onClick(View v) {
                openPrevActivity();
            }
        });
        button2.setOnClickListener (new View.OnClickListener(){
            public void onClick(View v) {
                send();
            }
        });

        try {
            file1 = openFileInput("data1.txt");
            int token;
            String strBA = "";
            while ((token = file1.read()) != -1){
                strBA = strBA + ((char)token);
            }
            file1.close();
            try {
                String[] list = strBA.split("/");
                subjView.append(list[0] + "\n");
                subjView.append(list[1] + "\n");
                subjView.append(list[2] + "\n");
                subjView.append(list[3] + "\n");
                subjView.append(list[4] + "\n");
                subjView.append(list[5] + "\n");
                subjView.append(list[6] + "\n");
                subjView.append(list[7] + "\n");
            } catch (Exception e) {
                Log.d("error", "No strings.");
            }
        } catch (FileNotFoundException e) {
            Log.d("error", "File not found.");
        } catch (IOException e) {
            Log.d("error", "IO error.");
        }

        try {
            file2 = openFileInput("data2.txt");
            int token2;
            String strCmm = "";
            while ((token2 = file2.read()) != -1){
                strCmm = strCmm + ((char)token2);
            }
            file2.close();
            try {
                view1.setText(strCmm);

            } catch (Exception e) {
                Log.d("error", "No strings.");
            }
        } catch (FileNotFoundException e) {
            Log.d("error", "File not found.");
        } catch (IOException e) {
            Log.d("error", "IO error.");
        }
    }

    public void openPrevActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void send() {
        Toast.makeText(getApplicationContext(), "request sent...", Toast.LENGTH_LONG).show();
    }
}
