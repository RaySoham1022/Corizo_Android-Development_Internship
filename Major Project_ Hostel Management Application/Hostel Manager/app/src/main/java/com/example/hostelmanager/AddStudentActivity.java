package com.example.hostelmanager;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.hostelmanager.databinding.ActivityAddStudentBinding;

public class AddStudentActivity extends AppCompatActivity {

    ActivityAddStudentBinding binding;
    StudentDatabase studentdatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddStudentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        studentdatabase = new StudentDatabase(this);
        binding.btadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.name.getText().toString();
                String fname = binding.fname.getText().toString();
                String phone = binding.phone.getText().toString();
                String email = binding.email.getText().toString();
                String year = binding.year.getText().toString();
                String dept = binding.dept.getText().toString();
                String roll = binding.roll.getText().toString();
                String floor = binding.floor.getText().toString();
                String room = binding.room.getText().toString();
                String date = binding.date.getText().toString();

                Boolean checkroll = studentdatabase.checkDetails(roll);

                try{
                    if(checkroll == false){
                        if(roll.equals("")||name.equals("")||fname.equals("")||phone.equals("")||email.equals("")||year.equals("")||dept.equals("")||floor.equals("")||room.equals("")||date.equals("")){
                            Toast.makeText(AddStudentActivity.this, "All Fields are Mandatory", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Boolean insert = studentdatabase.insertData(name, fname, phone, email, year, dept, roll, floor, room, date);
                            if(insert == true){
                                Toast.makeText(AddStudentActivity.this, "Adding Successful !", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),InnerHomePage.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(AddStudentActivity.this, "Adding Failed!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                    else{
                        Toast.makeText(AddStudentActivity.this, "Roll No Already Exists", Toast.LENGTH_SHORT).show();
                    }
                }
                catch(Exception e){
                    Toast.makeText(AddStudentActivity.this, "Adding Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}