package br.com.unimedjp.painel_atendimento.controllers;

import br.com.unimedjp.painel_atendimento.entity.Atendimento;
import br.com.unimedjp.painel_atendimento.services.AtendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/atendimentos")
public class AtendimentoController {

    @Autowired
    private AtendimentoService atendimentoService;

    @GetMapping
    public List<Atendimento> getAllAtendimentos() {
        return atendimentoService.getAllAtendimento();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atendimento> getAtendimentoById(@PathVariable Long id) {
        Optional<Atendimento> atendimento = atendimentoService.getAtendimentoById(id);
        return atendimento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Atendimento> createAtendimento(@RequestBody Atendimento atendimento) {
        Atendimento savedAtendimento = atendimentoService.createAtendimento(atendimento);
        return ResponseEntity.ok(savedAtendimento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Atendimento> updateAtendimento(@PathVariable Long id, @RequestBody Atendimento atendimentoDetails) {
        Optional<Atendimento> updatedAtendimento = atendimentoService.updateAtendimento(id, atendimentoDetails);
        return updatedAtendimento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAtendimento(@PathVariable Long id) {
        if (atendimentoService.deleteAtendimento(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
