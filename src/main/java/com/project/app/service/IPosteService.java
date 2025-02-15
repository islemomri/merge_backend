package com.project.app.service;

import java.util.List;

import com.project.app.model.Poste;

public interface IPosteService {
	
	public Poste ajouterPoste(Poste poste);
	public List<Poste> getAllPostes();
	public Poste getPosteById(Long id);
	public Poste updatePoste(Long id, Poste updatedPoste);
	public void deletePoste(Long id);

}
