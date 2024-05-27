package co.com.park.gp.business.usecase.impl.sede;

import java.util.UUID;

import co.com.park.gp.business.assembler.entity.impl.CiudadAssemblerEntity;
import co.com.park.gp.business.domain.SedeDomain;
import co.com.park.gp.business.usecase.UseCaseWithoutReturn;
import co.com.park.gp.crosscutting.exceptions.custom.BusinessGPException;
import co.com.park.gp.crosscutting.helpers.ObjectHelper;
import co.com.park.gp.crosscutting.helpers.UUIDHelper;
import co.com.park.gp.data.dao.factory.DAOFactory;
import co.com.park.gp.entity.CiudadEntity;
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

        validarSedeMismoNombreMismaCiudad(data.getNombre(), data.getCiudad().getId());

        // 3. Crear la entidad de sede y guardarla en la base de datos
        var sedeEntity = SedeEntity.build()
                .setId(generarIdentificadorSede())
                .setNombre(data.getNombre())
                .setCiudad(CiudadAssemblerEntity.getInstance().toEntity(data.getCiudad()));
                // Aquí puedes configurar otros atributos de la sede si es necesario
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

    private final void validarSedeMismoNombreMismaCiudad(final String nombreSede, final UUID idCiudad) {
        var sedeEntity = SedeEntity.build()
                .setNombre(nombreSede)
                .setCiudad(CiudadEntity.build().setId(idCiudad));

        var resultados = factory.getSedeDAO().consultar(sedeEntity);

        if (!resultados.isEmpty()) {
            var mensajeUsuario = "Ya existe una sede con el mismo nombre en la misma ciudad.";
            throw new BusinessGPException(mensajeUsuario);
        }
    }
}
