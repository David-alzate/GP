package co.com.park.gp.data.dao.entity.concrete.postgresql;

import java.sql.Connection;
import java.util.List;

import co.com.park.gp.data.dao.entity.ParqueaderoDAO;
import co.com.park.gp.data.dao.entity.concrete.SqlConnection;
import co.com.park.gp.entity.ParqueaderoEntity;

public class ParqueaderoPostgresqlDAO extends SqlConnection implements ParqueaderoDAO{
	
	public ParqueaderoPostgresqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public List<ParqueaderoEntity> consultar(ParqueaderoEntity data) {
		// TODO Auto-generated method stub
		return null;
	}

}
