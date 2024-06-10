package br.com.unimedjp.painel_atendimento.services;

import br.com.unimedjp.painel_atendimento.entity.Atendimento;
import br.com.unimedjp.painel_atendimento.entity.Ficha;
import br.com.unimedjp.painel_atendimento.entity.Status;
import br.com.unimedjp.painel_atendimento.repository.AtendimentoRepository;
import br.com.unimedjp.painel_atendimento.repository.FichaRepository;
import br.com.unimedjp.painel_atendimento.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AtendimentoService {

    @Autowired
    private AtendimentoRepository atendimentoRepository;

    @Autowired
    private FichaRepository fichaRepository;

    @Autowired
    private StatusRepository statusRepository;

    public List<Atendimento> getAllAtendimento(){
        return atendimentoRepository.findAll();
    }

    public Optional<Atendimento> getAtendimentoById(Long id){

        return atendimentoRepository.findById(id);

    }

    public Atendimento createAtendimento(Atendimento atendimento){
        atendimento.setInicio_atendimento(LocalDateTime.now());
        Atendimento savedAtendimento = atendimentoRepository.save(atendimento);

        Long fichaId = atendimento.getFicha().getId();
        fichaRepository.findById(fichaId).ifPresent(ficha -> {
            Status newStatus = statusRepository.findById(2L).orElse(null);
            if (newStatus != null) {
                ficha.setStatus(newStatus);
                fichaRepository.save(ficha);
            }
        });

        return savedAtendimento;
    }

    public Optional<Atendimento> updateAtendimento(Long id, Atendimento atendimentoDetails) {
        return atendimentoRepository.findById(id).map(atendimento -> {
            atendimento.setInicio_atendimento(atendimentoDetails.getInicio_atendimento());
            atendimento.setFim_atendimento(atendimentoDetails.getFim_atendimento());
            atendimento.setLocal(atendimentoDetails.getLocal());
            atendimento.setLetra(atendimentoDetails.getLetra());
            atendimento.setFicha(atendimentoDetails.getFicha());
            atendimento.setGuiche(atendimentoDetails.getGuiche());
            return atendimentoRepository.save(atendimento);
        });
    }

    public boolean deleteAtendimento(Long id) {
        if (atendimentoRepository.existsById(id)) {
            atendimentoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }




}
