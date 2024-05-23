package co.com.park.gp.data.dao.factory.concrete;

import java.sql.DriverManager;
import java.sql.SQLException;

import co.com.park.gp.crosscutting.helpers.SQLHelper;
import co.com.park.gp.data.dao.entity.CiudadDAO;
import co.com.park.gp.data.dao.entity.DepartamentoDAO;
import co.com.park.gp.data.dao.entity.PaisDAO;
import co.com.park.gp.data.dao.entity.ParqueaderoDAO;
import co.com.park.gp.data.dao.entity.SedeDAO;
import co.com.park.gp.data.dao.entity.TipoSedeDAO;
import co.com.park.gp.data.dao.entity.concrete.SqlConnection;
import co.com.park.gp.data.dao.entity.concrete.postgresql.CiudadPostgresqlDAO;
import co.com.park.gp.data.dao.entity.concrete.postgresql.DepartamentoPostgresqlDAO;
import co.com.park.gp.data.dao.entity.concrete.postgresql.PaisPostgresqlDAO;
import co.com.park.gp.data.dao.entity.concrete.postgresql.ParqueaderoPostgresqlDAO;
import co.com.park.gp.data.dao.entity.concrete.postgresql.SedePostgresqlDAO;
import co.com.park.gp.data.dao.entity.concrete.postgresql.TipoSedePostgresqlDAO;
import co.com.park.gp.data.dao.factory.DAOFactory;

public class PostgresqlDAOFactory extends SqlConnection implements DAOFactory {

	public PostgresqlDAOFactory() {
		super();
		abrirConexion();
	}

	@Override
	public void abrirConexion() {
		try {
			String conncectionString = "jbc://<server>:<port>...";
			setConexion(DriverManager.getConnection(conncectionString));
		} catch (final SQLException exception) {
			// TODO: handle exception
		} catch (Exception exception) {

		}

	}

	@Override
	public void cerrarConexion() {
		SQLHelper.close(getConexion());
	}

	@Override
	public void iniciarTransaccion() {
		SQLHelper.initTransaction(getConexion());
	}

	@Override
	public void confirmarTransaccion() {
		SQLHelper.commit(getConexion());

	}

	@Override
	public void cancelarTransaccion() {
		SQLHelper.rollback(getConexion());

	}

	@Override
	public PaisDAO getPaisDAO() {
		return new PaisPostgresqlDAO(getConexion());
	}

	@Override
	public DepartamentoDAO getDepartamentoDAO() {
		return new DepartamentoPostgresqlDAO(getConexion());
	}

	@Override
	public CiudadDAO getCiudadDAO() {
		return new CiudadPostgresqlDAO(getConexion());
	}

	@Override
	public ParqueaderoDAO getParqueaderoDAO() {
		return new ParqueaderoPostgresqlDAO(getConexion());
	}

	@Override
	public SedeDAO getSedeDAO() {
		return new SedePostgresqlDAO(getConexion());
	}

	@Override
	public TipoSedeDAO geTipoSedeDAO() {
		return new TipoSedePostgresqlDAO(getConexion());
	}

}
