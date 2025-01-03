package es.prueba.pruebaCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.prueba.pruebaCrud.repository.entity.departamento;

public interface DepartamentoRepository extends JpaRepository<departamento, Long> {

}
