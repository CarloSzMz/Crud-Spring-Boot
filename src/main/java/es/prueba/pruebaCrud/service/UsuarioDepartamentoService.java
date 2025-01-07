package es.prueba.pruebaCrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.prueba.pruebaCrud.repository.DepartamentoRepository;
import es.prueba.pruebaCrud.repository.UsuarioDepartamentoRepository;
import es.prueba.pruebaCrud.repository.UsuarioRepository;
import es.prueba.pruebaCrud.repository.entity.departamento;
import es.prueba.pruebaCrud.repository.entity.usuario;
import es.prueba.pruebaCrud.repository.entity.usuariodepartamento;

@Service
public class UsuarioDepartamentoService {
    @Autowired
    private UsuarioDepartamentoRepository usuarioDepartamentoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository; // Para obtener el usuario por id

    @Autowired
    private DepartamentoRepository departamentoRepository; // Para obtener el departamento por id

    // Método para crear la relación entre usuario y departamento
    public usuariodepartamento crearRelacion(Long usuarioId, Long departamentoId) {
        usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        departamento departamento = departamentoRepository.findById(departamentoId)
                .orElseThrow(() -> new RuntimeException("Departamento no encontrado"));

        usuariodepartamento usuarioDepartamento = new usuariodepartamento();
        usuarioDepartamento.setUsuario(usuario);
        usuarioDepartamento.setDepartamento(departamento);

        return usuarioDepartamentoRepository.save(usuarioDepartamento);
    }

    // Método para obtener todas las relaciones de usuario y departamento
    public List<usuariodepartamento> obtenerTodasLasRelaciones() {
        return usuarioDepartamentoRepository.findAll();
    }
    // Otros métodos CRUD según sea necesario (leer, eliminar, etc.)
}
