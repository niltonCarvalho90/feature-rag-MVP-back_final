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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.implant_rag_back.domain.Filial;
import br.com.implant_rag_back.dto.FilialDTO;
import br.com.implant_rag_back.service.FilialService;
import responseDTO.FilialResponse;

@RestController
@RequestMapping("/filial")
public class FilialController {

	@Autowired
	private FilialService filialService;

	@PostMapping(value = "/cadastrar")
	@ResponseBody
	public ResponseEntity<FilialDTO> cadastrarEmDto(@RequestBody Filial filial) {
		FilialDTO filialdto = new FilialDTO(filialService.cadastrar(filial));

		return new ResponseEntity<FilialDTO>(filialdto, HttpStatus.CREATED);

	}

	@PostMapping(value = "/editar")
	@ResponseBody
	public ResponseEntity<FilialDTO> alterarEmDto(@RequestBody Filial filial) {
		FilialDTO filialdto = new FilialDTO(filialService.alterar(filial));

		return new ResponseEntity<FilialDTO>(filialdto, HttpStatus.OK);
	}

	@DeleteMapping(value = "/remover")
	@ResponseBody
	public ResponseEntity<String> remover(@RequestParam Long id) {
		filialService.remover(id);

		return new ResponseEntity<String>("Deletado com sucesso", HttpStatus.OK);
	}

	@GetMapping(value = "/listar")
	@ResponseBody
	public ResponseEntity<FilialResponse> listar() {

		List<Filial> filiais = filialService.listarDados();
		List<FilialDTO> filiaisDto = new ArrayList<FilialDTO>();
		int i = 0;
		for (i = 0; i < filiais.size(); i++) {
			FilialDTO filial = new FilialDTO();
			filial.setId(filiais.get(i).getId());
			System.out.println(filial.getId());
			filial.setRazaoSocial(filiais.get(i).getRazaoSocial());
			filial.setCnpj(filiais.get(i).getCnpj());
			filial.setApelidoLoja(filiais.get(i).getApelidoLoja());
			filial.setCodErp(filiais.get(i).getCodErp());
			

			filiaisDto.add(filial);
		}
		FilialResponse response = new FilialResponse();
		response.setStatus(HttpStatus.OK);
		response.setFiliais(filiaisDto);

		return new ResponseEntity<FilialResponse>(response, response.getStatus());

	}

	@GetMapping(value = "/listarFiliais/{codigo}")
	@ResponseBody
	public ResponseEntity<FilialResponse> listarFiliaisDoCliente(@PathVariable Integer codigo) {
		List<Filial> filiais = filialService.listarFilialPorCliente(codigo);
		List<FilialDTO> filiaisDto = new ArrayList<FilialDTO>();
		int i = 0;
		for (i = 0; i < filiais.size(); i++) {
			FilialDTO filial = new FilialDTO();
			filial.setId(filiais.get(i).getId());
			System.out.println(filial.getId());
			filial.setRazaoSocial(filiais.get(i).getRazaoSocial());
			filial.setCnpj(filiais.get(i).getCnpj());
			filial.setApelidoLoja(filiais.get(i).getApelidoLoja());
			filial.setCodErp(filiais.get(i).getCodErp());
			

			filiaisDto.add(filial);
		}
		FilialResponse response = new FilialResponse();
		response.setStatus(HttpStatus.OK);
		response.setFiliais(filiaisDto);

		return new ResponseEntity<FilialResponse>(response, response.getStatus());
	}

}
