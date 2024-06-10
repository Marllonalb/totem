package br.com.unimedjp.painel_atendimento.services;

import br.com.unimedjp.painel_atendimento.entity.Letra;
import br.com.unimedjp.painel_atendimento.repository.LetraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LetraService {

    @Autowired
    private LetraRepository letraRepository;

    public List<Letra> getAllLetra() {
        return letraRepository.findAll();
    }

    public Optional<Letra> getLetraById(Long id) {
        return letraRepository.findById(id);
    }

    public Letra createLetra(Letra letra) {
        return letraRepository.save(letra);
    }

    public Optional<Letra> updateLetra(Long id, Letra letraDetails) {
        return letraRepository.findById(id).map(letra -> {
            letra.setLetra(letraDetails.getLetra());
            letra.setCreatedAt(letraDetails.getCreatedAt());
            letra.setLocal(letraDetails.getLocal());
            letra.setCreatedBy(letraDetails.getCreatedBy());
            letra.setClassificacao(letraDetails.getClassificacao());
            return letraRepository.save(letra);
        });
    }

    public boolean deleteLetra(Long id) {
        if (letraRepository.existsById(id)) {
            letraRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
