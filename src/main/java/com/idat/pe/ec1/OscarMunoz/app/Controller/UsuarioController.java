package com.idat.pe.ec1.OscarMunoz.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.idat.pe.ec1.OscarMunoz.app.Dto.UsuarioDTORequest;
import com.idat.pe.ec1.OscarMunoz.app.Dto.UsuarioDTOResponse;
import com.idat.pe.ec1.OscarMunoz.app.Security.TokenUtil;
import com.idat.pe.ec1.OscarMunoz.app.Security.UserDetailsService;


@RestController
public class UsuarioController {
	
	@Autowired
	private TokenUtil util;
	
	@Autowired
	private UserDetailsService service;
	
    @RequestMapping(path = "/crearToken", method = RequestMethod.POST)
    public ResponseEntity<?> crearToken(@RequestBody UsuarioDTORequest request) {
    	
    	UserDetails user = service.loadUserByUsername(request.getUsuario());
    	if(user.getPassword().equals(request.getPassword()))
    		return ResponseEntity.ok(new UsuarioDTOResponse(util.generateToken(user.getUsername())));
    	else
    		throw new UsernameNotFoundException("No valido");
    }
	
}
