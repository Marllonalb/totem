package painel_atendimento.painel_atendimento.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Unidade {
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "unidadeseq")
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

}
