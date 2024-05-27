package co.com.park.gp.business.facade.impl.departamento;

import java.util.List;

import co.com.park.gp.business.assembler.dto.impl.DepartamentoAssemblerDTO;
import co.com.park.gp.business.facade.FacadeWhitReturn;
import co.com.park.gp.business.usecase.impl.departamento.ConsultarDepartamentos;
import co.com.park.gp.crosscutting.exceptions.GPException;
import co.com.park.gp.crosscutting.exceptions.custom.BusinessGPException;
import co.com.park.gp.data.dao.factory.DAOFactory;
import co.com.park.gp.dto.DepartamentoDTO;

public class ConsultarDepartamentosFacade implements FacadeWhitReturn<DepartamentoDTO, List<DepartamentoDTO>> {

    private DAOFactory daoFactory;

    public ConsultarDepartamentosFacade() {
        daoFactory = DAOFactory.getFactory();
    }

    @Override
    public List<DepartamentoDTO> execute(final DepartamentoDTO dto) {
        try {
            var usecase = new ConsultarDepartamentos(daoFactory);
            var departamentoDomain = DepartamentoAssemblerDTO.getInstance().toDomain(dto);
            var resultadosDomain = usecase.execute(departamentoDomain);
            return DepartamentoAssemblerDTO.getInstance().toDTOCollection(resultadosDomain);

        } catch (final GPException exception) {
            throw exception;
        } catch (final Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema al consultar la información del departamento";
            var mensajeTecnico = "Se ha presentado un problema INESPERADO tratando de consultar el departamento";
            throw new BusinessGPException(mensajeTecnico, mensajeUsuario, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }
}
