package painel_atendimento.painel_atendimento.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import painel_atendimento.painel_atendimento.Entidades.Ficha;
import painel_atendimento.painel_atendimento.Repository.FichaRepository;
import painel_atendimento.painel_atendimento.Repository.LetraRepository;
import painel_atendimento.painel_atendimento.Repository.LocalRepository;

import java.util.List;

@RestController
@RequestMapping("/api/fichas")
public class FichaController {

    @Autowired
    private FichaRepository ficharepository;

    @Autowired
    private LocalRepository localrepository;

    @Autowired
    private LetraRepository letrarepository;

    @GetMapping
    public List<Ficha> getAllFichas(){
        return ficharepository.findAll();
    }

//    @PostMapping("/criar")
//    public Ficha criarFicha(
//            @RequestParam Long letraId,
//            @RequestParam Long localId,
//            @RequestParam Long classificacaoId,
//            @RequestParam String descricao){
//        //Letra letra = letraRepository.findById(letraId).orElseThrow(() -> new RuntimeException("Letra não encontrada"));
//        //Local local = localrepository.findById(localId).orElseThrow(()-> new RuntimeException("Local não encontrado"));
//        //Classificacao classificacao = classificacaoRepository.findById(classificacaoId).orElseThrow(()-> new RuntimeException("Classificação não encontrada"));
////        Letra letra =
//    }





}
