package co.com.park.gp.business.assembler.entity.impl;

import co.com.park.gp.business.assembler.entity.AssemblerEntity;
import co.com.park.gp.business.domain.ParqueaderoDomain;
import co.com.park.gp.entity.ParqueaderoEntity;

public class ParqueaderoAssemblerEntity implements AssemblerEntity<ParqueaderoDomain, ParqueaderoEntity> {

	private static final AssemblerEntity<ParqueaderoDomain, ParqueaderoEntity> INSTANCE = new ParqueaderoAssemblerEntity();

	private ParqueaderoAssemblerEntity() {
		super();
	}

	public static AssemblerEntity<ParqueaderoDomain, ParqueaderoEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public ParqueaderoDomain toDomain(ParqueaderoEntity data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ParqueaderoEntity toEntity(ParqueaderoDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

}
