package com.example.hostelmanager;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.hostelmanager.databinding.ActivityEditStudentBinding;

public class EditStudentActivity extends AppCompatActivity {

    ActivityEditStudentBinding binding;
    StudentDatabase studentdatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditStudentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        studentdatabase = new StudentDatabase(this);
        binding.btget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rollno = binding.ed1.getText().toString();
                if (rollno.equals(""))
                    Toast.makeText(EditStudentActivity.this, "Enter Valid Roll No", Toast.LENGTH_SHORT).show();
                Boolean checkroll = studentdatabase.checkDetails(rollno);
                if (checkroll == false) {
                    Toast.makeText(EditStudentActivity.this, "Roll No Not Found", Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(EditStudentActivity.this, "Data Fetching Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        binding.btsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

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

                        if(roll.equals("")||name.equals("")||fname.equals("")||phone.equals("")||email.equals("")||year.equals("")||dept.equals("")||floor.equals("")||room.equals("")||date.equals("")){
                            Toast.makeText(EditStudentActivity.this, "All Fields are Mandatory", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Boolean update = studentdatabase.updateData(name, fname, phone, email, year, dept, roll, floor, room, date);
                            if(update == true){
                                Toast.makeText(EditStudentActivity.this, "Editing Successful !", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),InnerHomePage.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(EditStudentActivity.this, "Editing Failed!", Toast.LENGTH_SHORT).show();
                            }
                        }

                }
                catch(Exception e){
                    Toast.makeText(EditStudentActivity.this, "Editing Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}