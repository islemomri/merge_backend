package com.project.app.service;

import java.util.List;
import java.util.Optional;

import com.project.app.model.Diplome;

public interface IDiplomeService {
	
	public Diplome saveDiplome(Long idType, String libelleTypeDiplome, String libelle);
	public List<Diplome> getAllDiplomes();
	public Optional<Diplome> getDiplomeById(Long id);
	public Diplome archiverDiplome(Long id);
	public Diplome updateDiplome(Long id, Long idType, String libelleTypeDiplome, String libelle);
	public List<Diplome> getAllDiplomenonArchives();
}
