package br.com.unimedjp.painel_atendimento.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Guiche {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "guicheseq")
    @SequenceGenerator(name = "guicheseq", sequenceName = "guicheseq", allocationSize = 1)

    private Long id;

    private String descricao;

    private int ativo;

    private int id_usuario;

    @ManyToOne
    @JoinColumn(name = "local_id")
    private Local local;





}
