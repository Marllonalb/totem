package painel_atendimento.painel_atendimento.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import painel_atendimento.painel_atendimento.Entidades.Classificacao;
import painel_atendimento.painel_atendimento.Entidades.Ficha;
import painel_atendimento.painel_atendimento.Entidades.Letra;
import painel_atendimento.painel_atendimento.Entidades.Local;
import painel_atendimento.painel_atendimento.Repository.classificacaoRepository;
import painel_atendimento.painel_atendimento.Repository.fichaRepository;
import painel_atendimento.painel_atendimento.Repository.letraRepository;
import painel_atendimento.painel_atendimento.Repository.localRepository;

import java.util.List;

@RestController
@RequestMapping("/api/fichas")
public class fichaController {

    @Autowired
    private fichaRepository ficharepository;

    @Autowired
    private localRepository localrepository;

    @Autowired
    private letraRepository letrarepository;

    @GetMapping
    public List<Ficha> getAllFichas(){
        return ficharepository.findAll();
    }

    @PostMapping("/criar")
    public Ficha criarFicha(
            @RequestParam Long letraId,
            @RequestParam Long localId,
            @RequestParam Long classificacaoId,
            @RequestParam String descricao){
        //Letra letra = letraRepository.findById(letraId).orElseThrow(() -> new RuntimeException("Letra não encontrada"));
        //Local local = localrepository.findById(localId).orElseThrow(()-> new RuntimeException("Local não encontrado"));
        //Classificacao classificacao = classificacaoRepository.findById(classificacaoId).orElseThrow(()-> new RuntimeException("Classificação não encontrada"));
//        Letra letra =
    }





}
