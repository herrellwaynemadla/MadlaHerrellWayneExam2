package com.madla.madlaherrellwayneexam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("SUBJECT REQUEST");

        final CheckBox bCheck1 = (CheckBox) findViewById(R.id.checkBox);
        final CheckBox bCheck2 = (CheckBox) findViewById(R.id.checkBox2);
        final CheckBox bCheck3 = (CheckBox) findViewById(R.id.checkBox3);
        final CheckBox bCheck4 = (CheckBox) findViewById(R.id.checkBox4);
        final CheckBox bCheck5 = (CheckBox) findViewById(R.id.checkBox5);
        final CheckBox bCheck6 = (CheckBox) findViewById(R.id.checkBox6);
        final CheckBox bCheck7 = (CheckBox) findViewById(R.id.checkBox7);
        final CheckBox bCheck8 = (CheckBox) findViewById(R.id.checkBox8);
        final EditText et = (EditText) findViewById(R.id.editText);

        Button button1 = (Button) findViewById(R.id.btnNext);
        button1.setOnClickListener (new View.OnClickListener(){
            public void onClick(View v) {
                openNextActivity();
            }
        });

        Button button2 = (Button) findViewById(R.id.btnSave);
        button2.setOnClickListener (new View.OnClickListener(){
            public void onClick(View v) {
                String s1 = bCheck1.getText().toString() + "/";
                String s2 = bCheck2.getText().toString() + "/";
                String s3 = bCheck3.getText().toString() + "/";
                String s4 = bCheck4.getText().toString() + "/";
                String s5 = bCheck5.getText().toString() + "/";
                String s6 = bCheck6.getText().toString() + "/";
                String s7 = bCheck7.getText().toString() + "/";
                String s8 = bCheck8.getText().toString() + "/";
                String s9 = et.getText().toString();
                FileOutputStream writer = null;

                try {
                    writer = openFileOutput("data1.txt", MODE_PRIVATE);
                    if (bCheck1.isChecked()){
                        writer.write(s1.getBytes());
                    }
                    if (bCheck2.isChecked()){
                    writer.write(s2.getBytes());
                    }
                    if (bCheck3.isChecked()){
                    writer.write(s3.getBytes());
                    }
                    if (bCheck4.isChecked()){
                    writer.write(s4.getBytes());
                    }
                    if (bCheck5.isChecked()){
                    writer.write(s5.getBytes());
                    }
                    if (bCheck6.isChecked()){
                    writer.write(s6.getBytes());
                    }
                    if (bCheck7.isChecked()){
                    writer.write(s7.getBytes());
                    }
                    if (bCheck8.isChecked()){
                    writer.write(s8.getBytes());
                    }
                    writer = openFileOutput("data2.txt", MODE_PRIVATE);
                    writer.write(s9.getBytes());
                }catch (FileNotFoundException e){
                    Log.d("error", "File not found.");
                } catch (IOException e) {
                    Log.d("error", "IO error.");
                }finally{
                    try{
                        writer.close();
                    }catch (IOException e){
                        Log.d("error", "File not found.");
                    }
                }
                Toast.makeText(getApplicationContext(), "Data saved...", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void openNextActivity() {
        Intent intent = new Intent(getApplicationContext(), Activity2.class);
        startActivity(intent);
    }


}
