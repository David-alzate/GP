package co.com.park.gp.business.assembler.entity.impl;

import co.com.park.gp.business.assembler.entity.AssemblerEntity;
import co.com.park.gp.business.domain.ParqueaderoDomain;
import co.com.park.gp.crosscutting.helpers.ObjectHelper;
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
		var parqueaderoEntityTmp = ObjectHelper.getObjectHelper().getDefaultValue(data, ParqueaderoEntity.build());
		return ParqueaderoDomain.build(parqueaderoEntityTmp.getId(),parqueaderoEntityTmp.getNombre());
	}

	@Override
	public ParqueaderoEntity toEntity(ParqueaderoDomain domain) {
		var parqueaderoDomainTmp = ObjectHelper.getObjectHelper().getDefaultValue(domain, ParqueaderoDomain.build());
		return ParqueaderoEntity.build().setId(parqueaderoDomainTmp.getId()).setNombre(parqueaderoDomainTmp.getNombre());
	}

}
