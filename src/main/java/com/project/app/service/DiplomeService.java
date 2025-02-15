package com.project.app.service;

import com.project.app.model.Diplome;
import com.project.app.model.TypeDiplome;
import com.project.app.repository.DiplomeRepository;
import com.project.app.repository.TypeDiplomeRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiplomeService implements IDiplomeService{
    
    @Autowired
    private DiplomeRepository diplomeRepository;

    @Autowired
    private TypeDiplomeRepository typeDiplomeRepository;
    
    @Transactional
    public Diplome saveDiplome(Long idType, String libelleTypeDiplome, String libelle) {
        Optional<TypeDiplome> typeDiplomeOpt = typeDiplomeRepository.findById(idType);

        TypeDiplome typeDiplome = typeDiplomeOpt.orElseGet(() -> {
            Optional<TypeDiplome> existingType = typeDiplomeRepository.findByLibelleTypeDiplome(libelleTypeDiplome);
            return existingType.orElseGet(() -> {
                TypeDiplome newType = new TypeDiplome();
                newType.setLibelleTypeDiplome(libelleTypeDiplome);
                return typeDiplomeRepository.save(newType);
            });
        });

        Diplome diplome = new Diplome();
        diplome.setLibelle(libelle);
        diplome.setTypeDiplome(typeDiplome);
        return diplomeRepository.save(diplome);
    }
    
    public List<Diplome> getAllDiplomes() {
        return diplomeRepository.findAll();
    }
    
    public Optional<Diplome> getDiplomeById(Long id) {
        return diplomeRepository.findById(id);
    }
    
    @Transactional
    public Diplome updateDiplome(Long id, Long idType, String libelleTypeDiplome, String libelle) {
        Diplome diplome = diplomeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Diplôme non trouvé avec l'ID : " + id));

        TypeDiplome typeDiplome = typeDiplomeRepository.findById(idType)
            .orElseGet(() -> {
                Optional<TypeDiplome> existingType = typeDiplomeRepository.findByLibelleTypeDiplome(libelleTypeDiplome);
                return existingType.orElseGet(() -> {
                    TypeDiplome newType = new TypeDiplome();
                    newType.setLibelleTypeDiplome(libelleTypeDiplome);
                    return typeDiplomeRepository.save(newType);
                });
            });

        diplome.setLibelle(libelle);
        diplome.setTypeDiplome(typeDiplome);
        return diplomeRepository.save(diplome);
    }

    @Override
    public Diplome archiverDiplome(Long id) {
        Diplome diplome = diplomeRepository.findById(id).orElseThrow(()->new RuntimeException("Diplome n'existe pas"));
        diplome.archiver();
        return diplomeRepository.save(diplome);
    }
    
    @Override
    public List<Diplome> getAllDiplomenonArchives(){
    	return diplomeRepository.findByArchiveFalse();
    }

}
