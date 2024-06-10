package br.com.unimedjp.painel_atendimento.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Classificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "classificacaoseq")
    @SequenceGenerator(name = "classificacaoseq", sequenceName = "classificacaoseq", allocationSize = 1)

    private Long id;

    private String descricao;

    private int preferencial;

    @Column(name = "preferencial_80")
    private int preferencial80;
}
