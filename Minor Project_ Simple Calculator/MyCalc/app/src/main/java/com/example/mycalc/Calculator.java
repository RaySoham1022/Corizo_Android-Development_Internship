package com.example.mycalc;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.AlertDialog.Builder;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends Activity {

    public EditText display;
    Integer b = 0;
    Double r,c,d, carry = 0.0, temp;
    String a="0",aa, op = "";

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);

        try{
            EditText edt = (EditText) findViewById(R.id.ed1);
            TextView txt3 = (TextView) findViewById(R.id.txt3);

            Button bt1 = (Button) findViewById(R.id.bt1);
            Button bt2 = (Button) findViewById(R.id.bt2);
            Button bt3 = (Button) findViewById(R.id.bt3);
            Button bt4 = (Button) findViewById(R.id.bt4);
            Button bt5 = (Button) findViewById(R.id.bt5);
            Button bt6 = (Button) findViewById(R.id.bt6);
            Button bt7 = (Button) findViewById(R.id.bt7);
            Button bt8 = (Button) findViewById(R.id.bt8);
            Button bt9 = (Button) findViewById(R.id.bt9);
            Button bt0 = (Button) findViewById(R.id.bt0);
            Button btplus = (Button) findViewById(R.id.btplus);
            Button btminus = (Button) findViewById(R.id.btminus);
            Button btmul = (Button) findViewById(R.id.btmul);
            Button btdiv = (Button) findViewById(R.id.btdiv);
            Button btmod = (Button) findViewById(R.id.btmod);
            Button bterase = (Button) findViewById(R.id.bterase);
            Button btcalculate = (Button) findViewById(R.id.btcalculate);

            bt1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    a=edt.getText().toString();
                    a=a+"1";
                    edt.setText(a);

                }
            });

            bt2.setOnClickListener(new View.OnClickListener()
            {

                public void onClick(View v) {
                    a=edt.getText().toString();
                    a=a+"2";
                    edt.setText(a);
                }
            });

            bt3.setOnClickListener(new View.OnClickListener()
            {

                public void onClick(View v) {
                    a=edt.getText().toString();
                    a=a+"3";
                    edt.setText(a);
                }
            });


            bt4.setOnClickListener(new View.OnClickListener()
            {

                public void onClick(View v) {
                    a=edt.getText().toString();
                    a=a+"4";
                    edt.setText(a);

                }
            });


            bt5.setOnClickListener(new View.OnClickListener()
            {

                public void onClick(View v) {

                    a=edt.getText().toString();
                    a=a+"5";
                    edt.setText(a);

                }
            });


            bt6.setOnClickListener(new View.OnClickListener()
            {

                public void onClick(View v) {
                    // TODO Auto-generated method stub

                    a=edt.getText().toString();
                    a=a+"6";
                    edt.setText(a);
                }
            });


            bt7.setOnClickListener(new View.OnClickListener()
            {

                public void onClick(View v) {

                    a=edt.getText().toString();
                    a=a+"7";
                    edt.setText(a);
                }
            });


            bt8.setOnClickListener(new View.OnClickListener()
            {

                public void onClick(View v) {

                    a=edt.getText().toString();
                    a=a+"8";
                    edt.setText(a);

                }
            });


            bt9.setOnClickListener(new View.OnClickListener()
            {

                public void onClick(View v) {

                    a=edt.getText().toString();
                    a=a+"9";
                    edt.setText(a);
                }
            });


            bt0.setOnClickListener(new View.OnClickListener()
            {

                public void onClick(View v) {

                    a=edt.getText().toString();
                    a=a+"0";
                    edt.setText(a);
                }
            });


            btplus.setOnClickListener(new View.OnClickListener()
            {

                public void onClick(View v) {

                    aa=a;
                    System.out.println(aa);
                    b=1;
                    a="";
                    if(aa.equals("")){
                        Toast.makeText(Calculator.this, "Enter Valid Operation !", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        temp = operation(op, carry, Double.parseDouble(aa));
                        carry = temp;
                    }
                    txt3.setText("Operation Selected : Addition" );
                    edt.setText("");
                    op = "plus";
                }
            });





            btminus.setOnClickListener(new View.OnClickListener()
            {

                public void onClick(View v) {

                    aa=a;
                    b=2;
                    a="";
                    if(aa.equals("")){
                        Toast.makeText(Calculator.this, "Enter Valid Operation !", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        temp = operation(op, carry, Double.parseDouble(aa));
                        carry = temp;
                    }
                    txt3.setText("Operation Selected : Subtraction" );
                    edt.setText("");
                    op = "minus";
                }
            });


            btmul.setOnClickListener(new View.OnClickListener()
            {

                public void onClick(View v) {
                    aa=a;
                    b=3;
                    a="";
                    if(aa.equals("")){
                        Toast.makeText(Calculator.this, "Enter Valid Operation !", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        temp = operation(op, carry, Double.parseDouble(aa));
                        carry = temp;
                    }
                    txt3.setText("Operation Selected : Multiplication" );
                    edt.setText("");
                    op = "mul";

                }
            });



            btdiv.setOnClickListener(new View.OnClickListener()
            {

                public void onClick(View v) {
                    aa=a;
                    b=4;
                    a="";
                    if(aa.equals("")){
                        Toast.makeText(Calculator.this, "Enter Valid Operation !", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        temp = operation(op, carry, Double.parseDouble(aa));
                        carry = temp;
                    }
                    txt3.setText("Operation Selected : Division" );
                    edt.setText("");
                    op = "div";

                }
            });

            btmod.setOnClickListener(new View.OnClickListener()
            {

                public void onClick(View v) {
                    aa=a;
                    b=5;
                    a="";
                    if(aa.equals("")){
                        Toast.makeText(Calculator.this, "Enter Valid Operation !", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        temp = operation(op, carry, Double.parseDouble(aa));
                        carry = temp;
                    }
                    txt3.setText("Operation Selected : Modulus" );
                    edt.setText("");
                    op = "mod";

                }
            });

            btcalculate.setOnClickListener(new View.OnClickListener()
            {

                public void onClick(View v) {

                    if(b==1){
//                        c=Double.parseDouble(aa);
                        d=Double.parseDouble(a);
                        r=carry+d;
                        carry = 0.0;
                        op="";
                    }
                    else
                    if(b==2){
//                        c=Double.parseDouble(aa);
                        d=Double.parseDouble(a);
                        r=carry-d;
                        carry = 0.0;
                        op="";
                    }
                    else
                    if(b==3){
//                        c=Double.parseDouble(aa);
                        d=Double.parseDouble(a);
                        r=carry*d;
                        carry = 0.0;
                        op="";
                    }else
                    if(b==4){
//                        c=Double.parseDouble(aa);
                        d=Double.parseDouble(a);
                        r=carry/d;
                        carry = 0.0;
                        op="";
                    }else
                    if(b==5){
//                        c=Double.parseDouble(aa);
                        d=Double.parseDouble(a);
                        r=carry%d;
                        carry = 0.0;
                        op="";
                    }
                    else{
                        Toast.makeText(Calculator.this, "Enter Valid Operation !", Toast.LENGTH_SHORT).show();
                    }

                    txt3.setText("Result is :  " + r );
                    c=0.0;
                    b=0;
                    d=0.0;
                    a="";
                    aa="";
                    edt.setText("");
                }
            });




            bterase.setOnClickListener(new View.OnClickListener()
            {

                public void onClick(View v) {
                    edt.setText("");
                    txt3.setText("");
                }
            });
        }
        catch(Exception e){
            savemsg("Error !!", "Enter Valid Operations");
        }


    }


    public Double operation(String s,Double c, Double aa){
        if(s.equals("plus")){
            c = c + aa;
        }
        else if(s.equals("minus")){
            c = c - aa;
        }
        else if(s.equals("mul")){
            c = c * aa;
        }
        else if(s.equals("div")){
            c = c / aa;
        }
        else if(s.equals("mod")){
            c = c % aa;
        }
        else{
            c=0.0 + aa;
        }
        return c;
    }

    public void savemsg(String title, String msg){

        Builder b = new Builder(this);
        b.setCancelable(true);
        b.setTitle(title);
        b.setMessage(msg);
        b.show();

    }
}
