package br.com.deresende.meme.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "categoria-service", url = "${categoria.service.url}")
public interface CategoriaClient {
    @GetMapping("/categorias/{id}")
    Object verificaCategoria(@PathVariable("id") Long id);
}