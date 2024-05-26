package co.com.park.gp.business.assembler.entity.impl;

import co.com.park.gp.business.assembler.entity.AssemblerEntity;
import co.com.park.gp.business.domain.CiudadDomain;
import co.com.park.gp.business.domain.DepartamentoDomain;
import co.com.park.gp.crosscutting.helpers.ObjectHelper;
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
		var ciudadEntityTmp = ObjectHelper.getObjectHelper().getDefaultValue(data, CiudadEntity.build());
		var departamentoDomain = departamentoAssembler.toDomain(ciudadEntityTmp.getDepartamento());
		return CiudadDomain.build(ciudadEntityTmp.getId(),ciudadEntityTmp.getNombre(),departamentoDomain);
	}

	@Override
	public final CiudadEntity toEntity(final CiudadDomain domain) {
		var ciudadDomainTmp = ObjectHelper.getObjectHelper().getDefaultValue(domain, CiudadDomain.build());
		var departamentoEntity = departamentoAssembler.toEntity(ciudadDomainTmp.getDepartamento());
		return CiudadEntity.build().setId(ciudadDomainTmp.getId()).
				setNombre(ciudadDomainTmp.getNombre()).
				setDepartamento(departamentoEntity);
	}



}

