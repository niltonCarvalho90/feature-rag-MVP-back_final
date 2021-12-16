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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ResponseDTO.ClienteResponse;
import br.com.implant_rag_back.domain.Cliente;
import br.com.implant_rag_back.dto.ClienteDTO;
import br.com.implant_rag_back.service.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteController {

    
     @Autowired
        private final ClienteService clienteService;
   
     
     @Autowired
        public ClienteController(ClienteService clienteService) {
            this.clienteService = clienteService;
        }

         @PostMapping("/salvar/{nome}") 
         public Integer cadastraNomeValidado(@RequestBody ClienteDTO cliente, @PathVariable String nome) {
             
             return clienteService.validandoNome( cliente, nome);
         }
         
        
         
        @GetMapping("/listar")
         public ResponseEntity<ClienteResponse> listarTodos() {
            
            List<Cliente> listaClientes = clienteService.listarClientes();
            List<ClienteDTO> clientesDTO = new ArrayList<ClienteDTO>();
            for(int cont = 0; cont < listaClientes.size(); cont++) {
                 
                ClienteDTO cliente = new ClienteDTO();
                
                cliente.setCodigo(listaClientes.get(cont).getCodigo());
                cliente.setNomeEmpresa(listaClientes.get(cont).getNomeEmpresa());
                cliente.setStatus(listaClientes.get(cont).getStatus());
                
                clientesDTO.add(cliente);
            }
            
            ClienteResponse clienteResponse = new ClienteResponse();
            clienteResponse.setClientes(clientesDTO);
            clienteResponse.setStatus(HttpStatus.OK);
            
            return new ResponseEntity<ClienteResponse>(clienteResponse, clienteResponse.getStatus());
            
        }

        @GetMapping("/listarPorCod/{codigo}")
        public ResponseEntity<ClienteResponse> listarPorCod(@PathVariable Integer codigo) {
           
           List<Cliente> listaClientes = clienteService.buscarClientePorCod(codigo);
           List<ClienteDTO> clientesDTO = new ArrayList<ClienteDTO>();
           for(int cont = 0; cont < listaClientes.size(); cont++) {
                
               ClienteDTO cliente = new ClienteDTO();
               
               cliente.setCodigo(listaClientes.get(cont).getCodigo());
               cliente.setNomeEmpresa(listaClientes.get(cont).getNomeEmpresa());
               cliente.setStatus(listaClientes.get(cont).getStatus());
               
               clientesDTO.add(cliente);
           }
           
           ClienteResponse clienteResponse = new ClienteResponse();
           clienteResponse.setClientes(clientesDTO);
           clienteResponse.setStatus(HttpStatus.OK);
           
           return new ResponseEntity<ClienteResponse>(clienteResponse, clienteResponse.getStatus());
           
       }
        
        
        
        @DeleteMapping("/deletar/{codigo}")
        public Boolean deletar(@PathVariable Integer codigo) {
            
            return clienteService.deletar(codigo);
            
        }
        
      @PutMapping("/editar")
     public Boolean editar(@RequestBody ClienteDTO cliente) {
     	return this.clienteService.editar(cliente);
      }
}
