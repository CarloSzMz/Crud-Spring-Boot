# Crud Empleados y Departamentos Spring Boot!

Este proyecto es un CRUD desarrollado con **Spring Boot**. 


## Base de Datos

Se ha usado MySQL como base de datos 

SQL

    -- Crear la base de datos
    CREATE DATABASE IF NOT EXISTS usuarios_db;
    USE usuarios_db;
    -- Tabla 'usuario'
    CREATE TABLE IF NOT EXISTS usuario (
	    id INT AUTO_INCREMENT PRIMARY KEY,
	    nombre VARCHAR(100) NOT NULL,
	    email VARCHAR(100) NOT NULL UNIQUE
    );
    -- Tabla 'departamentos'
    CREATE TABLE IF NOT EXISTS departamentos (
        id INT AUTO_INCREMENT PRIMARY KEY,
        nombre VARCHAR(100) NOT NULL
    );
    -- Tabla 'usuariodepartamento'
    CREATE TABLE IF NOT EXISTS usuariodepartamento (
	    id INT AUTO_INCREMENT PRIMARY KEY,
	    departamento_id INT,
	    usuario_id INT,
	    FOREIGN KEY (departamento_id) REFERENCES departamentos(id),
	    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
    );


## API

Para ver mejor la documentación de la API se ha utilizado [swagger](https://swagger.io/docs/) lo que permite ver los endpoints de manera detallada.
