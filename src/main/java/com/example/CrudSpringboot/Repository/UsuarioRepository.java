package com.example.CrudSpringboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CrudSpringboot.Model.Usuarios;


public interface UsuarioRepository extends JpaRepository<Usuarios, Long>{

}
