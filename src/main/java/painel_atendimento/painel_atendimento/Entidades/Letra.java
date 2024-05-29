package painel_atendimento.painel_atendimento.Entidades;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Letra {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "letraseq")
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
