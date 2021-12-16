package br.com.implant_rag_back.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.implant_rag_back.domain.Cliente;
import br.com.implant_rag_back.dto.ClienteDTO;
import br.com.implant_rag_back.repository.ClienteRepository;

@Service

public class ClienteService {

    @Autowired
   private  ClienteRepository clienteRepository;




    public ClienteRepository getClienteRepository() {
        return clienteRepository;
    }




    public  List<Cliente> buscarClienteCod( int codigo) {

        List<Cliente> lista = clienteRepository.findByCodigo(codigo);

        return lista;
    }
    
    public List<Cliente> buscarClientePorCod(Integer cod){
    	return this.clienteRepository.findByCodigo(cod);
    }

    public int buscarClienteCodString (int codigo) {

            List<Cliente> lista = clienteRepository.findByCodigo(codigo);

            int clienteCod = 0;
            
            for (Cliente x: lista ) {
                clienteCod = x.getCodigo();
            }

            return clienteCod;
        }

    public String buscarClienteNome( String nome) {
        
        List<Cliente> clientes = clienteRepository.findByNomeEmpresa(nome);
        
        String nomeCliente = null;
        
        for (Cliente x: clientes) {
            
            nomeCliente = x.getNomeEmpresa();
            
        }
        return nomeCliente;
    }
    
    public Integer validandoNome(ClienteDTO cliente, String nome) {
        
        String nomeCliente = cliente.getNomeEmpresa();
        String nomeClienteInserido = buscarClienteNome(nome);
        
        Integer validador = null;
        
        if(!nomeCliente.equals(nomeClienteInserido)) {
        	
            clienteRepository.saveAndFlush(cliente.transformaParaObjetoCliente());
            validador =  0;
            
        }else if(nomeCliente.equals(nomeClienteInserido)) {
        	
     
            validador =  1;
        }
        return validador;
    }
    
   
    
    
    
    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }
    
    public Boolean deletar(Integer codigo) {
        
        try {
        	clienteRepository.deleteById(codigo);
            return true;
        }catch(Exception erro) {
        	erro.printStackTrace();
        	return false;
        }
        
       
    }
    
    public Boolean editar(ClienteDTO cliente) {
    	
    	this.clienteRepository.save(cliente.transformaParaObjetoCliente());
    	return true;
    }
    	
    
}
