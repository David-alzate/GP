package co.com.park.gp.entity;

import java.util.UUID;

import co.com.park.gp.crosscutting.helpers.ObjectHelper;
import co.com.park.gp.crosscutting.helpers.TextHelper;
import co.com.park.gp.crosscutting.helpers.UUIDHelper;

public final class SedeEntity {

	private UUID id;
	private ParqueaderoEntity parqueadero;
	private String nombre;
	private CiudadEntity ciudad;
	private String direccion;
	private String correoElectronico;
	private int celdasCarro;
	private int celdasMoto;
	private int celdascamion;
	private TipoSedeEntity tipoSede;
	private PaisEntity pais;
	private DepartamentoEntity departamento;

	public SedeEntity() {
		super();
	}

	public SedeEntity(final UUID id, final ParqueaderoEntity parqueadero, final String nombre, final CiudadEntity ciudad,
			final String direccion, final String correoElectronico, final int celdasCarro, final int celdasMoto,
			final int celdascamion, final TipoSedeEntity tipoSede, final PaisEntity pais,
			final DepartamentoEntity departamento) {
		setId(id);
		setParqueadero(parqueadero);
		setNombre(nombre);
		setCiudad(ciudad);
		setDireccion(direccion);
		setCorreoElectronico(correoElectronico);
		setCeldasCarro(celdasCarro);
		setCeldasMoto(celdasMoto);
		setCeldascamion(celdascamion);
		setTipoSede(tipoSede);
		setPais(pais);
		setDepartamento(departamento);
	}

	public final void setId(final UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
	}

	public final void setParqueadero(final ParqueaderoEntity parqueadero) {
		this.parqueadero = ObjectHelper.getObjectHelper().getDefaultValue(parqueadero, new ParqueaderoEntity());
	}

	public final void setNombre(final String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
	}

	public final void setCiudad(final CiudadEntity ciudad) {
		this.ciudad = ObjectHelper.getObjectHelper().getDefaultValue(ciudad, new CiudadEntity());
	}

	public final void setDireccion(final String direccion) {
		this.direccion = TextHelper.applyTrim(direccion);
	}

	public final void setCorreoElectronico(final String correoElectronico) {
		this.correoElectronico = TextHelper.applyTrim(correoElectronico);
	}

	public final void setCeldasCarro(final int celdasCarro) {
		this.celdasCarro = celdasCarro;
	}

	public final void setCeldasMoto(final int celdasMoto) {
		this.celdasMoto = celdasMoto;
	}

	public final void setCeldascamion(final int celdascamion) {
		this.celdascamion = celdascamion;
	}

	public final void setTipoSede(final TipoSedeEntity tipoSede) {
		this.tipoSede = ObjectHelper.getObjectHelper().getDefaultValue(tipoSede, new TipoSedeEntity());
	}

	public final void setPais(final PaisEntity pais) {
		this.pais = ObjectHelper.getObjectHelper().getDefaultValue(pais, new PaisEntity());
	}

	public final void setDepartamento(final DepartamentoEntity departamento) {
		this.departamento = ObjectHelper.getObjectHelper().getDefaultValue(departamento, new DepartamentoEntity());;
	}

	public final UUID getId() {
		return id;
	}

	public final ParqueaderoEntity getParqueadero() {
		return parqueadero;
	}

	public final String getNombre() {
		return nombre;
	}

	public final CiudadEntity getCiudad() {
		return ciudad;
	}

	public final String getDireccion() {
		return direccion;
	}

	public final String getCorreoElectronico() {
		return correoElectronico;
	}

	public final int getCeldasCarro() {
		return celdasCarro;
	}

	public final int getCeldasMoto() {
		return celdasMoto;
	}

	public final int getCeldascamion() {
		return celdascamion;
	}

	public final TipoSedeEntity getTipoSede() {
		return tipoSede;
	}

	public final PaisEntity getPais() {
		return pais;
	}

	public final DepartamentoEntity getDepartamento() {
		return departamento;
	}

}
