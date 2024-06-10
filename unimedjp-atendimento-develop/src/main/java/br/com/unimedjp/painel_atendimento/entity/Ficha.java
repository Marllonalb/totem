package br.com.unimedjp.painel_atendimento.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Ficha {

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "fichaseq")
    @SequenceGenerator(name = "fichaseq", sequenceName = "fichaseq", allocationSize = 1)

    private Long id;

    private int numero;

    private LocalDateTime data;

    @ManyToOne
    @JoinColumn(name = "letra_id")
    private Letra letra;

    @ManyToOne
    @JoinColumn(name = "local_id")
    private Local local;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;




}
