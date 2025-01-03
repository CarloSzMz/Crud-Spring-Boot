package es.prueba.pruebaCrud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import es.prueba.pruebaCrud.service.DepartamentoService;
import es.prueba.pruebaCrud.repository.entity.departamento;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    // Obtener todos los departamentos
    @GetMapping
    public ResponseEntity<List<departamento>> getAllDepartamentos() {
        List<departamento> departamentos = departamentoService.getAllDepartamentos();
        return new ResponseEntity<>(departamentos, HttpStatus.OK);
    }

    // Crear o actualizar un departamento
    @PostMapping
    public ResponseEntity<departamento> createDepartamento(@RequestBody departamento departamento) {
        System.out.println("Recibiendo solicitud para crear Departamento: " + departamento);
        departamento savedDepartamento = departamentoService.saveOrUpdateDepartamento(departamento);
        return new ResponseEntity<>(savedDepartamento, HttpStatus.CREATED);
    }

    // Obtener un departamento por ID
    @GetMapping("/{id}")
    public ResponseEntity<departamento> getDepartamentoById(@PathVariable Long id) {
        Optional<departamento> departamento = departamentoService.getDepartamentoById(id);
        return departamento.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Eliminar un departamento por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartamento(@PathVariable Long id) {
        departamentoService.deleteDepartamento(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
