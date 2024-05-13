package co.com.park.gp.dto;

import java.util.UUID;

public final class CiudadDTO {

	private UUID id;
	private String nombre;
	private DepartamentoDTO departamento;

	public CiudadDTO() {
		super();
	}

	public CiudadDTO(final String nombre, final DepartamentoDTO departamento) {
		setNombre(nombre);
		setDepartamento(departamento);
	}

	public final void setId(final UUID id) {
		this.id = id;
	}

	private final void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	private final void setDepartamento(final DepartamentoDTO departamento) {
		this.departamento = departamento;
	}

	public final UUID getId() {
		return id;
	}

	public final String getNombre() {
		return nombre;
	}

	public final DepartamentoDTO getDepartamento() {
		return departamento;
	}

}
