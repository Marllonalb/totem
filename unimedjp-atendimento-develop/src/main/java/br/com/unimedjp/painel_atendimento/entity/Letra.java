package br.com.unimedjp.painel_atendimento.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Letra {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "letraseq")
    @SequenceGenerator(name = "letraseq", sequenceName = "letraseq", allocationSize = 1)

    private Long id;

    private String letra;
    private LocalDateTime createdAt;
    private String createdBy;

    @ManyToOne
    @JoinColumn(name = "classificacao_id")
    private Classificacao classificacao;

    @ManyToOne
    @JoinColumn(name = "local_id")
    private Local local;



}
