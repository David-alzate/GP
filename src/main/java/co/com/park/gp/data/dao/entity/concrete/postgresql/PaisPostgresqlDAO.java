package co.com.park.gp.data.dao.entity.concrete.postgresql;

import java.sql.Connection;
import java.util.List;

import co.com.park.gp.data.dao.entity.PaisDAO;
import co.com.park.gp.data.dao.entity.concrete.SqlConnection;
import co.com.park.gp.entity.PaisEntity;

public class PaisPostgresqlDAO extends SqlConnection implements PaisDAO{
	
	public PaisPostgresqlDAO(final Connection conexion) {
		super(conexion);
	}
	
	@Override
	public List<PaisEntity> consultar(PaisEntity data) {
		// TODO Auto-generated method stub
		return null;
	}

}
