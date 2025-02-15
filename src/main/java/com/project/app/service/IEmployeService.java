package com.project.app.service;

import java.util.List;
import java.util.Optional;

<<<<<<< HEAD
=======
import com.project.app.model.Discipline;
>>>>>>> training_repo/main
import com.project.app.model.Employe;

public interface IEmployeService {
	public List<Employe> getAllEmployes();
	 public Employe addEmploye(Employe employe);
	 public Optional<Employe> getEmployeById(Long id);
	 public void deleteEmploye(Long id) ;
<<<<<<< HEAD
=======
	 public Discipline addDisciplineToEmploye(Long employeId, Discipline discipline);
	 void removeDisciplineFromEmploye(Long employeId, Long disciplineId);
	 Discipline updateDiscipline(Long disciplineId, Discipline updatedDiscipline);
	 List<Discipline> getDisciplinesByEmployeId(Long employeId);
>>>>>>> training_repo/main
}
