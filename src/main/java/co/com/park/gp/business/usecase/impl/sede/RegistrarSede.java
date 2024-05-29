package co.com.park.gp.business.usecase.impl.sede;

import java.util.UUID;

import co.com.park.gp.business.assembler.entity.impl.CiudadAssemblerEntity;
import co.com.park.gp.business.assembler.entity.impl.DepartamentoAssemblerEntity;
import co.com.park.gp.business.assembler.entity.impl.PaisAssemblerEntity;
import co.com.park.gp.business.assembler.entity.impl.ParqueaderoAssemblerEntity;
import co.com.park.gp.business.assembler.entity.impl.TipoSedeAssemblerEntity;
import co.com.park.gp.business.domain.SedeDomain;
import co.com.park.gp.business.usecase.UseCaseWithoutReturn;
import co.com.park.gp.crosscutting.exceptions.custom.BusinessGPException;
import co.com.park.gp.crosscutting.helpers.ObjectHelper;
import co.com.park.gp.crosscutting.helpers.UUIDHelper;
import co.com.park.gp.data.dao.factory.DAOFactory;
import co.com.park.gp.entity.SedeEntity;

public final class RegistrarSede implements UseCaseWithoutReturn<SedeDomain> {

	private DAOFactory factory;

	public RegistrarSede(final DAOFactory factory) {
		if (ObjectHelper.getObjectHelper().isNull(factory)) {
			var mensajeUsuario = "Se ha presentado un problema tratando de llevar un registro de la sede...";
			var mensajeTecnico = "El DAO factory para crear la sede llegó nulo...";
			throw new BusinessGPException(mensajeUsuario, mensajeTecnico);
		}

		this.factory = factory;
	}

	@Override
	public void execute(final SedeDomain data) {

		// Verificar que los datos de la sede sean completos y válidos antes de crearla
		// en el sistema.

		// No debe existir otro sede con el mismo nombre dentro de un mismo parqueadero

		// No puede existir mas de una sede con el mismo correo

		// No puede existir una sede con la misma direccion dentro del mismo parqueadero

		var sedeEntity = SedeEntity.build().setId(generarIdentificadorSede())
				.setParqueadero(ParqueaderoAssemblerEntity.getInstance().toEntity(data.getParqueadero()))
				.setNombre(data.getNombre()).setCiudad(CiudadAssemblerEntity.getInstance().toEntity(data.getCiudad()))
				.setDireccion(data.getDireccion()).setCorreoElectronico(data.getCorreoElectronico())
				.setCeldasCarro(data.getCeldasCarro()).setCeldasMoto(data.getCeldasMoto())
				.setCeldascamion(data.getCeldascamion())
				.setTipoSede(TipoSedeAssemblerEntity.getInstance().toEntity(data.getTipoSede()))
				.setPais(PaisAssemblerEntity.getInstance().toEntity(data.getPais()))
				.setDepartamento(DepartamentoAssemblerEntity.getInstance().toEntity(data.getDepartamento()));

		factory.getSedeDAO().crear(sedeEntity);
	}

	private final UUID generarIdentificadorSede() {
		UUID id = UUIDHelper.generate();
		boolean existeId = true;

		while (existeId) {
			id = UUIDHelper.generate();
			var sedeEntity = SedeEntity.build().setId(id);
			var resultados = factory.getSedeDAO().consultar(sedeEntity);
			existeId = !resultados.isEmpty();
		}
		return id;
	}

}