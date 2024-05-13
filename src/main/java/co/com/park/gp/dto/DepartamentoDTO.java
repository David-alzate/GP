package co.com.park.gp.dto;

import java.util.UUID;

public final class DepartamentoDTO {

	private UUID id;
	private String nombre;
	private PaisDTO pais;

	public DepartamentoDTO() {
		super();
	}

	public DepartamentoDTO(final String nombre, final PaisDTO pais) {
		setNombre(nombre);
		setPais(pais);
	}

	public final void setId(final UUID id) {
		this.id = id;
	}

	private final void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	private final void setPais(final PaisDTO pais) {
		this.pais = pais;
	}

	public final UUID getId() {
		return id;
	}

	public final String getNombre() {
		return nombre;
	}

	public final PaisDTO getPais() {
		return pais;
	}

}
