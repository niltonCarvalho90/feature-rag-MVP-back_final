package br.com.implant_rag_back.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

	@PostMapping("/salvar")
	public ResponseEntity<Operadora> salvarOperadoraValidando(@RequestBody OperadoraDTO operadora) {

		Operadora nomeValidado = operadoraService.salvarValidando(operadora.transformaParaObjeto());
		return new ResponseEntity<Operadora>(nomeValidado, HttpStatus.CREATED);
	}

	@GetMapping(value = "/listar")
	public ResponseEntity<List<Operadora>> listar() {

		List<Operadora> oper = operadoraService.listar();
		return new ResponseEntity<List<Operadora>>(oper, HttpStatus.OK);

	}

}
