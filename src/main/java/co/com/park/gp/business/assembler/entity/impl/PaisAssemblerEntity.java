package co.com.park.gp.business.assembler.entity.impl;

import co.com.park.gp.business.assembler.entity.AssemblerEntity;
import co.com.park.gp.business.domain.PaisDomain;
import co.com.park.gp.entity.PaisEntity;

public final class PaisAssemblerEntity implements AssemblerEntity  <PaisDomain, PaisEntity> {
	
	private static final AssemblerEntity <PaisDomain, PaisEntity> instance = 
			new PaisAssemblerEntity();
	
	
	private PaisAssemblerEntity() {
		super();
	}
	
	public static final AssemblerEntity <PaisDomain, PaisEntity> getInstance(){
		return instance;
	}

	@Override
	public final PaisDomain toDomain(final PaisEntity data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final PaisEntity toEntity(final PaisDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

}
