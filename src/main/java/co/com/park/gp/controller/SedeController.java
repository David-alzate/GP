package co.com.park.gp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.park.gp.business.facade.impl.sede.ConsultarSedeFacade;
import co.com.park.gp.business.facade.impl.sede.RegistrarSedeFacade;
import co.com.park.gp.controller.response.SedeResponse;
import co.com.park.gp.crosscutting.exceptions.GPException;
import co.com.park.gp.dto.SedeDTO;

@RestController
@RequestMapping("/sedes/")
public class SedeController {

	@GetMapping
	public ResponseEntity<SedeResponse> consultar() {

		var httpStatusCode = HttpStatus.ACCEPTED;
		var sedeResponse = new SedeResponse();

		try {
			var sedeDto = SedeDTO.build();
			var facade = new ConsultarSedeFacade();

			sedeResponse.setDatos(facade.execute(sedeDto));
			sedeResponse.getMensajes().add("sedes consultados exitosamente");

		} catch (final GPException excepcion) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			sedeResponse.getMensajes().add(excepcion.getMensajeUsuario());
			excepcion.printStackTrace();
		} catch (final Exception excepcion) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;

			var mensajeUsuario = "se ha presentado un problema tratando de consultar";
			sedeResponse.getMensajes().add(mensajeUsuario);

			excepcion.printStackTrace();
		}

		return new ResponseEntity<>(sedeResponse, httpStatusCode);
	}

	@PostMapping
	public ResponseEntity<SedeResponse> crear(@RequestBody SedeDTO ciudad) {

		var httpStatusCode = HttpStatus.ACCEPTED;
		var ciudadResponse = new SedeResponse();

		try {
			var facade = new RegistrarSedeFacade();
			facade.execute(ciudad);
			ciudadResponse.getMensajes().add("ciudades creada exitosamente");

		} catch (final GPException excepcion) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			ciudadResponse.getMensajes().add(excepcion.getMensajeUsuario());
			excepcion.printStackTrace();
		} catch (final Exception excepcion) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;

			var mensajeUsuario = "se ha presentado un prblema tratando de registar la nueva ciudad";
			ciudadResponse.getMensajes().add(mensajeUsuario);

			excepcion.printStackTrace();
		}

		return new ResponseEntity<>(ciudadResponse, httpStatusCode);

	}

}
