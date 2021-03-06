package responseDTO;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.implant_rag_back.dto.UsuarioDTO;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioResponse {
	
    private HttpStatus status;
    private List<UsuarioDTO> usuarios;

    public HttpStatus getStatus() {
        return status;
    }
    public void setStatus(HttpStatus status) {
        this.status = status;
    }
    public List<UsuarioDTO> getUsuarios() {
        return usuarios;
    }
    public void setUsuarios(List<UsuarioDTO> usuarios) {
        this.usuarios = usuarios;
    }

}