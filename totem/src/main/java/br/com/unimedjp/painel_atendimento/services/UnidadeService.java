package br.com.unimedjp.painel_atendimento.services;

import br.com.unimedjp.painel_atendimento.entity.Local;
import br.com.unimedjp.painel_atendimento.entity.Unidade;
import br.com.unimedjp.painel_atendimento.repository.LocalRepository;
import br.com.unimedjp.painel_atendimento.repository.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnidadeService {

    @Autowired
    private UnidadeRepository unidadeRepository;

    @Autowired
    private LocalRepository localRepository;

    public List<Unidade> getAllUnidades() {
        return unidadeRepository.findAll();
    }

    public Optional<Unidade> getUnidadeById(Long id) {
        return unidadeRepository.findById(id);
    }

    public Unidade createUnidade(Unidade unidade) {
        return unidadeRepository.save(unidade);
    }

    public Optional<Unidade> updateUnidade(Long id, Unidade unidadeDetails) {
        return unidadeRepository.findById(id).map(unidade -> {
            unidade.setNome(unidadeDetails.getNome());
            unidade.setEndereco(unidadeDetails.getEndereco());
            unidade.setTelefone(unidadeDetails.getTelefone());
            unidade.setCreatedAt(unidadeDetails.getCreatedAt());
            unidade.setCreatedBy(unidadeDetails.getCreatedBy());
            return unidadeRepository.save(unidade);
        });
    }

    public boolean deleteUnidade(Long id) {
        if (unidadeRepository.existsById(id)) {
            unidadeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Optional<List<Local>> listarPorUnidade(Long unidadeId) {
        return unidadeRepository.findById(unidadeId).map(unidade -> localRepository.findByUnidadeId(unidadeId));
    }
}
