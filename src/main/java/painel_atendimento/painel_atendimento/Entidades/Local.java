package painel_atendimento.painel_atendimento.Entidades;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Local {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "localseq")
    //@SequenceGenerator(name="localseq”, sequenceName="localseq")
    private Long id;

    private String nome;
    private LocalDateTime createdAt;
    private String createdBy;

    @ManyToOne
    @JoinColumn(name = "unidade_id")
    @JsonBackReference
    private Unidade unidade;

}
