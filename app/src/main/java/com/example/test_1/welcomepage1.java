package com.example.test_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class welcomepage1 extends AppCompatActivity {
    Button NextB1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcomepage1);

        NextB1 = (Button) findViewById(R.id.NextB1);

        ///code for link 2 activites

        NextB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(welcomepage1.this, loginpage2.class);
                startActivity(intent);
            }
        });
    }
}