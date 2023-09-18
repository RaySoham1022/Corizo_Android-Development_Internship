package com.example.hostelmanager;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.hostelmanager.databinding.ActivityDeleteStudentBinding;

public class DeleteStudentActivity extends AppCompatActivity {

    ActivityDeleteStudentBinding binding;
    StudentDatabase studentdatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDeleteStudentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        studentdatabase = new StudentDatabase(this);
        binding.btdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rollno = binding.ed1.getText().toString();
                if (rollno.equals(""))
                    Toast.makeText(DeleteStudentActivity.this, "Enter Valid Roll No", Toast.LENGTH_SHORT).show();
                Boolean checkroll = studentdatabase.checkDetails(rollno);
                if (checkroll == false) {
                    Toast.makeText(DeleteStudentActivity.this, "Roll No Not Found", Toast.LENGTH_SHORT).show();
                }
                else{
                    try{

                        Boolean delete = studentdatabase.deleteData(rollno);
                        if(delete == true){
                            Toast.makeText(DeleteStudentActivity.this, "Deleting Successful !", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),InnerHomePage.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(DeleteStudentActivity.this, "Deleting Failed!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    catch(Exception e){
                        Toast.makeText(DeleteStudentActivity.this, "Data Fetching Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}