package com.project.app.model;

import java.time.LocalDate;
<<<<<<< HEAD

import jakarta.persistence.Column;
=======
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
>>>>>>> training_repo/main
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
<<<<<<< HEAD
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
=======
import jakarta.persistence.OneToMany;
>>>>>>> training_repo/main
import lombok.Data;
@Data
@Entity
public class Employe {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String nom;
	    private String prenom;
<<<<<<< HEAD
	  
	   
	    private Integer matricule;

	
=======
	    private Integer matricule;
>>>>>>> training_repo/main
	    private LocalDate dateNaissance;
	    private LocalDate dateRecrutement;
	    private String sexe;
	    private String email;
	    private String lieuNaissance;
	    private String codeQualification;
	    private String descriptionQualification;
	    private String departement;
	    private String poste;
	    private String photo;
	    
<<<<<<< HEAD
	   
		 
=======
	    @OneToMany(mappedBy = "employe", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<Discipline> disciplines = new ArrayList<>();
		
	    
	
>>>>>>> training_repo/main
}
