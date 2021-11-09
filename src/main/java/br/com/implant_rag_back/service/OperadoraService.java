package br.com.implant_rag_back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.implant_rag_back.domain.Operadora;
import br.com.implant_rag_back.repository.OperadoraRepository;

@Service
public class OperadoraService {

	private final OperadoraRepository operadoraRepository;

	@Autowired
		public OperadoraService(OperadoraRepository operadoraRepository) {
		this.operadoraRepository = operadoraRepository;
	}
	
//	public String buscarOperadoraValidando (String nome) {
//
//        List<Operadora> lista = operadoraRepository.buscarOperadoraNome(nome);
//
//           String nomeOperadora = null;
//           for (Operadora x: lista ) {
//
//               nomeOperadora = x.getNome();
//           }
//
//           return nomeOperadora;
//       }
//
//	public Operadora salvar(Operadora operadora, String nome) {
//		  String busca = buscarOperadoraValidando(nome);
//	        String nomeInserido = operadora.getNome();
//	        
//	        if (busca.equals(nomeInserido)) {
//	        	System.out.println("Operadora já cadastrada");
//
//	            return null;
//
//
//
//	        } else  {
//	        	System.out.println("INSERIDO");
//	            this.operadoraRepository.save(operadora);
//	        	
//	        }
//
//	        return null;
//	    }
	

	public List<Operadora> listar() {
		return operadoraRepository.findAll();
	}

	public Operadora salvarValidando(Operadora operadoraNome) {

		List<Operadora> listaNome = operadoraRepository.findAll();
		int cont = 0;
		for (Operadora y : listaNome) {
			boolean x = operadoraNome.getNome().equalsIgnoreCase(y.getNome());

			if (x == true) {
				cont++;
				return null;
			}
		}

			if (cont == 0) {
				operadoraRepository.save(operadoraNome);
			}
		return operadoraNome;
	}
}
