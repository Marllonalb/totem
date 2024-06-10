package br.com.unimedjp.painel_atendimento.services;

import br.com.unimedjp.painel_atendimento.entity.Guiche;
import br.com.unimedjp.painel_atendimento.repository.GuicheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuicheService {

    @Autowired
    private GuicheRepository guicheRepository;

    public List<Guiche> getAllGuiche() {
        return guicheRepository.findAll();
    }

    public Optional<Guiche> getGuicheById(Long id) {
        return guicheRepository.findById(id);
    }

    public Guiche createGuiche(Guiche guiche) {
        return guicheRepository.save(guiche);
    }

    public Optional<Guiche> updateGuiche(Long id, Guiche guicheDetails) {
        return guicheRepository.findById(id).map(guiche -> {
            guiche.setLocal(guicheDetails.getLocal());
            guiche.setDescricao(guicheDetails.getDescricao());
            guiche.setAtivo(guicheDetails.getAtivo());
            guiche.setId_usuario(guicheDetails.getId_usuario());
            return guicheRepository.save(guiche);
        });
    }

    public boolean deleteGuiche(Long id) {
        if (guicheRepository.existsById(id)) {
            guicheRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
