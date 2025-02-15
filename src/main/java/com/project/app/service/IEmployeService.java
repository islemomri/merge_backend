package com.project.app.service;

import java.util.List;
import java.util.Optional;

import com.project.app.model.Discipline;
import com.project.app.model.Employe;

public interface IEmployeService {
	public List<Employe> getAllEmployes();
	 public Employe addEmploye(Employe employe);
	 public Optional<Employe> getEmployeById(Long id);
	 public void deleteEmploye(Long id) ;
	 public Discipline addDisciplineToEmploye(Long employeId, Discipline discipline);
	 void removeDisciplineFromEmploye(Long employeId, Long disciplineId);
	 Discipline updateDiscipline(Long disciplineId, Discipline updatedDiscipline);
	 List<Discipline> getDisciplinesByEmployeId(Long employeId);
}
