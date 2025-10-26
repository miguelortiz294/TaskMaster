package com.tuapp.taskmaster;

public class Tarea {
    private String titulo;
    private String descripcion;
    private String importancia;
    private String dificultad;

    public Tarea(String titulo, String descripcion, String importancia, String dificultad) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.importancia = importancia;
        this.dificultad = dificultad;
    }

    public String getTitulo() { return titulo; }
    public String getDescripcion() { return descripcion; }
    public String getImportancia() { return importancia; }
    public String getDificultad() { return dificultad; }


    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setImportancia(String importancia) { this.importancia = importancia; }
    public void setDificultad(String dificultad) { this.dificultad = dificultad; }
}
