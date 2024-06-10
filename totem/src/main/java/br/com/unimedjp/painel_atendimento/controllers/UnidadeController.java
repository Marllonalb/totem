package br.com.unimedjp.painel_atendimento.controllers;

import br.com.unimedjp.painel_atendimento.entity.Local;
import br.com.unimedjp.painel_atendimento.entity.Unidade;
import br.com.unimedjp.painel_atendimento.services.UnidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UnidadeController {

    @Autowired
    private UnidadeService unidadeService;

    @GetMapping("/unidades")
    public List<Unidade> getAllUnidades() {
        return unidadeService.getAllUnidades();
    }

    @GetMapping("/unidade/{id}")
    public ResponseEntity<Unidade> getUnidadeById(@PathVariable Long id) {
        Optional<Unidade> unidade = unidadeService.getUnidadeById(id);
        return unidade.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/unidade")
    public ResponseEntity<Unidade> createUnidade(@RequestBody Unidade unidade) {
        Unidade savedUnidade = unidadeService.createUnidade(unidade);
        return ResponseEntity.ok(savedUnidade);
    }

    @PutMapping("/unidade/{id}")
    public ResponseEntity<Unidade> updateUnidade(@PathVariable Long id, @RequestBody Unidade unidadeDetails) {
        Optional<Unidade> updatedUnidade = unidadeService.updateUnidade(id, unidadeDetails);
        return updatedUnidade.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/unidade/{id}")
    public ResponseEntity<Void> deleteUnidade(@PathVariable Long id) {
        if (unidadeService.deleteUnidade(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/unidade/{unidadeId}/locais")
    public ResponseEntity<List<Local>> listarPorUnidade(@PathVariable Long unidadeId) {
        Optional<List<Local>> locais = unidadeService.listarPorUnidade(unidadeId);
        return locais.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
