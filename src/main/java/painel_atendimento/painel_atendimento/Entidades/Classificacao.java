package painel_atendimento.painel_atendimento.Entidades;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Classificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "classificacaoseq")
    private Long id;

    private String descricao;
    private int preferencial;
    private int preferencial_80;
}
