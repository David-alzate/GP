package co.com.park.gp.dto;

import java.util.UUID;

import co.com.park.gp.crosscutting.helpers.ObjectHelper;
import co.com.park.gp.crosscutting.helpers.TextHelper;
import co.com.park.gp.crosscutting.helpers.UUIDHelper;

public final class SedeDTO {

	private UUID id;
	private ParqueaderoDTO parqueadero;
	private String nombre;
	private CiudadDTO ciudad;
	private String direccion;
	private String correoElectronico;
	private int celdasCarro;
	private int celdasMoto;
	private int celdascamion;
	private TipoSedeDTO tipoSede;
	private PaisDTO pais;
	private DepartamentoDTO departamento;

	public SedeDTO() {
		super();
	}

	public SedeDTO(final UUID id, final ParqueaderoDTO parqueadero, final String nombre, final CiudadDTO ciudad,
			final String direccion, final String correoElectronico, final int celdasCarro, final int celdasMoto,
			final int celdascamion, final TipoSedeDTO tipoSede, final PaisDTO pais,
			final DepartamentoDTO departamento) {
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

	private final void setId(final UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
	}

	private final void setParqueadero(final ParqueaderoDTO parqueadero) {
		this.parqueadero = ObjectHelper.getObjectHelper().getDefaultValue(parqueadero, new ParqueaderoDTO());
	}

	private final void setNombre(final String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
	}

	private final void setCiudad(final CiudadDTO ciudad) {
		this.ciudad = ObjectHelper.getObjectHelper().getDefaultValue(ciudad, new CiudadDTO());;
	}

	private final void setDireccion(final String direccion) {
		this.direccion = TextHelper.applyTrim(direccion);
	}

	private final void setCorreoElectronico(final String correoElectronico) {
		this.correoElectronico = TextHelper.applyTrim(correoElectronico);
	}

	private final void setCeldasCarro(final int celdasCarro) {
		this.celdasCarro = celdasCarro;
	}

	private final void setCeldasMoto(final int celdasMoto) {
		this.celdasMoto = celdasMoto;
	}

	private final void setCeldascamion(final int celdascamion) {
		this.celdascamion = celdascamion;
	}

	private final void setTipoSede(final TipoSedeDTO tipoSede) {
		this.tipoSede = ObjectHelper.getObjectHelper().getDefaultValue(tipoSede, new TipoSedeDTO());
	}

	private final void setPais(final PaisDTO pais) {
		this.pais = ObjectHelper.getObjectHelper().getDefaultValue(pais, new PaisDTO());
	}

	private final void setDepartamento(final DepartamentoDTO departamento) {
		this.departamento = ObjectHelper.getObjectHelper().getDefaultValue(departamento, new DepartamentoDTO());;
	}

	public final UUID getId() {
		return id;
	}

	public final ParqueaderoDTO getParqueadero() {
		return parqueadero;
	}

	public final String getNombre() {
		return nombre;
	}

	public final CiudadDTO getCiudad() {
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

	public final TipoSedeDTO getTipoSede() {
		return tipoSede;
	}

	public final PaisDTO getPais() {
		return pais;
	}

	public final DepartamentoDTO getDepartamento() {
		return departamento;
	}

}
