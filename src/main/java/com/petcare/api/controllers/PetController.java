package com.petcare.api.controllers;

import com.petcare.api.entities.Pet;
import com.petcare.api.services.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping
    public ResponseEntity<Pet> salvar(@RequestBody Pet pet) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(petService.salvar(pet));
    }

    @GetMapping
    public List<Pet> listarTodos() {
        return petService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> buscarPorId(@PathVariable Long id) {
        return petService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pet> atualizar(
            @PathVariable Long id,
            @RequestBody Pet pet) {

        Pet atualizado = petService.atualizar(id, pet);

        if (atualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        petService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
