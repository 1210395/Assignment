package com.example.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddActivity extends AppCompatActivity {
    EditText name,age,id,mark;
    Button back;
    Button conf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add);
        name=findViewById(R.id.entername);
        age=findViewById(R.id.enterage);
        id=findViewById(R.id.enterid);
        mark=findViewById(R.id.entermark);
        back=findViewById(R.id.back);
        conf=findViewById(R.id.conf);
        back.setOnClickListener(e->{
            Intent intent = new Intent(AddActivity.this, MainActivity.class);
            startActivity(intent);
        });
        conf.setOnClickListener(e->{
            Toast.makeText(this, "I don't know how to pass data through activities!!!", Toast.LENGTH_SHORT).show();
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}