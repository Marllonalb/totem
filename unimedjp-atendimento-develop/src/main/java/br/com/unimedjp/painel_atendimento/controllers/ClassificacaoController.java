package br.com.unimedjp.painel_atendimento.controllers;

import br.com.unimedjp.painel_atendimento.entity.Classificacao;
import br.com.unimedjp.painel_atendimento.services.ClassificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/classificacao")
public class ClassificacaoController {

    @Autowired
    private ClassificacaoService classificacaoService;

    @GetMapping
    public List<Classificacao> getAllClassificacao() {
        return classificacaoService.getAllClassificacao();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Classificacao> getClassificacaoById(@PathVariable Long id) {
        Optional<Classificacao> classificacao = classificacaoService.getClassificacaoById(id);
        return classificacao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Classificacao> createClassificacao(@RequestBody Classificacao classificacao) {
        Classificacao savedClassificacao = classificacaoService.createClassificacao(classificacao);
        return ResponseEntity.ok(savedClassificacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Classificacao> updateClassificacao(@PathVariable Long id, @RequestBody Classificacao classificacaoDetails) {
        Optional<Classificacao> updatedClassificacao = classificacaoService.updateClassificacao(id, classificacaoDetails);
        return updatedClassificacao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClassificacao(@PathVariable Long id) {
        if (classificacaoService.deleteClassificacao(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
