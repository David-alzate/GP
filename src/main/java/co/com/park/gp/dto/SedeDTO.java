package co.com.park.gp.dto;

import java.util.UUID;

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

	public SedeDTO(final ParqueaderoDTO parqueadero, final String nombre, final CiudadDTO ciudad,
			final String direccion, final String correoElectronico, final int celdasCarro, final int celdasMoto,
			final int celdascamion, final TipoSedeDTO tipoSede, final PaisDTO pais,
			final DepartamentoDTO departamento) {
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
		this.id = id;
	}

	private final void setParqueadero(final ParqueaderoDTO parqueadero) {
		this.parqueadero = parqueadero;
	}

	private final void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	private final void setCiudad(final CiudadDTO ciudad) {
		this.ciudad = ciudad;
	}

	private final void setDireccion(final String direccion) {
		this.direccion = direccion;
	}

	private final void setCorreoElectronico(final String correoElectronico) {
		this.correoElectronico = correoElectronico;
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
		this.tipoSede = tipoSede;
	}

	private final void setPais(final PaisDTO pais) {
		this.pais = pais;
	}

	private final void setDepartamento(final DepartamentoDTO departamento) {
		this.departamento = departamento;
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
