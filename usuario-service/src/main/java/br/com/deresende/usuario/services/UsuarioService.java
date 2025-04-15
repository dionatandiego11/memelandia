package br.com.deresende.usuario.services;

import br.com.deresende.usuario.entities.Usuario;
import br.com.deresende.usuario.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario novoUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listaTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario buscaUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }
}
