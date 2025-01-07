package es.prueba.pruebaCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.prueba.pruebaCrud.repository.entity.usuariodepartamento;
import es.prueba.pruebaCrud.service.UsuarioDepartamentoService;

@RestController
@RequestMapping("/api/usuarios-departamentos")
public class UsuarioDepartamentoController {

    @Autowired
    private UsuarioDepartamentoService usuarioDepartamentoService;

    // Endpoint para crear la relación entre usuario y departamento, recibe los datos por parametro
    @PostMapping
    public ResponseEntity<usuariodepartamento> crearRelacion(
            @RequestParam Long usuarioId,
            @RequestParam Long departamentoId) {

        // Llamar al servicio para crear la relación
        usuariodepartamento usuarioDepartamento = usuarioDepartamentoService.crearRelacion(usuarioId, departamentoId);

        // Retornar la respuesta con la relación creada
        return ResponseEntity.ok(usuarioDepartamento);
    }

    @GetMapping
    public ResponseEntity<List<usuariodepartamento>> obtenerTodasLasRelaciones() {
        List<usuariodepartamento> relaciones = usuarioDepartamentoService.obtenerTodasLasRelaciones();
        return ResponseEntity.ok(relaciones);
    }

    // Otros endpoints (por ejemplo, para obtener todas las relaciones, eliminar,
    // etc.)
}
