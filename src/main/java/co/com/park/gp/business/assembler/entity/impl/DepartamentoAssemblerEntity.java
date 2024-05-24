package co.com.park.gp.business.assembler.entity.impl;

import co.com.park.gp.business.assembler.entity.AssemblerEntity;
import co.com.park.gp.business.domain.DepartamentoDomain;
import co.com.park.gp.business.domain.PaisDomain;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final DepartamentoEntity toEntity(final DepartamentoDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

}