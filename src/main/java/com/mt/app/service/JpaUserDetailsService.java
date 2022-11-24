package com.mt.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mt.app.dao.IUsuarioDao;
import com.mt.app.entity.Rol;
import com.mt.app.entity.Usuario;

@Service
public class JpaUserDetailsService implements UserDetailsService {

	@Autowired
	private IUsuarioDao usuarioDao;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioDao.findByUsername(username);

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuario o contraseña incorrecto");
		}

		for (Rol role : usuario.getRoles()) {

			authorities.add(new SimpleGrantedAuthority(role.getAuthority()));

		}

		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnable(), true, true, true,
				authorities);
	}

}
