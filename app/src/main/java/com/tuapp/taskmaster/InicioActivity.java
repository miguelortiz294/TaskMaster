package com.tuapp.taskmaster;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class InicioActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        Button btnComenzar = findViewById(R.id.btnComenzar);
        btnComenzar.setOnClickListener(v -> {
            startActivity(new Intent(InicioActivity.this, LoginActivity.class));
            finish();
        });
    }
}
