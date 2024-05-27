package co.com.park.gp.data.dao.entity.concrete.postgresql;

import java.sql.Connection;
import java.util.List;

import co.com.park.gp.data.dao.entity.SedeDAO;
import co.com.park.gp.data.dao.entity.concrete.SqlConnection;
import co.com.park.gp.entity.SedeEntity;

public class SedePostgresqlDAO extends SqlConnection implements SedeDAO{
	
	public SedePostgresqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(SedeEntity data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SedeEntity> consultar(SedeEntity data) {
		// TODO Auto-generated method stub
		return null;
	}

}
