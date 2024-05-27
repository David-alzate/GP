package co.com.park.gp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.park.gp.business.facade.impl.tiposede.ConsultarTipoSedeFacade;
import co.com.park.gp.controller.response.TipoSedeResponse;
import co.com.park.gp.crosscutting.exceptions.GPException;
import co.com.park.gp.dto.TipoSedeDTO;
@RestController
@RequestMapping("api/v1/Tiposede")
public class TipoSedeController {
	
	@GetMapping("/dummy")
	public TipoSedeDTO dummy() {
		return TipoSedeDTO.build();
	}

	@GetMapping
	public ResponseEntity<TipoSedeResponse> consultar(){
		
		var httpStatusCode = HttpStatus.ACCEPTED;
		var tipoSedeResponse = new TipoSedeResponse();
		
		try {
			var tipoSedeDto = TipoSedeDTO.build();
			var facade = new ConsultarTipoSedeFacade();
			
			tipoSedeResponse.setDatos(facade.execute(tipoSedeDto));
			tipoSedeResponse.getMensajes().add("tipoSedes consultadas exitosamente");
			
		}catch(final GPException excepcion) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			tipoSedeResponse.getMensajes().add(excepcion.getMensajeUsuario());
			excepcion.printStackTrace();
		}catch(final Exception excepcion) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			
			var mensajeUsuario = "se ha presentado un problema tratando de consultar";
			tipoSedeResponse.getMensajes().add(mensajeUsuario);
			
			excepcion.printStackTrace();
		}
		
		return new ResponseEntity<>(tipoSedeResponse,httpStatusCode);
	}

}
