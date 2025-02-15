package com.project.app.service;

import com.project.app.model.Poste;
import com.project.app.repository.PosteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PosteService implements IPosteService {

    @Autowired
    private PosteRepository posteRepository;

    @Override
    public Poste ajouterPoste(Poste poste) {
        return posteRepository.save(poste);
    }

    @Override
    public List<Poste> getAllPostes() {
        return posteRepository.findAll();
    }

    @Override
    public Poste getPosteById(Long id) {
        return posteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Poste non trouvé avec l'ID : " + id));
    }

    @Override
    public Poste updatePoste(Long id, Poste updatedPoste) {
        return posteRepository.findById(id).map(poste -> {
            poste.setTitre(updatedPoste.getTitre());
            poste.setNiveauExperience(updatedPoste.getNiveauExperience());
            poste.setDiplomeRequis(updatedPoste.getDiplomeRequis());
            poste.setCompetencesRequises(updatedPoste.getCompetencesRequises());
            return posteRepository.save(poste);
        }).orElseThrow(() -> new RuntimeException("Poste non trouvé avec l'ID : " + id));
    }

    @Override
    public void deletePoste(Long id) {
        Poste poste = posteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Poste non trouvé avec l'ID : " + id));
        posteRepository.delete(poste);
    }
}
