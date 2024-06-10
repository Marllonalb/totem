package br.com.unimedjp.painel_atendimento.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "atendimentoseq")
    @SequenceGenerator(name = "atendimentoseq", sequenceName = "atendimentoseq", allocationSize = 1)

    private Long id;

    private LocalDateTime inicio_atendimento;

    private LocalDateTime fim_atendimento;

    @ManyToOne
    @JoinColumn(name = "local_id")
    private Local local;

    @ManyToOne
    @JoinColumn(name = "letra_id")
    private Letra letra;

    @ManyToOne
    @JoinColumn(name = "ficha_id")
    private Ficha ficha;

    @ManyToOne
    @JoinColumn(name = "guiche_id")
    private Guiche guiche;






}
