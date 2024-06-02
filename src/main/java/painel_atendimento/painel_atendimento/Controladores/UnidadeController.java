package painel_atendimento.painel_atendimento.Controladores;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import painel_atendimento.painel_atendimento.Entidades.Unidade;
import painel_atendimento.painel_atendimento.Repository.UnidadeRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/unidade")
public class UnidadeController {

    @Autowired
    private UnidadeRepository unidadeRepository;

    @GetMapping
    public List<Unidade> getAllUnidades(){
        return unidadeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Unidade> getUnidadeById(@PathVariable Long id){
        Optional<Unidade> unidade = unidadeRepository.findById(id);
        return unidade.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }
    @PostMapping
    public ResponseEntity<Unidade> createUnidade(@RequestBody Unidade unidade){
        Unidade savedUnidade = unidadeRepository.save(unidade);
        return ResponseEntity.ok(savedUnidade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Unidade> updateUnidade(@PathVariable Long id, @RequestBody Unidade unidadeDetails){
        Optional<Unidade> unidadeOptional = unidadeRepository.findById(id);
        if (unidadeOptional.isPresent()){
            Unidade unidade = unidadeOptional.get();
            unidade.setNome(unidadeDetails.getNome());
            unidade.setEndereco(unidadeDetails.getEndereco());
            unidade.setTelefone(unidadeDetails.getTelefone());
            unidade.setCreatedAt(unidadeDetails.getCreatedAt());
            unidade.setCreatedBy(unidadeDetails.getCreatedBy());
            Unidade updateUnidade = unidadeRepository.save(unidade);
            return ResponseEntity.ok(updateUnidade);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUnidade(@PathVariable Long id){
        if (unidadeRepository.existsById(id)){
            unidadeRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}
