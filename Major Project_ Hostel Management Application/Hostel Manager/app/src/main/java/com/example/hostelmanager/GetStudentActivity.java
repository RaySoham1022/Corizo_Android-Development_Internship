package com.example.hostelmanager;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.hostelmanager.databinding.ActivityGetStudentBinding;

public class GetStudentActivity extends AppCompatActivity {

    ActivityGetStudentBinding binding;
    StudentDatabase studentdatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGetStudentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        studentdatabase = new StudentDatabase(this);
        binding.btget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rollno = binding.ed1.getText().toString();
                if (rollno.equals(""))
                    Toast.makeText(GetStudentActivity.this, "Enter Valid Roll No", Toast.LENGTH_SHORT).show();
                Boolean checkroll = studentdatabase.checkDetails(rollno);
                if (checkroll == false) {
                    Toast.makeText(GetStudentActivity.this, "Roll No Not Found", Toast.LENGTH_SHORT).show();
                }
                else{
                    try{
                        String[] studentdetails = new String[10] ;
                        studentdetails = studentdatabase.getDetails(rollno);

                        binding.name.setText(studentdetails[0]);
                        binding.fname.setText(studentdetails[1]);
                        binding.phone.setText(studentdetails[2]);
                        binding.email.setText(studentdetails[3]);
                        binding.year.setText(studentdetails[4]);
                        binding.dept.setText(studentdetails[5]);
                        binding.roll.setText(studentdetails[6]);
                        binding.floor.setText(studentdetails[7]);
                        binding.room.setText(studentdetails[8]);
                        binding.date.setText(studentdetails[9]);
                    }
                    catch(Exception e){
                        Toast.makeText(GetStudentActivity.this, "Data Fetching Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        binding.btback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent j = new Intent(getApplicationContext(), InnerHomePage.class);
                startActivity(j);
            }
        });
    }
}