package co.com.park.gp.business.assembler.entity.impl;

import co.com.park.gp.business.assembler.entity.AssemblerEntity;
import co.com.park.gp.business.domain.PaisDomain;
import co.com.park.gp.crosscutting.helpers.ObjectHelper;
import co.com.park.gp.entity.PaisEntity;

public final class PaisAssemblerEntity implements AssemblerEntity<PaisDomain, PaisEntity> {

	private static final AssemblerEntity<PaisDomain, PaisEntity> instance = new PaisAssemblerEntity();

	private PaisAssemblerEntity() {
		super();
	}

	public static final AssemblerEntity<PaisDomain, PaisEntity> getInstance() {
		return instance;
	}

	@Override
	public final PaisDomain toDomain(final PaisEntity data) {
		var paisEntityTmp = ObjectHelper.getObjectHelper().getDefaultValue(data, PaisEntity.build());
		return PaisDomain.build(paisEntityTmp.getId(),paisEntityTmp.getNombre());
	}

	@Override
	public final PaisEntity toEntity(final PaisDomain domain) {
		var paisDomainTmp = ObjectHelper.getObjectHelper().getDefaultValue(domain, PaisDomain.build());
		return PaisEntity.build().setId(paisDomainTmp.getId()).setNombre(paisDomainTmp.getNombre());
	}

}
