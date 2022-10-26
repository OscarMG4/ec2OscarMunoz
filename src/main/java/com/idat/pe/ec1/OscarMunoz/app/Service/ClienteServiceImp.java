package com.idat.pe.ec1.OscarMunoz.app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pe.ec1.OscarMunoz.app.Model.Cliente;
import com.idat.pe.ec1.OscarMunoz.app.Repository.ClienteRepository;

@Service
public class ClienteServiceImp implements ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	@Override
	public void guardar(Cliente cliente) {
		repo.save(cliente);

	}

	@Override
	public void actualizar(Cliente cliente) {
		repo.saveAndFlush(cliente);

	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);

	}

	@Override
	public List<Cliente> listar() {
		return repo.findAll();
	}

	@Override
	public Cliente obtener(Integer id) {
		return repo.findById(id).orElse(null);
	}

}
