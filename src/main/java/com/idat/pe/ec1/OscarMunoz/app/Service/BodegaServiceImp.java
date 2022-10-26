package com.idat.pe.ec1.OscarMunoz.app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pe.ec1.OscarMunoz.app.Model.Bodega;
import com.idat.pe.ec1.OscarMunoz.app.Repository.BodegaRepository;

@Service
public class BodegaServiceImp implements BodegaService {
	
	@Autowired
	private BodegaRepository repo;

	@Override
	public void guardar(Bodega bodega) {
		repo.save(bodega);

	}

	@Override
	public void actualizar(Bodega bodega) {
		repo.saveAndFlush(bodega);

	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);

	}

	@Override
	public List<Bodega> listar() {
		return repo.findAll();
	}

	@Override
	public Bodega obtener(Integer id) {
		return repo.findById(id).orElse(null);
	}

}
