package com.idat.pe.ec1.OscarMunoz.app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pe.ec1.OscarMunoz.app.Model.Usuario;
import com.idat.pe.ec1.OscarMunoz.app.Repository.UsuarioRepository;

@Service
public class UsuarioServiceImp implements UsuarioService {
	
	@Autowired
	private UsuarioRepository repo;
	
	@Override
	public void guardar(Usuario usuario) {
		repo.save(usuario);

	}

	@Override
	public void actualizar(Usuario usuario) {
        repo.saveAndFlush(usuario);

	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public List<Usuario> listar() {
		return repo.findAll();
	}

	@Override
	public Usuario obtener(Integer id) {
		return repo.findById(id).orElse(null);
	}

}
