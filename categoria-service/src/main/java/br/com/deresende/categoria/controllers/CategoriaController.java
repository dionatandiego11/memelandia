package br.com.deresende.categoria.controllers;

import br.com.deresende.categoria.entities.CategoriaMeme;
import br.com.deresende.categoria.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<CategoriaMeme> buscaCategorias() {
        return categoriaService.listaTodasCategorias();
    }

    @GetMapping("/{id}")
    public CategoriaMeme buscaCategoriaPorId(@PathVariable Long id) {
        return categoriaService.buscaCategoriaPorId(id);
    }

    @PostMapping
    public CategoriaMeme novaCategoria(@RequestBody CategoriaMeme categoriaMeme) {
        return categoriaService.novaCategoriaMeme(categoriaMeme);
    }
}