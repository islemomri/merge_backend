package com.project.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.app.model.Poste;


@Repository
public interface PosteRepository extends JpaRepository<Poste, Long>{

}
