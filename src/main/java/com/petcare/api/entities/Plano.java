package com.petcare.api.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "planos")
public class Plano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "plano")
    private List<Servico> servicos;

}
