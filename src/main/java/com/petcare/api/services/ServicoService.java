package com.petcare.api.services;

import com.petcare.api.entities.Servico;
import com.petcare.api.repositories.ServicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {

    private final ServicoRepository servicoRepository;

    public ServicoService(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }

    public Servico salvar(Servico servico) {
        return servicoRepository.save(servico);
    }

    public List<Servico> listarTodos() {
        return servicoRepository.findAll();
    }

    public Optional<Servico> buscarPorId(Long id) {
        return servicoRepository.findById(id);
    }

    public Servico atualizar(Long id, Servico servicoAtualizado) {
        return servicoRepository.findById(id)
                .map(servico -> {
                    servico.setNome(servicoAtualizado.getNome());
                    servico.setDescricao(servicoAtualizado.getDescricao());
                    servico.setPreco(servicoAtualizado.getPreco());
                    servico.setPlano(servicoAtualizado.getPlano());
                    return servicoRepository.save(servico);
                })
                .orElse(null);
    }

    public void excluir(Long id) {
        servicoRepository.deleteById(id);
    }
}
