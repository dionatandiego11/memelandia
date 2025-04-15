package br.com.deresende.meme.controllers;

import br.com.deresende.meme.entities.Meme;
import br.com.deresende.meme.services.MemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memes")
public class MemeController {
    @Autowired
    private MemeService memeService;

    @GetMapping
    public List<Meme> buscaMemes() {
        return memeService.listaTodosMemes();
    }

    @GetMapping("/{id}")
    public Meme buscaMemePorId(@PathVariable Long id) {
        return memeService.buscaMemePorId(id);
    }

    @PostMapping
    public Meme novoMeme(@RequestBody Meme meme) {
        return memeService.novoMeme(meme);
    }
}
