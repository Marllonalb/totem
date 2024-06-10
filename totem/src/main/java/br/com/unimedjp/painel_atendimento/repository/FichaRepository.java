package br.com.unimedjp.painel_atendimento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import br.com.unimedjp.painel_atendimento.entity.Ficha;

@Repository
public interface FichaRepository extends JpaRepository<Ficha, Long> {

    @Query(value = "SELECT COALESCE(MAX(F.NUMERO), 0) FROM APP_FORNECEDORES.FICHA F WHERE F.LOCAL_ID = :localId AND TRUNC(DATA) = TRUNC(SYSDATE)", nativeQuery = true)
    Integer findMaxNumeroByLocalId(@Param("localId") Long localId);




}
