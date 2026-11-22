package com.petcare.api.services;

import com.petcare.api.entities.Plano;
import com.petcare.api.repositories.PlanoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanoService {

    private final PlanoRepository planoRepository;

    public PlanoService(PlanoRepository planoRepository) {
        this.planoRepository = planoRepository;
    }

    public Plano salvar(Plano plano) {
        return planoRepository.save(plano);
    }

    public List<Plano> listarTodos() {
        return planoRepository.findAll();
    }

    public Optional<Plano> buscarPorId(Long id) {
        return planoRepository.findById(id);
    }

    public Plano atualizar(Long id, Plano planoAtualizado) {
        return planoRepository.findById(id)
                .map(plano -> {
                    plano.setNome(planoAtualizado.getNome());
                    plano.setDescricao(planoAtualizado.getDescricao());
                    plano.setValorMensal(planoAtualizado.getValorMensal());
                    return planoRepository.save(plano);
                })
                .orElse(null);
    }

    public void excluir(Long id) {
        planoRepository.deleteById(id);
    }
}
