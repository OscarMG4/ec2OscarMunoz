package com.idat.pe.ec1.OscarMunoz.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.pe.ec1.OscarMunoz.app.Model.Bodega;
import com.idat.pe.ec1.OscarMunoz.app.Model.Cliente;
import com.idat.pe.ec1.OscarMunoz.app.Service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
    @RequestMapping(path = "/listar", method = RequestMethod.GET)
    public ResponseEntity<List<Cliente>> obtenerProductos() {
        return new ResponseEntity<List<Cliente>>(service.listar(), HttpStatus.OK);
    }
    
    
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cliente> buscarProducto(@PathVariable Integer id) {
    	Cliente cliente = service.obtener(id);

        if (cliente != null) {
            return new ResponseEntity<Cliente>(service.obtener(id), HttpStatus.OK);
        }

        return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
    }
    
    @RequestMapping(path = "/guardar", method = RequestMethod.POST)
    public ResponseEntity<Void> guardar(@RequestBody Cliente cliente) {
        if (cliente != null) {
            service.guardar(cliente);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }

        return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
    }
    
    @RequestMapping(path = "/editar", method = RequestMethod.PUT)
    public ResponseEntity<Void> actualizar(@RequestBody Cliente cliente) {
        Cliente clienteId = service.obtener(cliente.getIdCliente());

        if (cliente != null) {
            service.actualizar(cliente);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        Cliente cliente = service.obtener(id);
        
        if (cliente != null) {
            service.eliminar(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
    
}
