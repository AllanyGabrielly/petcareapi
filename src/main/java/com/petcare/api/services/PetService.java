package com.petcare.api.services;

import com.petcare.api.entities.Pet;
import com.petcare.api.repositories.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public Pet salvar(Pet pet) {
        return petRepository.save(pet);
    }

    public List<Pet> listarTodos() {
        return petRepository.findAll();
    }

    public Optional<Pet> buscarPorId(Long id) {
        return petRepository.findById(id);
    }

    public Pet atualizar(Long id, Pet petAtualizado) {
        return petRepository.findById(id)
                .map(pet -> {
                    pet.setNome(petAtualizado.getNome());
                    pet.setEspecie(petAtualizado.getEspecie());
                    pet.setRaca(petAtualizado.getRaca());
                    pet.setIdade(petAtualizado.getIdade());
                    pet.setCliente(petAtualizado.getCliente());
                    return petRepository.save(pet);
                })
                .orElse(null);
    }

    public void excluir(Long id) {
        petRepository.deleteById(id);
    }
}