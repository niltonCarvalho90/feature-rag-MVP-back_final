package responseDTO;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.implant_rag_back.dto.FilialDTO;


@JsonIgnoreProperties(ignoreUnknown = true)
public class FilialResponse {
	private HttpStatus status;
	private List<FilialDTO> filiais;
	
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public List<FilialDTO> getFiliais() {
		return filiais;
	}
	public void setFiliais(List<FilialDTO> filiais) {
		this.filiais = filiais;
	}
	
	public FilialResponse() {
		
	}
	public FilialResponse(HttpStatus status, List<FilialDTO> filiais) {
		this.status = status;
		this.filiais = filiais;
	}
}
