package com.example.test_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.test_1.list.Userlist;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class deviceinfo3 extends AppCompatActivity {

    private EditText DeviceName;
    private EditText DeviceModel;
    private EditText Description;
    private DatabaseReference dbr_3;
    private FirebaseDatabase firebaseDatabase_3;
    private Button NextB3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deviceinfo3);

        NextB3 = (Button) findViewById(R.id.NextB3);

        firebaseDatabase_3 = FirebaseDatabase.getInstance();
        dbr_3 = firebaseDatabase_3.getReference();

        DeviceName = findViewById(R.id.DeviceNameET);
        DeviceModel = findViewById(R.id.DeviceModelET);
        Description = findViewById(R.id.DescriptionET);

        NextB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getDeviceN = DeviceName.getText().toString();
                String getDeviceM = DeviceModel.getText().toString();
                String getDescription = Description.getText().toString();

                HashMap<String , Object> hashMap = new HashMap<>();

                hashMap.put("Device-Name", getDeviceN);
                hashMap.put("Device-Model", getDeviceM);
                hashMap.put("Description", getDescription);


                dbr_3.child("UserInfo")
                        .child(getDeviceN)
                        .setValue(hashMap)

                        ////add notfication that the data added
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(deviceinfo3.this, "data added ", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(deviceinfo3.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });

                ////link screen 3 to the chat
                Intent intent = new Intent(deviceinfo3.this, Userlist.class);
                startActivity(intent);

            }

        });

    }

}

