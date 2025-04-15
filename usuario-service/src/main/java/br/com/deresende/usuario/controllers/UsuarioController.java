package br.com.deresende.usuario.controllers;

import br.com.deresende.usuario.entities.Usuario;
import br.com.deresende.usuario.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> buscaUsuarios() {
        return usuarioService.listaTodosUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario buscaUsuarioPorId(@PathVariable Long id) {
        return usuarioService.buscaUsuarioPorId(id);
    }

    @PostMapping
    public Usuario novoUsuario(@RequestBody Usuario usuario) {
        return usuarioService.novoUsuario(usuario);
    }
}