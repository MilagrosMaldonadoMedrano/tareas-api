package com.unlam.tareas_api.dto;

public class TareaResponseDTO {

    private Long id;
    private String titulo;
    private String descripcion;
    private boolean completada;

    public TareaResponseDTO(Long id, String titulo, String descripcion, boolean completada) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.completada = completada;
    }

    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getDescripcion() { return descripcion; }
    public boolean isCompletada() { return completada; }
}
