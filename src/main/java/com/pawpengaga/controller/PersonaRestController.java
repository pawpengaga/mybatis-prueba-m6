package com.pawpengaga.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pawpengaga.model.Persona;
import com.pawpengaga.repository.PersonaRepositorio;

@RestController
@RequestMapping("/api")
public class PersonaRestController {

  @Autowired
  PersonaRepositorio pRepo;

  @GetMapping("/listar")
  public List<Persona> getAll(Model model){
    List<Persona> listado = pRepo.findAll();
    // model.addAttribute("personas", listado);
    return listado;
  }

  @GetMapping("/formulario")
  public String formulario(){
    return "formulario";
  }

  @PostMapping("/grabar")
  public Persona addPersona(@RequestBody Persona p){
    Persona saved = pRepo.save(p);
    return saved;
  }

}
