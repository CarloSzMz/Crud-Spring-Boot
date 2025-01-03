package es.prueba.pruebaCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.prueba.pruebaCrud.repository.entity.usuario;

public interface UsuarioRepository extends JpaRepository<usuario, Long> {
    // Puedes agregar consultas personalizadas si es necesario
}
