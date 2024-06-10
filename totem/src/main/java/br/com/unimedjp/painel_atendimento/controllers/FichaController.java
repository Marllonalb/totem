package br.com.unimedjp.painel_atendimento.controllers;

import br.com.unimedjp.painel_atendimento.entity.Ficha;
import br.com.unimedjp.painel_atendimento.services.FichaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fichas")
public class FichaController {

    @Autowired
    private FichaService fichaService;

    @GetMapping
    public List<Ficha> getAllFichas() {
        return fichaService.getAllFichas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ficha> getFichaById(@PathVariable Long id) {
        Optional<Ficha> ficha = fichaService.getFichaById(id);
        return ficha.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Ficha> createFicha(@RequestBody Ficha ficha) {
        try {
            Ficha savedFicha = fichaService.createFicha(ficha);
            return ResponseEntity.ok(savedFicha);
        } catch (RuntimeException e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ficha> updateFicha(@PathVariable Long id, @RequestBody Ficha fichaDetails) {
        Optional<Ficha> updatedFicha = fichaService.updateFicha(id, fichaDetails);
        return updatedFicha.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFicha(@PathVariable Long id) {
        if (fichaService.deleteFicha(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
