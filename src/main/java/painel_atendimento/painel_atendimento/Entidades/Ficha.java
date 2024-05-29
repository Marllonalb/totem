package painel_atendimento.painel_atendimento.Entidades;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Ficha {

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "fichaseq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "letra_id")
    private Letra letra;


    private int numero;
    private LocalDateTime data;

    @ManyToOne
    @JoinColumn(name = "local_id")
    private Local local;




}
