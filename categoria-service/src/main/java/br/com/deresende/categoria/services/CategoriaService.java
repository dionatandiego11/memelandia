package br.com.deresende.categoria.services;

import br.com.deresende.categoria.entities.CategoriaMeme;
import br.com.deresende.categoria.repositories.CategoriaRepository;
import br.com.deresende.categoria.clients.UsuarioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private UsuarioClient usuarioClient;

    public CategoriaMeme novaCategoriaMeme(CategoriaMeme categoriaMeme) {
        // Verifica se o usuário existe
        if (categoriaMeme.getUsuarioId() != null) {
            usuarioClient.verificaUsuario(categoriaMeme.getUsuarioId());
        }
        return categoriaRepository.save(categoriaMeme);
    }

    public List<CategoriaMeme> listaTodasCategorias() {
        return categoriaRepository.findAll();
    }

    public CategoriaMeme buscaCategoriaPorId(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }
}
