package com.pawpengaga.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pawpengaga.model.Persona;

public interface PersonaRepositorio extends JpaRepository<Persona, Long> {

}
