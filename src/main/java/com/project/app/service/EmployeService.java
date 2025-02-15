package com.project.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.app.model.Employe;
import com.project.app.model.Discipline;
import com.project.app.repository.EmployeRepository;
import com.project.app.repository.DisciplineRepository;

@Service
public class EmployeService implements IEmployeService {
    @Autowired
    private EmployeRepository employeRepository;

    @Autowired
    private DisciplineRepository disciplineRepository;

    public List<Employe> getAllEmployes() {
        return employeRepository.findAll();
    }

    public Employe addEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    public Optional<Employe> getEmployeById(Long id) {
        return employeRepository.findById(id);
    }

    public void deleteEmploye(Long id) {
        employeRepository.deleteById(id);
    }

    
    public List<Discipline> getDisciplinesByEmploye(Long employeId) {
        return disciplineRepository.findByEmployeId(employeId);
    }

    
    public Discipline addDisciplineToEmploye(Long employeId, Discipline discipline) {
        // Récupérer l'employé par son ID
        Employe employe = employeRepository.findById(employeId)
                .orElseThrow(() -> new RuntimeException("Employé non trouvé"));

        // Associer la discipline à l'employé
        discipline.setEmploye(employe);

        // Sauvegarder la discipline
        return disciplineRepository.save(discipline);
    }

    public void removeDisciplineFromEmploye(Long employeId, Long disciplineId) {
        Employe employe = employeRepository.findById(employeId)
                .orElseThrow(() -> new RuntimeException("Employé non trouvé"));
        
        Discipline discipline = disciplineRepository.findById(disciplineId)
                .orElseThrow(() -> new RuntimeException("Discipline non trouvée"));
        
        employe.getDisciplines().remove(discipline); 
        discipline.setEmploye(null); 
        
        employeRepository.save(employe);
        disciplineRepository.delete(discipline); 
    }
    
    public Discipline updateDiscipline(Long disciplineId, Discipline updatedDiscipline) {
        Discipline discipline = disciplineRepository.findById(disciplineId)
                .orElseThrow(() -> new RuntimeException("Discipline non trouvée"));
        
        
        discipline.setNom(updatedDiscipline.getNom());
        discipline.setDateDebut(updatedDiscipline.getDateDebut());
        discipline.setDateFin(updatedDiscipline.getDateFin());
        
        return disciplineRepository.save(discipline); // Sauvegarder les modifications
    }
    
    public List<Discipline> getDisciplinesByEmployeId(Long employeId) {
        Employe employe = employeRepository.findById(employeId)
                .orElseThrow(() -> new RuntimeException("Employé non trouvé"));
        
        return employe.getDisciplines(); // Retourner la liste des disciplines
    }
}
