package br.com.implant_rag_back.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.implant_rag_back.domain.Estabelecimento;
import br.com.implant_rag_back.domain.Filial;
import br.com.implant_rag_back.dto.EstabelecimentoDTO;
import br.com.implant_rag_back.service.EstabelecimentoService;
import responseDTO.EstabelecimentoResponse;

@RestController
@RequestMapping("/estabelecimento")
public class EstabelecimentoController {
	@Autowired
	private EstabelecimentoService estabelecimentoService;

	@PostMapping(value = "/cadastrar")
	@ResponseBody
	public ResponseEntity<EstabelecimentoDTO> salvarCodFilialOperadora(@RequestBody Estabelecimento estabelecimento) {
		EstabelecimentoDTO estabelecimentoDto = new EstabelecimentoDTO(this.estabelecimentoService.salvar(estabelecimento));
		
		return new ResponseEntity<EstabelecimentoDTO>(estabelecimentoDto, HttpStatus.CREATED);

	}

	@GetMapping(value = "/listar")
	@ResponseBody
	public ResponseEntity<EstabelecimentoResponse> listar() {
		List<Estabelecimento> lista = estabelecimentoService.listar();
		//System.out.println("CODIGO EST" + lista.get(0).getCodFilialOperadora());
		
		List<EstabelecimentoDTO> listaDto = new ArrayList<EstabelecimentoDTO>();
		
		for(int i = 0; i<lista.size(); i++) {
			EstabelecimentoDTO estabelecimento = new EstabelecimentoDTO();
			estabelecimento.setCodFilialOperadora(lista.get(i).getCodFilialOperadora());
			estabelecimento.setFilial(lista.get(i).getFilial());
			estabelecimento.setOperadora(lista.get(i).getOperadora());
			
			listaDto.add(estabelecimento);
		}
		
		EstabelecimentoResponse response = new EstabelecimentoResponse(HttpStatus.OK, listaDto);
		//System.out.println("codigo fop" + listaDto.get(0).getCodFilialOperadora());
		return new ResponseEntity<EstabelecimentoResponse>(response, response.getStatus());

		
	}
	
	@GetMapping(value = "/listarEstabelecimentoComIdFilial/{filial}")
	@ResponseBody
	public ResponseEntity<EstabelecimentoResponse> listarFiliaisDoCliente(@RequestBody Filial filial) {
		List<Estabelecimento> lista = estabelecimentoService.listarOperadoraDoCliente(filial);
		List<EstabelecimentoDTO> listaDto = new ArrayList<EstabelecimentoDTO>();
		for(int i = 0; i<lista.size(); i++) {
			EstabelecimentoDTO estabelecimento = new EstabelecimentoDTO();
			estabelecimento.setCodFilialOperadora(lista.get(i).getCodFilialOperadora());
			estabelecimento.setFilial(lista.get(i).getFilial());
			estabelecimento.setOperadora(lista.get(i).getOperadora());
			
			listaDto.add(estabelecimento);
		}
		
		EstabelecimentoResponse response = new EstabelecimentoResponse(HttpStatus.OK, listaDto);
		
		return new ResponseEntity<EstabelecimentoResponse>(response, response.getStatus());

		/*
		 * List<EstabelecimentoDTO> listaDto = lista.stream().map(obj -> new
		 * EstabelecimentoDTO(obj)).collect(Collectors.toList()); return
		 * ResponseEntity.ok().body(listaDto);
		 */
	}


}
