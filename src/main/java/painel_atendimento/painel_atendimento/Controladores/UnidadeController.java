package painel_atendimento.painel_atendimento.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import painel_atendimento.painel_atendimento.Entidades.Unidade;
import painel_atendimento.painel_atendimento.Repository.UnidadeRepository;

import java.util.List;

@RestController
public class UnidadeController {

    @Autowired
    private UnidadeRepository unidadeRepository;

    @GetMapping
    public List<Unidade> getAllUnidades(){
        return unidadeRepository.findAll();
    }
}
