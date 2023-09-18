package com.example.hostelmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import  android.content.Intent;
public class InnerHomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inner_home_page);

        Button add = (Button) findViewById(R.id.btadddetails);
        Button del = (Button) findViewById(R.id.btdeletedetails);
        Button get = (Button) findViewById(R.id.btgetdetails);
        Button edit = (Button) findViewById(R.id.bteditdetails);
        Button all = (Button) findViewById(R.id.btalldetails);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(getApplicationContext(), AddStudentActivity.class);
                startActivity(j);
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(getApplicationContext(), DeleteStudentActivity.class);
                startActivity(j);
            }
        });

        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(getApplicationContext(), GetStudentActivity.class);
                startActivity(j);
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(getApplicationContext(), EditStudentActivity.class);
                startActivity(j);
            }
        });

        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(getApplicationContext(), AllStudentActivity.class);
                startActivity(j);
            }
        });

    }
}
