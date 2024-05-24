package co.com.park.gp.business.assembler.entity.impl;

import co.com.park.gp.business.assembler.entity.AssemblerEntity;
import co.com.park.gp.business.domain.CiudadDomain;
import co.com.park.gp.business.domain.DepartamentoDomain;
import co.com.park.gp.entity.CiudadEntity;
import co.com.park.gp.entity.DepartamentoEntity;

public class CiudadAssemblerEntity implements AssemblerEntity <CiudadDomain, CiudadEntity> {
	
	private static final AssemblerEntity <CiudadDomain, CiudadEntity> instance = 
			new CiudadAssemblerEntity();
	
	private static final AssemblerEntity <DepartamentoDomain, DepartamentoEntity> departamentoAssembler 
	= DepartamentoAssemblerEntity.getInstance();
	
	private CiudadAssemblerEntity() {
		super();
	}
	
	public static final AssemblerEntity <CiudadDomain, CiudadEntity> getInstance(){
		return instance;
	}
	

	@Override
	public final CiudadDomain toDomain(final CiudadEntity data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final CiudadEntity toEntity(final CiudadDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}



}

