package com.tuapp.taskmaster;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class CrearListaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_lista);

        EditText txtTarea = findViewById(R.id.txtTarea);
        EditText txtDescripcion = findViewById(R.id.txtDescripcio);
        Spinner spPrioridades = findViewById(R.id.spPrioridades);
        RadioButton rFacil = findViewById(R.id.rFacil);
        RadioButton rMedia = findViewById(R.id.rMedia);
        RadioButton rDificil = findViewById(R.id.rDificil);
        Button btnAñadir = findViewById(R.id.btnAñadir);
        Button btnSalir = findViewById(R.id.btnSalir);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                new String[]{"Muy Importante", "Poco Importante"}
        ) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView textView = (TextView) super.getView(position, convertView, parent);
                textView.setTextColor(Color.WHITE);
                textView.setBackgroundColor(Color.TRANSPARENT);
                return textView;
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                TextView textView = (TextView) super.getDropDownView(position, convertView, parent);
                textView.setTextColor(Color.BLACK);
                textView.setBackgroundColor(Color.WHITE);
                return textView;
            }
        };

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spPrioridades.setAdapter(adapter);


        spPrioridades.setPopupBackgroundDrawable(
                getResources().getDrawable(android.R.drawable.spinner_dropdown_background)
        );

        btnAñadir.setOnClickListener(v -> {
            String tituloTarea = txtTarea.getText().toString().trim();
            String descTarea = txtDescripcion.getText().toString().trim();
            String prioridad = spPrioridades.getSelectedItem() != null ? spPrioridades.getSelectedItem().toString() : "";
            String dificultad = "";

            if (rFacil.isChecked()) dificultad = "Fácil";
            else if (rMedia.isChecked()) dificultad = "Media";
            else if (rDificil.isChecked()) dificultad = "Difícil";

            if (tituloTarea.isEmpty() || descTarea.isEmpty() || prioridad.isEmpty() || dificultad.isEmpty()) {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent();
                intent.putExtra("titulo", tituloTarea);
                intent.putExtra("descripcion", descTarea);
                intent.putExtra("importancia", prioridad);
                intent.putExtra("dificultad", dificultad);

                setResult(RESULT_OK, intent);
                finish();
            }
        });

        btnSalir.setOnClickListener(v -> {
            Toast.makeText(this, "Volviendo sin guardar...", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
