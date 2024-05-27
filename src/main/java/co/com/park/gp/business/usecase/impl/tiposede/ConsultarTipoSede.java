package co.com.park.gp.business.usecase.impl.tiposede;

import java.util.List;

import co.com.park.gp.business.assembler.entity.impl.TipoSedeAssemblerEntity;
import co.com.park.gp.business.domain.TipoSedeDomain;
import co.com.park.gp.business.usecase.UseCaseWithReturn;
import co.com.park.gp.crosscutting.exceptions.custom.BusinessGPException;
import co.com.park.gp.crosscutting.helpers.ObjectHelper;
import co.com.park.gp.data.dao.factory.DAOFactory;

public class ConsultarTipoSede implements UseCaseWithReturn<TipoSedeDomain, List<TipoSedeDomain>> {

    private DAOFactory factory;

    public ConsultarTipoSede(final DAOFactory factory) {
        if(ObjectHelper.getObjectHelper().isNull(factory)) {
            var mensajeUsuario = "Se ha presentado un problema tratando de llevar a cabo la consulta de los tipos de sede...";
            var mensajeTecnico = "El dao factory para consultar el tipo de sede llegó nulo...";
            throw new BusinessGPException(mensajeUsuario, mensajeTecnico);
        }
        
        this.factory = factory;
    }

    @Override
    public List<TipoSedeDomain> execute(final TipoSedeDomain data) {
        var tipoSedeEntityFilter = 
                TipoSedeAssemblerEntity.getInstance().toEntity(data);
        var resultadosEntity = factory.getTipoSedeDAO().consultar(tipoSedeEntityFilter);
        
        return TipoSedeAssemblerEntity.getInstance().
                toDomainCollection(resultadosEntity);
    }
}

