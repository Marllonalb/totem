package br.com.unimedjp.painel_atendimento.repository;

import br.com.unimedjp.painel_atendimento.entity.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {
}
