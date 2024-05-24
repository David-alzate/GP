package co.com.park.gp.business.assembler.entity.impl;

import co.com.park.gp.business.assembler.entity.AssemblerEntity;
import co.com.park.gp.business.domain.TipoSedeDomain;
import co.com.park.gp.entity.TipoSedeEntity;

public class TipoSedeAssemblerEntity implements AssemblerEntity<TipoSedeDomain, TipoSedeEntity> {

	private static final AssemblerEntity<TipoSedeDomain, TipoSedeEntity> INSTANCE = new TipoSedeAssemblerEntity();

	private TipoSedeAssemblerEntity() {
		super();
	}

	public static AssemblerEntity<TipoSedeDomain, TipoSedeEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public TipoSedeDomain toDomain(TipoSedeEntity data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoSedeEntity toEntity(TipoSedeDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

}
