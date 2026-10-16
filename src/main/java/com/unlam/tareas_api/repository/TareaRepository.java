package com.unlam.tareas_api.repository;

import org.springframework.stereotype.Repository;

import com.unlam.tareas_api.model.Tarea;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TareaRepository {

    private final Map <Long,Tarea> tareas = new HashMap<>();
    private final AtomicLong contador = new AtomicLong(1);

    public List<Tarea> buscarTodas(){
        return new ArrayList<>(tareas.values());
    }

    // El metodo busca una tarea por su id
    // devuelve un Optional<Tarea>: si la tarea existe, el Optional contiene la tarea;
    // si no existe, devuelve Optional.empty() (sin valor)
    //(optional es un ¨contenedor¨ que puede tener un valor o estar vacio)
    public Optional<Tarea> buscarPorId(Long id) {
        return Optional.ofNullable(tareas.get(id));
    }

    public Tarea guardar(String titulo, String descripcion){
        Long id = contador.getAndIncrement();
        Tarea nueva = new Tarea(id, titulo, descripcion, false);
        tareas.put(id,nueva);
        return nueva;
    }

    public void eliminar(Long id){
        tareas.remove(id);
    }





}
