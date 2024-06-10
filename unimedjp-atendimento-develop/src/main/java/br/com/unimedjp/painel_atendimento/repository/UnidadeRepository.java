package br.com.unimedjp.painel_atendimento.repository;

import br.com.unimedjp.painel_atendimento.entity.Unidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, Long> {
}
