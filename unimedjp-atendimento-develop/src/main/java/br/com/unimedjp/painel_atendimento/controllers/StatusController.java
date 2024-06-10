package br.com.unimedjp.painel_atendimento.controllers;

import br.com.unimedjp.painel_atendimento.entity.Status;
import br.com.unimedjp.painel_atendimento.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @GetMapping
    public List<Status> getAllStatus() {
        return statusService.getAllStatus();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Status> getStatusById(@PathVariable Long id) {
        Optional<Status> status = statusService.getStatusById(id);
        return status.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Status> createStatus(@RequestBody Status status) {
        Status savedStatus = statusService.createStatus(status);
        return ResponseEntity.ok(savedStatus);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Status> updateStatus(@PathVariable Long id, @RequestBody Status statusDetails) {
        Optional<Status> updatedStatus = statusService.updateStatus(id, statusDetails);
        return updatedStatus.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatus(@PathVariable Long id) {
        if (statusService.deleteStatus(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
