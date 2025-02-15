package com.project.app.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.app.dto.DiplomeRequest;
import com.project.app.model.Diplome;

import com.project.app.service.IDiplomeService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
@RequestMapping("/diplomes")
public class DiplomeController {
	
	@Autowired
	private IDiplomeService diplomeService;
	
	@PostMapping("/import")
    public String importDiplomes(@RequestBody List<Map<String, String>> diplomeList) {
        for (Map<String, String> row : diplomeList) {
            Long idType = Long.parseLong(row.get("NRIType_Diplome"));
            String libelleTypeDiplome = row.get("LibelleTypeDiplome");
            String libelle = row.get("Libelle");
            diplomeService.saveDiplome(idType, libelleTypeDiplome, libelle);
        }
        return "Importation terminée avec succès !";
    }
	
	@PostMapping("/{id_type}")
    public ResponseEntity<Diplome> addDiplome(@PathVariable("id_type") Long id,@RequestBody DiplomeRequest request) {
        Diplome diplome = diplomeService.saveDiplome(id,request.getLibelleTypeDiplome(), request.getLibelle());
        return ResponseEntity.ok(diplome);
    }
	
	@GetMapping("/all")
    public List<Diplome> getAllDiplomes() {
        return diplomeService.getAllDiplomes();
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<Diplome> getDiplomeById(@PathVariable("id") Long id) {
        Optional<Diplome> diplome = diplomeService.getDiplomeById(id);
        return diplome.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
	
	@PutMapping("/archiver/{id}")
	public Diplome archiverDiplome(@PathVariable("id") long id) {
		return diplomeService.archiverDiplome(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Diplome> updateDiplome(
	    @PathVariable("id") Long id, 
	    @RequestBody DiplomeRequest request) {

	    Diplome updatedDiplome = diplomeService.updateDiplome(id, request.getIdType(), request.getLibelleTypeDiplome(), request.getLibelle());
	    return ResponseEntity.ok(updatedDiplome);
	}
	
	@GetMapping
	public List<Diplome> getallDiplomenonArchives() {
		return diplomeService.getAllDiplomenonArchives();
	}
	



}
