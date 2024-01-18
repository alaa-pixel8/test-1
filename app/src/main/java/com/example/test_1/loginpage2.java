package com.example.test_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class loginpage2 extends AppCompatActivity {
    private EditText fullname;
    private EditText phonenumber;
    private EditText email;
    private EditText password;
    private EditText citylocation;
    private DatabaseReference dbr_2;
    private FirebaseDatabase firebaseDatabase_2;
     private  Button NextB2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage2);
        NextB2 = (Button) findViewById(R.id.NextB2);

        firebaseDatabase_2 = FirebaseDatabase.getInstance();
        dbr_2 = firebaseDatabase_2.getReference();

        fullname = findViewById(R.id.FullName);
        phonenumber=findViewById(R.id.PhoneNumber);
        email=findViewById(R.id.Email);
        password=findViewById(R.id.password);
        citylocation=findViewById(R.id.CityLocation);


        NextB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getName = fullname.getText().toString();
                String getPhonenum = phonenumber.getText().toString();
                String getEmail = email.getText().toString();
                String getPassword = password.getText().toString();
                String getCityLoc = citylocation.getText().toString();

                /////make new file and save it with your name  on (userInfo)
                HashMap<String,Object> hashMap = new HashMap<>();
                hashMap.put("name",getName);
                hashMap.put("phonenumber",getPhonenum);
                hashMap.put("email",getEmail);
                hashMap.put("password",getPassword);
                hashMap.put("cityLocation",getCityLoc);

                ///////make your file name from (getName) and set it on hash map
                dbr_2.child("UserInfo")
                        .child(getName)
                        .setValue(hashMap)

                        /////show notification that you data added
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(loginpage2.this, "data added ", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(loginpage2.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                          /////link that page with deviceinfo3 page (class)
                        Intent intent = new Intent(loginpage2.this,deviceinfo3.class);
                        startActivity(intent);


            }

        });


    }
}