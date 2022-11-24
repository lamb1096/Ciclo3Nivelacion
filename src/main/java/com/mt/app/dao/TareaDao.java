package com.mt.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mt.app.entity.Tarea;

@Repository
public interface TareaDao extends JpaRepository<Tarea, Long> {
	
	List<Tarea> findByEstadoId(Long estadoId);

}
