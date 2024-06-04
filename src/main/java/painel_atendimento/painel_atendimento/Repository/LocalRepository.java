package painel_atendimento.painel_atendimento.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import painel_atendimento.painel_atendimento.Entidades.Local;

import java.util.List;

@Repository
public interface LocalRepository extends JpaRepository<Local, Long> {
    List<Local> findByUnidadeId(Long unidadeId);
}
