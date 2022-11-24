package com.mt.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mt.app.dao.TareaDao;
import com.mt.app.entity.Tarea;

@Service
public class TareaService {
	
	@Autowired
	TareaDao tareaDao;
	
	public List<Tarea> findByEstado(Long estadoId){
		return tareaDao.findByEstadoId(estadoId);
	}
	
	public void deleteById(Long id) {
		tareaDao.deleteById(id);
	}
	
	public Tarea save(Tarea tarea) {
		return tareaDao.save(tarea);
	}

}
