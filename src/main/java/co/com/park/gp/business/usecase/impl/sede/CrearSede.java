package co.com.park.gp.business.usecase.impl.sede;

import co.com.park.gp.business.domain.SedeDomain;
import co.com.park.gp.business.usecase.UseCaseWithoutReturn;
import co.com.park.gp.crosscutting.exceptions.custom.BusinessGPException;
import co.com.park.gp.crosscutting.helpers.ObjectHelper;
import co.com.park.gp.data.dao.factory.DAOFactory;




public final class CrearSede implements UseCaseWithoutReturn<SedeDomain>{
	
	private DAOFactory factory;
	
	public CrearSede (final DAOFactory factory) {
		if (ObjectHelper.getObjectHelper().isNull(factory)) {
			var mensajeUsuario = "se ha presentado un problema creando la sede";
			var mensajeTecnico = " el DaoFactory para crear la sede llego nulo";
			throw new BusinessGPException(mensajeTecnico, mensajeUsuario);
		}
		this.factory = factory;
}

	@Override
	public void execute(SedeDomain data) {
		// 1) Verificar que los datos de la sede sean completos y válidos antes de crearla en el sistema.
		
		// 2)No debe existir otro sede con el mismo nombre dentro de un mismo parqueadero
		
		// 3)No puede existir mas de una sede con el mismo correo
		
		
		// 4)No puede existir una sede con la misma direccion dentro del mismo parqueadero
		
		
		
		// 5) guardar la nueva sede

		
	}
	

	
	

}
