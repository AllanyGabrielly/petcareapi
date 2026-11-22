package com.petcare.api.services;

import com.petcare.api.entities.Agendamento;
import com.petcare.api.repositories.AgendamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;

    public AgendamentoService(AgendamentoRepository agendamentoRepository) {
        this.agendamentoRepository = agendamentoRepository;
    }

    public Agendamento salvar(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }

    public List<Agendamento> listarTodos() {
        return agendamentoRepository.findAll();
    }

    public Optional<Agendamento> buscarPorId(Long id) {
        return agendamentoRepository.findById(id);
    }

    public Agendamento atualizar(Long id, Agendamento agendamentoAtualizado) {
        return agendamentoRepository.findById(id)
                .map(agendamento -> {
                    agendamento.setDataHora(agendamentoAtualizado.getDataHora());
                    agendamento.setStatus(agendamentoAtualizado.getStatus());
                    agendamento.setPet(agendamentoAtualizado.getPet());
                    agendamento.setServico(agendamentoAtualizado.getServico());
                    return agendamentoRepository.save(agendamento);
                })
                .orElse(null);
    }

    public void excluir(Long id) {
        agendamentoRepository.deleteById(id);
    }
}