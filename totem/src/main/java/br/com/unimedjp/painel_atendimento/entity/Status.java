package br.com.unimedjp.painel_atendimento.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data

public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "statusfichaseq")
    @SequenceGenerator(name = "statusfichaseq", sequenceName = "statusfichaseq", allocationSize = 1)

    private Long id;

    private String status;

    private LocalDateTime createdAt;

    private String createdBy;

    private Long ativo;

}