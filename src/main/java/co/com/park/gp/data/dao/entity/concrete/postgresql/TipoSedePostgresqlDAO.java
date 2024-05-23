package co.com.park.gp.data.dao.entity.concrete.postgresql;

import java.sql.Connection;
import java.util.List;

import co.com.park.gp.data.dao.entity.TipoSedeDAO;
import co.com.park.gp.data.dao.entity.concrete.SqlConnection;
import co.com.park.gp.entity.TipoSedeEntity;

public class TipoSedePostgresqlDAO extends SqlConnection implements TipoSedeDAO{
	
	public TipoSedePostgresqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public List<TipoSedeEntity> consultar(TipoSedeEntity data) {
		// TODO Auto-generated method stub
		return null;
	}

}
