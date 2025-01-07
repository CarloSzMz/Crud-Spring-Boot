package es.prueba.pruebaCrud.controller;

import es.prueba.pruebaCrud.repository.entity.usuario;
import es.prueba.pruebaCrud.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
// import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

// @Controller
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Crear o actualizar un usuario
    @PostMapping
    public ResponseEntity<usuario> createUsuario(@RequestBody usuario usuario) {
        System.out.println("Recibiendo solicitud para crear usuario: " + usuario);
        usuario savedUsuario = usuarioService.saveOrUpdateUsuario(usuario);
        return new ResponseEntity<>(savedUsuario, HttpStatus.CREATED);
    }

    // Obtener todos los usuarios
    @GetMapping
    public ResponseEntity<List<usuario>> getAllUsuarios() {
        List<usuario> usuarios = usuarioService.getAllUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    // Obtener todos los usuarios en formato HTML
    // @GetMapping("/html")
    // public String getUsuariosHtml(Model model) {
    //     List<usuario> usuarios = usuarioService.getAllUsuarios();
    //     model.addAttribute("usuarios", usuarios); // Agregar los usuarios al modelo
    //     return "usuarios"; // Devuelve el nombre del archivo HTML que Thymeleaf procesará
    // }

    // Obtener un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<usuario> getUsuarioById(@PathVariable Long id) {
        Optional<usuario> usuario = usuarioService.getUsuarioById(id);
        return usuario.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Eliminar un usuario por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
