package br.com.unimedjp.painel_atendimento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.unimedjp.painel_atendimento.entity.Local;

import java.util.List;

@Repository
public interface LocalRepository extends JpaRepository<Local, Long> {
    List<Local> findByUnidadeId(Long unidadeId);
}
