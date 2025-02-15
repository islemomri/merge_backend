package com.project.app.controller;

import com.project.app.model.Poste;
import com.project.app.service.IPosteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recrutement/postes")
public class PosteController {

    @Autowired
    private IPosteService posteService;

    @PostMapping
    public Poste ajouterPoste(@RequestBody Poste poste) {
        return posteService.ajouterPoste(poste);
    }

    @GetMapping
    public List<Poste> getAllPostes() {
        return posteService.getAllPostes();
    }
    
    @GetMapping("/{id}")
    public Poste getPosteById(@PathVariable("id") Long id) {
        return posteService.getPosteById(id);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Poste> updatePoste(@PathVariable("id") Long id, @RequestBody Poste updatedPoste) {
        return ResponseEntity.ok(posteService.updatePoste(id, updatedPoste));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePoste(@PathVariable("id") Long id) {
        posteService.deletePoste(id);
        return ResponseEntity.ok("Poste supprimé avec succès !");
    }
}
