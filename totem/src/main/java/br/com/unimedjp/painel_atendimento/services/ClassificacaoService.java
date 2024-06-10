package br.com.unimedjp.painel_atendimento.services;

import br.com.unimedjp.painel_atendimento.entity.Classificacao;
import br.com.unimedjp.painel_atendimento.repository.ClassificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassificacaoService {

    @Autowired
    private ClassificacaoRepository classificacaoRepository;

    public List<Classificacao> getAllClassificacao() {
        return classificacaoRepository.findAll();
    }

    public Optional<Classificacao> getClassificacaoById(Long id) {
        return classificacaoRepository.findById(id);
    }

    public Classificacao createClassificacao(Classificacao classificacao) {
        return classificacaoRepository.save(classificacao);
    }

    public Optional<Classificacao> updateClassificacao(Long id, Classificacao classificacaoDetails) {
        return classificacaoRepository.findById(id).map(classificacao -> {
            classificacao.setDescricao(classificacaoDetails.getDescricao());
            classificacao.setPreferencial(classificacaoDetails.getPreferencial());
            classificacao.setPreferencial80(classificacaoDetails.getPreferencial80());
            return classificacaoRepository.save(classificacao);
        });
    }

    public boolean deleteClassificacao(Long id) {
        if (classificacaoRepository.existsById(id)) {
            classificacaoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
