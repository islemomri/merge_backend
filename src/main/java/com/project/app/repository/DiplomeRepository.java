package com.project.app.repository;

import com.project.app.model.Diplome;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DiplomeRepository extends JpaRepository<Diplome, Long> {
	List<Diplome> findByArchiveFalse();
	List<Diplome> findByArchiveTrue();
}