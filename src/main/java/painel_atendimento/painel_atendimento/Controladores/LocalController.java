package painel_atendimento.painel_atendimento.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import painel_atendimento.painel_atendimento.Entidades.Local;
import painel_atendimento.painel_atendimento.Repository.LocalRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/local")
public class LocalController {

    @Autowired
    private LocalRepository localRepository;

    @GetMapping
    public List<Local> getAllLocal(){
        return localRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Local> getLocalId(@PathVariable Long id){
        Optional<Local> local = localRepository.findById(id);
        return local.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Local> createLocal(@RequestBody Local local){
        Local saveLocal = localRepository.save(local);
        return ResponseEntity.ok(saveLocal);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Local> updateLocal(@PathVariable Long id, @RequestBody Local localDetails){
        Optional<Local> localOptional = localRepository.findById(id);
        if (localOptional.isPresent()){
            Local local = localOptional.get();
            local.setNome(localDetails.getNome());
            local.setUnidade(localDetails.getUnidade());
            local.setCreatedAt(localDetails.getCreatedAt());
            local.setCreatedBy(localDetails.getCreatedBy());
            Local localUpdate = localRepository.save(local);
            return ResponseEntity.ok(localUpdate);
        }else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping
    public ResponseEntity<Void> deleteLocal(@PathVariable Long id){
        if (localRepository.existsById(id)){
            localRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }






}
