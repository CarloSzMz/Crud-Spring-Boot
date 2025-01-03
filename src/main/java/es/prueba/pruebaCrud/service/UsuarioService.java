package es.prueba.pruebaCrud.service;

import es.prueba.pruebaCrud.repository.UsuarioRepository;
import es.prueba.pruebaCrud.repository.entity.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Crear o actualizar un usuario
    public usuario saveOrUpdateUsuario(usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Obtener todos los usuarios
    public List<usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    // Obtener un usuario por ID
    public Optional<usuario> getUsuarioById(Long id) {
        return usuarioRepository.findById(id);
    }

    // Eliminar un usuario por ID
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
