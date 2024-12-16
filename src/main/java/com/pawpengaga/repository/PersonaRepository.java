package com.pawpengaga.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pawpengaga.model.Persona;

@Repository
public class PersonaRepository {

  // En JDBC los repositorios si son clases y no interfaces

  @Autowired
  JdbcTemplate jdbc;

  public List<Persona> findAll(){
    String sql = "SELECT * FROM persona";
    return jdbc.query(sql, (rs, rowNum) -> {
      Persona p = new Persona();
      p.setId(rs.getLong("id"));
      p.setNombre(rs.getString("nombre"));
      p.setEdad(rs.getInt("edad"));
      return p;
    });
  }

  public int save(Persona p){
    String sql = "INSERT INTO persona (nombre, edad) VALUES (?,?)";
    return jdbc.update(sql, p.getNombre(), p.getEdad());
  }

}
