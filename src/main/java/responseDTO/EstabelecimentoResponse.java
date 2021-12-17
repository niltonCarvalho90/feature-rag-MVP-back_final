package responseDTO;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.implant_rag_back.dto.EstabelecimentoDTO;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EstabelecimentoResponse {
	private HttpStatus status;
	private List<EstabelecimentoDTO> ecs;
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public List<EstabelecimentoDTO> getEcs() {
		return ecs;
	}
	public void setEcs(List<EstabelecimentoDTO> ecs) {
		this.ecs = ecs;
	}
	public EstabelecimentoResponse(HttpStatus status, List<EstabelecimentoDTO> ecs) {
		this.status = status;
		this.ecs = ecs;
	}
	
	
}

