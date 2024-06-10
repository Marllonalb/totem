package br.com.unimedjp.painel_atendimento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.unimedjp.painel_atendimento.entity.Status;

public interface StatusRepository  extends JpaRepository <Status ,Long> {


}
