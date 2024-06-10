package br.com.unimedjp.painel_atendimento.controllers;

import br.com.unimedjp.painel_atendimento.entity.Letra;
import br.com.unimedjp.painel_atendimento.services.LetraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/letra")
public class LetraController {

    @Autowired
    private LetraService letraService;

    @GetMapping
    public List<Letra> getAllLetra() {
        return letraService.getAllLetra();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Letra> getLetraById(@PathVariable Long id) {
        Optional<Letra> letra = letraService.getLetraById(id);
        return letra.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Letra> createLetra(@RequestBody Letra letra) {
        Letra savedLetra = letraService.createLetra(letra);
        return ResponseEntity.ok(savedLetra);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Letra> updateLetra(@PathVariable Long id, @RequestBody Letra letraDetails) {
        Optional<Letra> updatedLetra = letraService.updateLetra(id, letraDetails);
        return updatedLetra.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLetra(@PathVariable Long id) {
        if (letraService.deleteLetra(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
