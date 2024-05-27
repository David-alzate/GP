package co.com.park.gp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.park.gp.business.facade.impl.departamento.ConsultarDepartamentosFacade;
import co.com.park.gp.controller.response.DepartamentoResponse;
import co.com.park.gp.crosscutting.exceptions.GPException;
import co.com.park.gp.dto.DepartamentoDTO;

@RestController
@RequestMapping("api/v1/departamentos")
public final class DepartamentoController {
	
	@GetMapping("/dummy")
	public DepartamentoDTO dummy() {
		return DepartamentoDTO.build();
	}

	@GetMapping
	public ResponseEntity<DepartamentoResponse> consultar(){
		
		var httpStatusCode = HttpStatus.ACCEPTED;
		var departamentoResponse = new DepartamentoResponse();
		
		try {
			var departamentoDto = DepartamentoDTO.build();
			var facade = new ConsultarDepartamentosFacade();
			
			departamentoResponse.setDatos(facade.execute(departamentoDto));
			departamentoResponse.getMensajes().add("departamentos consultados exitosamente");
			
		}catch(final GPException excepcion) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			departamentoResponse.getMensajes().add(excepcion.getMensajeUsuario());
			excepcion.printStackTrace();
		}catch(final Exception excepcion) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			
			var mensajeUsuario = "se ha presentado un problema tratando de consultar";
			departamentoResponse.getMensajes().add(mensajeUsuario);
			
			excepcion.printStackTrace();
		}
		
		return new ResponseEntity<>(departamentoResponse,httpStatusCode);
	}
}
