package br.com.unimedjp.painel_atendimento.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Unidade {

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "unidadeseq")
    @SequenceGenerator(name = "unidadeseq", sequenceName = "unidadeseq", allocationSize = 1)
    private Long id;

    //@Column(nullable = false)
    private String nome;

    //@Column(nullable = false)
    private String endereco;

    //@Column(nullable = false)
    private String telefone;

    //@Column(nullable = false)
    private LocalDateTime createdAt;

    //@Column(nullable = false)
    private String createdBy;

//    @OneToMany(mappedBy = "unidade")
//    @JsonManagedReference
//    private List<Local> locais;
//

}
