package implant_rag_back.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.RestController;

import implant_rag_back.domain.Operadora;
import implant_rag_back.repository.OperadoraRepository;


@RestController
public class GreetingsController {
	
	@Autowired 
	private OperadoraRepository operadoraRepository;
    
    @PostMapping(value = "salvarOperadora") 
    @ResponseBody  
    public ResponseEntity<Operadora> salvar(@RequestBody Operadora operadora){ 
    	
    	Operadora oper = operadoraRepository.save(operadora);
    	return new ResponseEntity<Operadora>(oper, HttpStatus.CREATED);
    	
    }
 
}
