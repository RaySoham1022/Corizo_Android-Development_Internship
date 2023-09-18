package com.example.hostelmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AllStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_student);

        Button back = (Button) findViewById(R.id.btback);
        TextView alltext = (TextView)findViewById(R.id.txt4);
        TextView counttext = (TextView)findViewById(R.id.txt5);

        StudentDatabase studentDatabase;
        studentDatabase = new StudentDatabase(this);
        StringBuffer result = studentDatabase.allDetails();
        Integer total = (Integer)studentDatabase.countData();

        alltext.setText(result.toString());

        String actualcount = "Total Students : " + total.toString();
        counttext.setText(actualcount);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(getApplicationContext(), InnerHomePage.class);
                startActivity(j);
            }
        });

    }
}