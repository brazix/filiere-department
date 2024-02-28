package est.gi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import est.gi.Service.FiliereService;
import est.gi.entities.Filiere;

@RestController
@RequestMapping("/filieres")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FiliereController {
    @Autowired
    private FiliereService filiereService;
    
    // Endpoint pour créer une filière
    @PostMapping
    public Filiere createFiliere(@RequestBody Filiere filiere) {
        return filiereService.createFiliere(filiere);
    }
    
    // Endpoint pour récupérer toutes les filières
    @GetMapping
    public List<Filiere> getAllFilieres() {
        return filiereService.getAllFilieres();
    }
    
    // Endpoint pour récupérer une filière par ID
    @GetMapping("/{id}")
    public ResponseEntity<Filiere> getFiliereById(@PathVariable Long id) {
        Filiere filiere = filiereService.getFiliereById(id);
        return ResponseEntity.ok().body(filiere);
    }
    
    // Endpoint pour mettre à jour une filière
    @PutMapping("/{id}")
    public ResponseEntity<Filiere> updateFiliere(@PathVariable Long id, @RequestBody Filiere filiereDetails) {
        Filiere updatedFiliere = filiereService.updateFiliere(id, filiereDetails);
        return ResponseEntity.ok().body(updatedFiliere);
    }
    
    // Endpoint pour supprimer une filière
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFiliere(@PathVariable Long id) {
        filiereService.deleteFiliere(id);
        return ResponseEntity.ok().build();
    }
}
