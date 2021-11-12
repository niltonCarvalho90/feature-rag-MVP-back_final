package ResponseDTO;

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
    public List<UsuarioDTO> getOperadoras() {
        return usuarios;
    }
    public void setOperadoras(List<UsuarioDTO> usuarios) {
        this.usuarios = usuarios;
    }

}