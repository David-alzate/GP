package co.com.park.gp.data.dao.entity.concrete.postgresql;

import java.sql.Connection;
import java.util.List;

import co.com.park.gp.data.dao.entity.DepartamentoDAO;
import co.com.park.gp.data.dao.entity.concrete.SqlConnection;
import co.com.park.gp.entity.DepartamentoEntity;

public class DepartamentoPostgresqlDAO extends SqlConnection implements DepartamentoDAO{
	
	public DepartamentoPostgresqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public List<DepartamentoEntity> consultar(DepartamentoEntity data) {
		// TODO Auto-generated method stub
		return null;
	}

}
