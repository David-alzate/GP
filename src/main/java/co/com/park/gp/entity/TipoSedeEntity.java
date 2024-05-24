package co.com.park.gp.entity;

import java.util.UUID;

import co.com.park.gp.crosscutting.helpers.TextHelper;
import co.com.park.gp.crosscutting.helpers.UUIDHelper;

public final class TipoSedeEntity {

	private UUID id;
	private String nombre;

	public TipoSedeEntity() {
		super();
	}

	public TipoSedeEntity(final UUID id,final String nombre) {
		setId(id);
		setNombre(nombre);
	}
	
	public static final TipoSedeEntity build() {
		return new TipoSedeEntity();
	}

	private final TipoSedeEntity setId(final UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
		return this;
	}

	private final TipoSedeEntity setNombre(final String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
		return this;
	}

	public final UUID getId() {
		return id;
	}

	public final String getNombre() {
		return nombre;
	}

}