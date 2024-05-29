package painel_atendimento.painel_atendimento.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import painel_atendimento.painel_atendimento.Entidades.Classificacao;

public interface ClassificacaoRepository extends JpaRepository<Classificacao, Long> {
}
