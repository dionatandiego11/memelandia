package br.com.deresende.meme.services;

import br.com.deresende.meme.entities.Meme;
import br.com.deresende.meme.repositories.MemeRepository;
import br.com.deresende.meme.clients.UsuarioClient;
import br.com.deresende.meme.clients.CategoriaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemeService {
    @Autowired
    private MemeRepository memeRepository;

    @Autowired
    private UsuarioClient usuarioClient;

    @Autowired
    private CategoriaClient categoriaClient;

    public Meme novoMeme(Meme meme) {
        // Verifica se o usuário existe
        if (meme.getUsuarioId() != null) {
            usuarioClient.verificaUsuario(meme.getUsuarioId());
        }
        
        // Verifica se a categoria existe
        if (meme.getCategoriaId() != null) {
            categoriaClient.verificaCategoria(meme.getCategoriaId());
        }
        
        return memeRepository.save(meme);
    }

    public List<Meme> listaTodosMemes() {
        return memeRepository.findAll();
    }

    public Meme buscaMemePorId(Long id) {
        return memeRepository.findById(id).orElse(null);
    }
}