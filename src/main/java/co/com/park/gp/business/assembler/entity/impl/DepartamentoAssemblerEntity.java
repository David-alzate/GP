package co.com.park.gp.business.assembler.entity.impl;

import co.com.park.gp.business.assembler.entity.AssemblerEntity;
import co.com.park.gp.business.domain.DepartamentoDomain;
import co.com.park.gp.business.domain.PaisDomain;
import co.com.park.gp.crosscutting.helpers.ObjectHelper;
import co.com.park.gp.entity.DepartamentoEntity;
import co.com.park.gp.entity.PaisEntity;

public final class DepartamentoAssemblerEntity implements AssemblerEntity <DepartamentoDomain, DepartamentoEntity> {

	
	private static final AssemblerEntity  <DepartamentoDomain, DepartamentoEntity> instance = 
			new DepartamentoAssemblerEntity();
	private static final AssemblerEntity <PaisDomain, PaisEntity> paisAssembler = PaisAssemblerEntity.getInstance();
	
	private DepartamentoAssemblerEntity() {
		super();
	}

	public static final AssemblerEntity <DepartamentoDomain, DepartamentoEntity> getInstance(){
		return instance;
	}
	
	@Override
	public final DepartamentoDomain toDomain(final DepartamentoEntity data) {
		var departamentoEntityTmp = ObjectHelper.getObjectHelper().getDefaultValue(data, DepartamentoEntity.build());
		var paisDomain = paisAssembler.toDomain(departamentoEntityTmp.getPais());
		return DepartamentoDomain.build(departamentoEntityTmp.getId(),
				departamentoEntityTmp.getNombre(),
				paisDomain);
	}

	@Override
	public final DepartamentoEntity toEntity(final DepartamentoDomain domain) {
		var departamentoDomainTmp = ObjectHelper.getObjectHelper().getDefaultValue(domain, DepartamentoDomain.build());
		var paisEntity = paisAssembler.toEntity(departamentoDomainTmp.getPais());
		return DepartamentoEntity.build().setId(departamentoDomainTmp.getId()).
				setNombre(departamentoDomainTmp.getNombre()).
				setPais(paisEntity);
	}

}