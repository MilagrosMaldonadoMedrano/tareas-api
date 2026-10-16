package com.unlam.tareas_api.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


//se usan dos DTOs para no exponer directamente el modelo interno (profundizar en esto para la exposicion)
// y para controlar que datos entran y salen (y poder validar la entrada)
public class TareaRequestDTO {
    @NotBlank(message = "El título es obligatorio")
    @Size(max = 100, message = "El título no puede superar los 100 caracteres")
    private String titulo;

    private String descripcion;

    private boolean completada;

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public boolean isCompletada() { return completada; }
    public void setCompletada(boolean completada) { this.completada = completada; }
}
