package com.example.laboratorio4.service;

import com.example.laboratorio4.model.Alumno;
import com.example.laboratorio4.repository.AlumnoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {

    private final AlumnoRepository repository;

    public AlumnoService(AlumnoRepository repository) {
        this.repository = repository;
    }

    public List<Alumno> listar() { return repository.findAll(); }

    public Optional<Alumno> buscarPorId(Long id) { return repository.findById(id); }

    public Alumno guardar(Alumno alumno) { return repository.save(alumno); }

    public Optional<Alumno> actualizar(Long id, Alumno datos) {
        return repository.findById(id).map(a -> {
            a.setNombres(datos.getNombres());
            a.setCarrera(datos.getCarrera());
            a.setCiclo(datos.getCiclo());
            a.setPromedio(datos.getPromedio());
            return repository.save(a);
        });
    }

    public boolean eliminar(Long id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }
}