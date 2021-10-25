package br.com.implant_rag_back.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.implant_rag_back.domain.Operadora;
import br.com.implant_rag_back.dto.OperadoraDTO;
import br.com.implant_rag_back.service.OperadoraService;


@RestController
@RequestMapping(value = "/operadora")
public class OperadoraController {
	
	private final OperadoraService operadoraService;
	
	@Autowired 
	private OperadoraController(OperadoraService operadoraService) {
		this.operadoraService = operadoraService;
	}
    
    @PostMapping(value = "/salvar") 
    public ResponseEntity<OperadoraDTO> salvar(@RequestBody Operadora operadora){ 
    	
    	Operadora oper = operadoraService.salvar(OperadoraDTO.transformaParaObjeto);
    	return new ResponseEntity<>(OperadoraRespostaDTO.transformaEmDTO(operadora), HttpStatus.CREATED);
    	
    }
    
    
 
}
