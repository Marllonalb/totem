package painel_atendimento.painel_atendimento.Controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import painel_atendimento.painel_atendimento.Entidades.Classificacao;
import painel_atendimento.painel_atendimento.Entidades.Local;
import painel_atendimento.painel_atendimento.Repository.ClassificacaoRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/classificacao")
public class ClassificacaoController {

    @Autowired
    private ClassificacaoRepository classificacaoRepository;

    @GetMapping
    public List<Classificacao> getAllClassificacao(){
        return classificacaoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Classificacao> getClassificacaoId(@PathVariable Long id){
        Optional<Classificacao> classificacao = classificacaoRepository.findById(id);
        return classificacao.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());

    }

    @PostMapping
    public ResponseEntity<Classificacao> createClassificacao(@RequestBody Classificacao classificacao){
        Classificacao saveClassificacao = classificacaoRepository.save(classificacao);
        return ResponseEntity.ok(saveClassificacao);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Classificacao> updateClassificacao(@PathVariable Long id, @RequestBody Classificacao classificDetails){
        Optional<Classificacao> classificacaoOptional = classificacaoRepository.findById(id);
        if(classificacaoOptional.isPresent()){
            Classificacao classificacao = classificacaoOptional.get();
            classificacao.setDescricao(classificDetails.getDescricao());
            classificacao.setPreferencial(classificDetails.getPreferencial());
            classificacao.setPreferencial_80(classificDetails.getPreferencial_80());
            Classificacao classificaupdate = classificacaoRepository.save(classificacao);
            return ResponseEntity.ok(classificaupdate);
        }else{
            return ResponseEntity.notFound().build();

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaClassificacao(@PathVariable Long id){
        if(classificacaoRepository.existsById(id)){
            classificacaoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();

        }

    }


















}
