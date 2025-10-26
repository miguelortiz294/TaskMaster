package com.tuapp.taskmaster;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageView logo = findViewById(R.id.logoApp);
        TextView titulo = findViewById(R.id.tituloLogin);
        EditText txtUsuario = findViewById(R.id.txtUsuario);
        EditText txtClave = findViewById(R.id.txtClave);
        Button btnIngresar = findViewById(R.id.btnIngresar);

        // 🔹 Estado inicial invisible y desplazado hacia abajo
        View[] elementos = {logo, titulo, txtUsuario, txtClave, btnIngresar};
        for (View v : elementos) {
            v.setTranslationY(80f);
            v.setAlpha(0f);
        }

        // 🔹 Animación elegante, más pausada (1.2s total)
        int delay = 0;
        for (View v : elementos) {
            v.animate()
                    .alpha(1f)
                    .translationY(0f)
                    .setDuration(500)        // duración de cada animación
                    .setStartDelay(delay)    // pequeño retardo entre cada elemento
                    .start();
            delay += 180;                // diferencia de 0.2 segundos entre elementos
        }

        // 🔹 Acción del botón
        btnIngresar.setOnClickListener(v -> {
            String usuario = txtUsuario.getText().toString().trim();
            String clave = txtClave.getText().toString().trim();

            if (usuario.equals("miguel") && clave.equals("9984")) {
                Intent intent = new Intent(LoginActivity.this, ListaActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
            } else {
                Toast.makeText(this, "Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

