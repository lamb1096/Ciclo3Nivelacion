package com.mt.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mt.app.entity.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario, Long> {
	
	public Usuario findByUsername(String username);

}
