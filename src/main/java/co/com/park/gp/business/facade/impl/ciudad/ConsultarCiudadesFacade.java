package co.com.park.gp.business.facade.impl.ciudad;

import java.util.List;

import co.com.park.gp.business.assembler.dto.impl.CiudadAssemblerDTO;
import co.com.park.gp.business.facade.FacadeWhitReturn;
import co.com.park.gp.business.usecase.impl.ciudad.ConsultarCiudades;
import co.com.park.gp.crosscutting.exceptions.GPException;
import co.com.park.gp.crosscutting.exceptions.custom.BusinessGPException;
import co.com.park.gp.data.dao.factory.DAOFactory;
import co.com.park.gp.dto.CiudadDTO;

public class ConsultarCiudadesFacade implements FacadeWhitReturn<CiudadDTO, List<CiudadDTO>> {

	private DAOFactory daoFactory;

	public ConsultarCiudadesFacade() {
		daoFactory = DAOFactory.getFactory();
	}

	@Override
	public List<CiudadDTO> execute(final CiudadDTO dto) {

		try {
			var usecase = new ConsultarCiudades(daoFactory);
			var ciudadDomain = CiudadAssemblerDTO.getInstance().toDomain(dto);
			var resultadosDomain = usecase.execute(ciudadDomain);
			return CiudadAssemblerDTO.getInstance().toDTOCollection(resultadosDomain);

		} catch (final GPException exception) {
			throw exception;
		} catch (final Exception exception) {

			var mensajeUsuario = "Se ha presentado un problema consultar la informacion de las ciudad";
			var mensajeTecnico = "Se ha presentado un problema INESPERADO tratando de consultar la ciudad";

			throw new BusinessGPException(mensajeTecnico, mensajeUsuario, exception);

		} finally {
			daoFactory.cerrarConexion();
		}
	}



}
