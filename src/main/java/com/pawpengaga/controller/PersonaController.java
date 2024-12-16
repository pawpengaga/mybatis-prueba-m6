package com.pawpengaga.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pawpengaga.model.Persona;
import com.pawpengaga.repository.PersonaRepository;

@Controller
@RequestMapping("/")
public class PersonaController {

  @Autowired
  PersonaRepository pRepo;

  @GetMapping
  public List<Persona> getAll(){
    return pRepo.findAll();
  }

  @PostMapping("/grabar")
  public void addPersona(Persona p){
    pRepo.save(p);
  }


}
