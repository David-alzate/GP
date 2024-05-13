package co.com.park.gp.dto;

import java.util.UUID;

public final class TipoSedeDTO {

	private UUID id;
	private String nombre;

	public TipoSedeDTO() {
		super();
	}

	public TipoSedeDTO(final String nombre) {
		setNombre(nombre);
	}

	public final void setId(final UUID id) {
		this.id = id;
	}

	private final void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public final UUID getId() {
		return id;
	}

	public final String getNombre() {
		return nombre;
	}

}
