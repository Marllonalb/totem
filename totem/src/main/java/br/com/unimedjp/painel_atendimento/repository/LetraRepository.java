package br.com.unimedjp.painel_atendimento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.unimedjp.painel_atendimento.entity.Letra;

@Repository
public interface LetraRepository extends JpaRepository<Letra, Long> {
}
