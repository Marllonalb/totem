package br.com.unimedjp.painel_atendimento.controllers;

import br.com.unimedjp.painel_atendimento.entity.Guiche;
import br.com.unimedjp.painel_atendimento.services.GuicheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/guiche")
public class GuicheController {

    @Autowired
    private GuicheService guicheService;

    @GetMapping
    public List<Guiche> getAllGuiche() {
        return guicheService.getAllGuiche();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Guiche> getGuicheById(@PathVariable Long id) {
        Optional<Guiche> guiche = guicheService.getGuicheById(id);
        return guiche.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Guiche> createGuiche(@RequestBody Guiche guiche) {
        Guiche savedGuiche = guicheService.createGuiche(guiche);
        return ResponseEntity.ok(savedGuiche);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Guiche> updateGuiche(@PathVariable Long id, @RequestBody Guiche guicheDetails) {
        Optional<Guiche> updatedGuiche = guicheService.updateGuiche(id, guicheDetails);
        return updatedGuiche.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuiche(@PathVariable Long id) {
        if (guicheService.deleteGuiche(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
