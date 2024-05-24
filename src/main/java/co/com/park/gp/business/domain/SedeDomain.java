package co.com.park.gp.business.domain;

import java.util.UUID;

public class SedeDomain {
	private UUID id;
	private ParqueaderoDomain parqueadero;
	private String nombre;
	private CiudadDomain ciudad;
	private String direccion;
	private String correoElectronico;
	private int celdasCarro;
	private int celdasMoto;
	private int celdascamion;
	private TipoSedeDomain tipoSede;
	private PaisDomain pais;
	private DepartamentoDomain departamento;
	
	public SedeDomain() {
		super();
	}

	public SedeDomain(final UUID id, final ParqueaderoDomain parqueadero,final String nombre, final CiudadDomain ciudad,final String direccion,
			final String correoElectronico,final int celdasCarro,final int celdasMoto, final int celdascamion,final TipoSedeDomain tipoSede,
			final PaisDomain pais, final DepartamentoDomain departamento) {
		this.id = id;
		this.parqueadero = parqueadero;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.correoElectronico = correoElectronico;
		this.celdasCarro = celdasCarro;
		this.celdasMoto = celdasMoto;
		this.celdascamion = celdascamion;
		this.tipoSede = tipoSede;
		this.pais = pais;
		this.departamento = departamento;
	}

	private final UUID getId() {
		return id;
	}

	private final void setId(UUID id) {
		this.id = id;
	}

	private final ParqueaderoDomain getParqueadero() {
		return parqueadero;
	}

	private final void setParqueadero(ParqueaderoDomain parqueadero) {
		this.parqueadero = parqueadero;
	}

	private final String getNombre() {
		return nombre;
	}

	private final void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private final CiudadDomain getCiudad() {
		return ciudad;
	}

	private final void setCiudad(CiudadDomain ciudad) {
		this.ciudad = ciudad;
	}

	private final String getDireccion() {
		return direccion;
	}

	private final void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	private final String getCorreoElectronico() {
		return correoElectronico;
	}

	private final void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	private final int getCeldasCarro() {
		return celdasCarro;
	}

	private final void setCeldasCarro(int celdasCarro) {
		this.celdasCarro = celdasCarro;
	}

	private final int getCeldasMoto() {
		return celdasMoto;
	}

	private final void setCeldasMoto(int celdasMoto) {
		this.celdasMoto = celdasMoto;
	}

	private final int getCeldascamion() {
		return celdascamion;
	}

	private final void setCeldascamion(int celdascamion) {
		this.celdascamion = celdascamion;
	}

	private final TipoSedeDomain getTipoSede() {
		return tipoSede;
	}

	private final void setTipoSede(TipoSedeDomain tipoSede) {
		this.tipoSede = tipoSede;
	}

	private final PaisDomain getPais() {
		return pais;
	}

	private final void setPais(PaisDomain pais) {
		this.pais = pais;
	}

	private final DepartamentoDomain getDepartamento() {
		return departamento;
	}

	private final void setDepartamento(DepartamentoDomain departamento) {
		this.departamento = departamento;
	}



}
