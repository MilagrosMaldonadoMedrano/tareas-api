package com.unlam.tareas_api.service;

import org.springframework.stereotype.Service;
import com.unlam.tareas_api.dto.*;
import com.unlam.tareas_api.exception.TareaNoEncontradaException;
import com.unlam.tareas_api.model.Tarea;
import com.unlam.tareas_api.repository.TareaRepository;


import java.util.List;
@Service
public class TareaService {
    private final TareaRepository repository;

    public TareaService(TareaRepository repository) {
        this.repository = repository;
    }

    public List<TareaResponseDTO> listar() {
        return repository.buscarTodas().stream()
                .map(this::aDTO)
                .toList();
    }

    public TareaResponseDTO obtener(Long id) {
        Tarea tarea = repository.buscarPorId(id)
                .orElseThrow(() -> new TareaNoEncontradaException(id));
        return aDTO(tarea);
    }

    public TareaResponseDTO crear(TareaRequestDTO dto) {
        Tarea nueva = repository.guardar(dto.getTitulo(), dto.getDescripcion());
        return aDTO(nueva);
    }

    public TareaResponseDTO actualizar(Long id, TareaRequestDTO dto) {
        Tarea tarea = repository.buscarPorId(id)
                .orElseThrow(() -> new TareaNoEncontradaException(id));
        tarea.setTitulo(dto.getTitulo());
        tarea.setDescripcion(dto.getDescripcion());
        tarea.setCompletada(dto.isCompletada());
        return aDTO(tarea);
    }

    public void eliminar(Long id) {
        repository.buscarPorId(id)
                .orElseThrow(() -> new TareaNoEncontradaException(id));
        repository.eliminar(id);
    }

    private TareaResponseDTO aDTO(Tarea t) {
        return new TareaResponseDTO(t.getId(), t.getTitulo(), t.getDescripcion(), t.isCompletada());
    }
}
