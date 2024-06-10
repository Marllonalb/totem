package br.com.unimedjp.painel_atendimento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.unimedjp.painel_atendimento.entity.Classificacao;

public interface ClassificacaoRepository extends JpaRepository<Classificacao, Long> {
}
