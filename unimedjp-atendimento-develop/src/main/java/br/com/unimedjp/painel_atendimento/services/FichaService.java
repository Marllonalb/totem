package br.com.unimedjp.painel_atendimento.services;

import br.com.unimedjp.painel_atendimento.entity.Ficha;
import br.com.unimedjp.painel_atendimento.entity.Status;
import br.com.unimedjp.painel_atendimento.repository.FichaRepository;
import br.com.unimedjp.painel_atendimento.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FichaService {

    @Autowired
    private FichaRepository fichaRepository;

    @Autowired
    private StatusRepository statusRepository;

    public List<Ficha> getAllFichas() {
        return fichaRepository.findAll();
    }

    public Optional<Ficha> getFichaById(Long id) {
        return fichaRepository.findById(id);
    }

    public Ficha createFicha(Ficha ficha) {
        Long localId = ficha.getLocal().getId();
        Integer maxNumero = fichaRepository.findMaxNumeroByLocalId(localId);
        Optional<Status> statusOptional = statusRepository.findById(1L);

        if (statusOptional.isPresent()) {
            ficha.setNumero(maxNumero + 1);
            ficha.setData(LocalDateTime.now());
            ficha.setStatus(statusOptional.get());
            return fichaRepository.save(ficha);
        } else {
            throw new RuntimeException("Status not found");
        }
    }

    public Optional<Ficha> updateFicha(Long id, Ficha fichaDetails) {
        return fichaRepository.findById(id).map(ficha -> {
            ficha.setData(fichaDetails.getData());
            ficha.setLetra(fichaDetails.getLetra());
            ficha.setNumero(fichaDetails.getNumero());
            ficha.setLocal(fichaDetails.getLocal());
            return fichaRepository.save(ficha);
        });
    }

    public boolean deleteFicha(Long id) {
        if (fichaRepository.existsById(id)) {
            fichaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
