package com.tuapp.taskmaster;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class TareaAdapter extends RecyclerView.Adapter<TareaAdapter.ViewHolder> {
    private ArrayList<Tarea> lista;

    public TareaAdapter(ArrayList<Tarea> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_tarea, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tarea tarea = lista.get(position);

        holder.titulo.setText(tarea.getTitulo());
        holder.descripcion.setText(tarea.getDescripcion());

        if (tarea.getImportancia() != null) {
            holder.importancia.setText("Importancia: " + tarea.getImportancia());
        } else {
            holder.importancia.setText("Importancia: No especificada");
        }

        if (tarea.getDificultad() != null) {
            holder.dificultad.setText("Dificultad: " + tarea.getDificultad());
        } else {
            holder.dificultad.setText("Dificultad: No especificada");
        }
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titulo, descripcion, importancia, dificultad;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.txtTitulo);
            descripcion = itemView.findViewById(R.id.txtDescripcion);
            importancia = itemView.findViewById(R.id.txtImportancia);
            dificultad = itemView.findViewById(R.id.txtDificultad);
        }
    }
}
