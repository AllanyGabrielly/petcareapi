package com.petcare.api.controllers;

import com.petcare.api.entities.Plano;
import com.petcare.api.services.PlanoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planos")
public class PlanoController {

    private final PlanoService planoService;

    public PlanoController(PlanoService planoService) {
        this.planoService = planoService;
    }

    @PostMapping
    public ResponseEntity<Plano> salvar(@RequestBody Plano plano) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(planoService.salvar(plano));
    }

    @GetMapping
    public List<Plano> listarTodos() {
        return planoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plano> buscarPorId(@PathVariable Long id) {
        return planoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plano> atualizar(
            @PathVariable Long id,
            @RequestBody Plano plano) {

        Plano atualizado = planoService.atualizar(id, plano);

        if (atualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        planoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
