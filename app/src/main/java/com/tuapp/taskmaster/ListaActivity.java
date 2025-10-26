package com.tuapp.taskmaster;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ListaActivity extends AppCompatActivity {
    RecyclerView recycler;
    ArrayList<Tarea> lista = new ArrayList<>();
    Button btnAgregar, btnSalirr;
    TareaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        recycler = findViewById(R.id.recyclerTareas);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        btnAgregar = findViewById(R.id.btnAgregar);
        btnSalirr = findViewById(R.id.btnSalirr); // 🔹 Nuevo botón

        // Datos de ejemplo
        lista.add(new Tarea("Trabajo grupal", "Entrega el 30-10-2025", "Muy Importante", "Dificil"));
        lista.add(new Tarea("Prueba", "de Base de datos", "Muy Importante", "Dificil"));

        adapter = new TareaAdapter(lista);
        recycler.setAdapter(adapter);

        btnAgregar.setOnClickListener(v -> {
            Intent intent = new Intent(ListaActivity.this, CrearListaActivity.class);
            startActivityForResult(intent, 1);
        });

        btnSalirr.setOnClickListener(v -> {
            Intent intent = new Intent(ListaActivity.this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            String titulo = data.getStringExtra("titulo");
            String descripcion = data.getStringExtra("descripcion");
            String importancia = data.getStringExtra("importancia");
            String dificultad = data.getStringExtra("dificultad");

            // Agregar la nueva tarea a la lista
            lista.add(new Tarea(titulo, descripcion, importancia, dificultad));
            adapter.notifyItemInserted(lista.size() - 1);
        }
    }
}
