package br.com.implant_rag_back.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ResponseDTO.OperadoraResponse;
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
    public ResponseEntity<OperadoraResponse> listar(){ 

        List<Operadora> oper = operadoraService.listar();
        List<OperadoraDTO> operadoras = new ArrayList<OperadoraDTO>();
        
        int i = 0;
        for(i=0; i<oper.size(); i++) {
            OperadoraDTO op = new OperadoraDTO();
            op.setId(oper.get(i).getId());
            op.setNome(oper.get(i).getNome());
            op.setTermo(oper.get(i).getTermo());
            operadoras.add(op);
        }
        OperadoraResponse response = new OperadoraResponse();
        response.setStatus(HttpStatus.OK);
        response.setOperadoras(operadoras);

        return new ResponseEntity<OperadoraResponse>(response, response.getStatus());

    }
	
	@DeleteMapping(value = "/deletar/{id}")
	@ResponseBody
	public  ResponseEntity<String> remover(@PathVariable Long id) {
		operadoraService.removerOperadora(id);
		
		return new ResponseEntity<String>("Deletado com sucesso", HttpStatus.OK);
	}


}
