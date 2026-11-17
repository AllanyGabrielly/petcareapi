package com.petcare.api.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "servicos")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "plano_id")
    private Plano plano;

    @OneToMany(mappedBy = "servico")
    private List<Agendamento> agendamentos;

}
