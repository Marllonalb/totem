package br.com.unimedjp.painel_atendimento.services;

import br.com.unimedjp.painel_atendimento.entity.Status;
import br.com.unimedjp.painel_atendimento.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;

    public List<Status> getAllStatus() {
        return statusRepository.findAll();
    }

    public Optional<Status> getStatusById(Long id) {
        return statusRepository.findById(id);
    }

    public Status createStatus(Status status) {
        return statusRepository.save(status);
    }

    public Optional<Status> updateStatus(Long id, Status statusDetails) {
        return statusRepository.findById(id).map(status -> {
            status.setStatus(statusDetails.getStatus());
            status.setAtivo(statusDetails.getAtivo());
            status.setCreatedAt(statusDetails.getCreatedAt());
            status.setCreatedBy(statusDetails.getCreatedBy());
            return statusRepository.save(status);
        });
    }

    public boolean deleteStatus(Long id) {
        if (statusRepository.existsById(id)) {
            statusRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
