package co.com.park.gp.data.dao.entity.concrete.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.com.park.gp.crosscutting.exceptions.custom.DataGPException;
import co.com.park.gp.crosscutting.helpers.UUIDHelper;
import co.com.park.gp.data.dao.entity.SedeDAO;
import co.com.park.gp.data.dao.entity.concrete.SqlConnection;
import co.com.park.gp.entity.CiudadEntity;
import co.com.park.gp.entity.DepartamentoEntity;
import co.com.park.gp.entity.PaisEntity;
import co.com.park.gp.entity.ParqueaderoEntity;
import co.com.park.gp.entity.SedeEntity;
import co.com.park.gp.entity.TipoSedeEntity;

public class SedePostgresqlDAO extends SqlConnection implements SedeDAO {

	public SedePostgresqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(SedeEntity data) {
		final StringBuilder sentenciaSql = new StringBuilder();

		sentenciaSql.append("INSERT INTO Sede (id, nombresede, celdascarro, celdamoto, caldascamion, ");
		sentenciaSql.append("correoelectronico, direccion, ciudad_id, departamento_id, pais_id, ");
		sentenciaSql.append("parqueadero_id, tiposede_id) ");
		sentenciaSql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

		try (final PreparedStatement sentenciaSqlPreparada = getConexion().prepareStatement(sentenciaSql.toString())) {

			sentenciaSqlPreparada.setObject(1, data.getId());
			sentenciaSqlPreparada.setString(2, data.getNombre());
			sentenciaSqlPreparada.setInt(3, data.getCeldasCarro());
			sentenciaSqlPreparada.setInt(4, data.getCeldasMoto());
			sentenciaSqlPreparada.setInt(5, data.getCeldascamion());
			sentenciaSqlPreparada.setString(6, data.getCorreoElectronico());
			sentenciaSqlPreparada.setString(7, data.getDireccion());
			sentenciaSqlPreparada.setObject(8, data.getCiudad().getId());
			sentenciaSqlPreparada.setObject(9, data.getDepartamento().getId());
			sentenciaSqlPreparada.setObject(10, data.getPais().getId());
			sentenciaSqlPreparada.setObject(11, data.getParqueadero().getId());
			sentenciaSqlPreparada.setObject(12, data.getTipoSede().getId());

			sentenciaSqlPreparada.executeUpdate();

		} catch (final SQLException excepcion) {
			var mensajeUsuario = "Se ha presentado un problema tratando de crear la sede. Por favor, contacte al administrador del sistema.";
			var mensajeTecnico = "Se ha presentado una SQLException tratando de realizar el insert de la sede en la tabla \"Sede\" de la base de datos.";
			throw new DataGPException(mensajeUsuario, mensajeTecnico, excepcion);

		} catch (final Exception excepcion) {
			var mensajeUsuario = "Se ha presentado un problema tratando de crear la sede. Por favor, contacte al administrador del sistema.";
			var mensajeTecnico = "Se ha presentado un problema INESPERADO con una excepción de tipo Exception tratando de realizar el insert de la sede en la tabla \"Sede\" de la base de datos.";
			throw new DataGPException(mensajeUsuario, mensajeTecnico, excepcion);
		}
	}

	@Override
	public List<SedeEntity> consultar(SedeEntity data) {
		final StringBuilder sentenciaSql = new StringBuilder();
		sentenciaSql.append("SELECT * FROM sede");

		List<SedeEntity> sedes = new ArrayList<>();

		try (PreparedStatement sentenciaSqlPreparada = getConexion().prepareStatement(sentenciaSql.toString());
				ResultSet resultado = sentenciaSqlPreparada.executeQuery()) {

			while (resultado.next()) {
				SedeEntity sede = new SedeEntity();
				sede.setId(UUIDHelper.convertToUUID(resultado.getString("id")));
				sede.setNombre(resultado.getString("nombresede"));
				sede.setDireccion(resultado.getString("direccion"));
				sede.setCorreoElectronico(resultado.getString("correoelectronico"));
				sede.setCeldasCarro(resultado.getInt("celdascarro"));
				sede.setCeldasMoto(resultado.getInt("celdamoto"));
				sede.setCeldascamion(resultado.getInt("caldascamion"));

				CiudadEntity ciudad = CiudadEntity.build();
				ciudad.setId(UUIDHelper.convertToUUID(resultado.getString("ciudad_id")));
				sede.setCiudad(ciudad);

				DepartamentoEntity departamento = DepartamentoEntity.build();
				departamento.setId(UUIDHelper.convertToUUID(resultado.getString("departamento_id")));
				sede.setDepartamento(departamento);

				PaisEntity pais = PaisEntity.build();
				pais.setId(UUIDHelper.convertToUUID(resultado.getString("pais_id")));
				sede.setPais(pais);

				TipoSedeEntity tipoSede = TipoSedeEntity.build();
				tipoSede.setId(UUIDHelper.convertToUUID(resultado.getString("tiposede_id")));
				sede.setTipoSede(tipoSede);
				
				ParqueaderoEntity parqueadero = ParqueaderoEntity.build();
				parqueadero.setId(UUIDHelper.convertToUUID(resultado.getString("parqueadero_id")));
				sede.setParqueadero(parqueadero);

				sedes.add(sede);
			}

		} catch (SQLException excepcion) {
			var mensajeUsuario = "Se ha presentado un problema tratando de consultar las sedes. Por favor, contacte al administrador del sistema.";
			var mensajeTecnico = "Se ha presentado una SQLException tratando de realizar la consulta de las sedes en la tabla 'Sede' de la base de datos.";
			throw new DataGPException(mensajeUsuario, mensajeTecnico, excepcion);

		} catch (Exception excepcion) {
			var mensajeUsuario = "Se ha presentado un problema tratando de consultar las sedes. Por favor, contacte al administrador del sistema.";
			var mensajeTecnico = "Se ha presentado un problema INESPERADO con una excepción de tipo Exception tratando de realizar la consulta de las sedes en la tabla 'Sede' de la base de datos.";
			throw new DataGPException(mensajeUsuario, mensajeTecnico, excepcion);
		}

		return sedes;
	}

}
