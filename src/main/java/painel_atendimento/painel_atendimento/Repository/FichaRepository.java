package painel_atendimento.painel_atendimento.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import painel_atendimento.painel_atendimento.Entidades.Ficha;

@Repository
public interface FichaRepository extends JpaRepository<Ficha, Long> {
}
