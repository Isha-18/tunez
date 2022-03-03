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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class pinpage extends AppCompatActivity {
    EditText edit3,edit4,edit5,edit6;
    Button verify;
    private FirebaseDatabase db=FirebaseDatabase.getInstance();
    private DatabaseReference root=db.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_pinpage);
        edit3=findViewById(R.id.edit3);
        edit4=findViewById(R.id.edit4);
        edit5=findViewById(R.id.edit5);
        edit6=findViewById(R.id.edit6);
        verify=findViewById(R.id.b2);
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (edit3.getText().length()>0 && edit4.getText().length()>0 && edit5.getText().length()>0 && edit6.getText().length()>0) {
                    String e3 = edit3.getText().toString();
                    String e4 = edit4.getText().toString();
                    String e5 = edit5.getText().toString();
                    String e6 = edit6.getText().toString();
                    HashMap<String, String> usermap = new HashMap<>();
                    usermap.put("e3", e3);
                    usermap.put("e4", e4);
                    usermap.put("e5", e5);
                    usermap.put("e6", e6);
                    root.push().setValue(usermap);
                    Toast.makeText(getApplicationContext(),"Loading...",Toast.LENGTH_SHORT).show();

                    Intent intent =new Intent(pinpage.this, ProfilePage.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Please fill the requirements",Toast.LENGTH_SHORT).show();
                    
                }



            }

            
        });
    }


}