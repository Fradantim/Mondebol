package com.fradantim.mondebol.resource;

import java.security.Principal;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fradantim.mondebol.service.MondebolService;

@RestController
public class MondebolResource {
	int cantidad=0;
	private static Logger logger = LoggerFactory.getLogger(MondebolResource.class);

	@Autowired
	private MondebolService mondebolService;
	
	@GetMapping("/mondebol")
	public String getRandomMondebol() {
		return mondebolService.getMondebol();
	}
	
	@GetMapping("/mondebol2")
	public String getRandomMondebol2(Principal principal) {
		return "Hola "+principal.getName()+", toma un mondebol: "+ mondebolService.getMondebol();
	}
	
	@Secured("ROL_ESPECIFICO_1")
	@GetMapping("/mondebol3")
	public String getRandomMondebol3(Principal principal) {
		return "Hola "+principal.getName()+", "
				+ "veo que tus roles son "
				+Arrays.toString(SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray())
				+" "
				+ "toma un mondebol: "+ mondebolService.getMondebol();
	}
	
	@Secured("ROL_ESPECIFICO_2")
	@GetMapping("/mondebol4")
	public synchronized String getRandomMondebol4(Principal principal) {
		String result = "Hola "+principal.getName()+"! "
				+"Sos el ingresante numero "+(cantidad++)+". "
				+"toma un mondebol de segunda marca: "+mondebolService.getMondebol()+". ";
		
		logger.info(result);
		return result;
	}
}
