package es.prueba.pruebaCrud.service;

import es.prueba.pruebaCrud.repository.DepartamentoRepository;
import es.prueba.pruebaCrud.repository.entity.departamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    // Crear o actualizar un departamento
    public departamento saveOrUpdateDepartamento(departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    // Obtener todos los Departamentos
    public List<departamento> getAllDepartamentos() {
        return departamentoRepository.findAll();
    }

    // Obtener un Departamento por ID
    public Optional<departamento> getDepartamentoById(Long id) {
        return departamentoRepository.findById(id);
    }

    // Eliminar un Departamento por ID
    public void deleteDepartamento(Long id) {
        departamentoRepository.deleteById(id);
    }
}
