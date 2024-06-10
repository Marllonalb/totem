package br.com.unimedjp.painel_atendimento.services;

import br.com.unimedjp.painel_atendimento.entity.Local;
import br.com.unimedjp.painel_atendimento.repository.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalService {

    @Autowired
    private LocalRepository localRepository;

    public List<Local> getAllLocal() {
        return localRepository.findAll();
    }

    public Optional<Local> getLocalById(Long id) {
        return localRepository.findById(id);
    }

    public Local createLocal(Local local) {
        return localRepository.save(local);
    }

    public Optional<Local> updateLocal(Long id, Local localDetails) {
        return localRepository.findById(id).map(local -> {
            local.setNome(localDetails.getNome());
            local.setUnidade(localDetails.getUnidade());
            local.setCreatedAt(localDetails.getCreatedAt());
            local.setCreatedBy(localDetails.getCreatedBy());
            return localRepository.save(local);
        });
    }

    public boolean deleteLocal(Long id) {
        if (localRepository.existsById(id)) {
            localRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
