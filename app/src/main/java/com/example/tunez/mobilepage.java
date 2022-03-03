package com.example.tunez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hbb20.CountryCodePicker;

public class mobilepage extends AppCompatActivity {

    Button sendotpbtnotppage;
    EditText mobilenumbereditext;
    CountryCodePicker ccp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_mobilepage);

        sendotpbtnotppage=findViewById(R.id.sendotpbtnotppage);
        mobilenumbereditext=findViewById(R.id.mobilenumbereditext);
        ccp=(CountryCodePicker)findViewById(R.id.ccp);
        ccp.registerCarrierNumberEditText(mobilenumbereditext);

            sendotpbtnotppage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mobilenumbereditext.getText().length()>0) {
                        Toast.makeText(getApplicationContext(),"Loading..",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mobilepage.this, otp_page.class);
                    intent.putExtra("mobile", ccp.getFullNumberWithPlus().replace(" ", ""));
                    startActivity(intent);}
                    else {
                        Toast.makeText(getApplicationContext(),"Missing Details", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        }

