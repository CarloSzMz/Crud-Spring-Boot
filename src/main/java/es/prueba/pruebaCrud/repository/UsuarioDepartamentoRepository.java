package es.prueba.pruebaCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.prueba.pruebaCrud.repository.entity.usuariodepartamento;

public interface UsuarioDepartamentoRepository extends JpaRepository<usuariodepartamento, Long> {
    // Puedes agregar consultas personalizadas si es necesario
}