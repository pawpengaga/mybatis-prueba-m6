package com.pawpengaga.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pawpengaga.model.Persona;
import com.pawpengaga.repository.PersonaRepositorio;
import com.pawpengaga.repository.PersonaRepository;

@Controller
@RequestMapping("/")
public class PersonaController {

  @Autowired
  PersonaRepositorio pRepo;

  @GetMapping("/listar")
  public String getAll(Model model){
    List<Persona> listado = pRepo.findAll();
    model.addAttribute("personas", listado);
    return "listar";
  }

  @GetMapping("/formulario")
  public String formulario(){
    return "formulario";
  }

  @PostMapping("/grabar")
  public String addPersona(Persona p){
    pRepo.save(p);
    return "redirect:/listar";
  }


}
