package com.pawpengaga.controller;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.pawpengaga.model.Persona;

@Mapper
public interface PersonaMapper {

  /*
   * MyBatis obtendra los valores exactos de las clases que se le pasen,
   * tendrá siempre en cuenta los atributos Java,
   * por lo que los nombres interpolados deben
   * corresponder siempre con los atributos Java respectivos
   * 
   * Aún a pesar de las ventajas de Mybatis, JPA Hibernate es preferido.
   * 
   * MyBatis no puede ser mezclado con JPA
   */

  @Select("SELECT * FROM persona")
  public List<Persona> findAll();

  @Insert("INSERT INTO persona (nombre, edad) VALUES (#{nombre}, #{edad})")
  @Options(useGeneratedKeys = true, keyProperty = "id") // <- INVESTIGAR
  public void save(Persona p);

  @Delete("DELETE FROM persona WHERE id = #{id}")
  public void eliminar(Long id);

  @Update("UPDATE persona SET nombre = #{nombre}, edad = #{edad} WHERE id = #{id}")
  public void actualizar(Persona p);

}
