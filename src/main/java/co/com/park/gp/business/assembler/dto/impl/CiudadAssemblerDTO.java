package co.com.park.gp.business.assembler.dto.impl;

import co.com.park.gp.business.assembler.dto.AssemblerDTO;
import co.com.park.gp.business.domain.CiudadDomain;
import co.com.park.gp.business.domain.DepartamentoDomain;
import co.com.park.gp.crosscutting.helpers.ObjectHelper;
import co.com.park.gp.dto.CiudadDTO;
import co.com.park.gp.dto.DepartamentoDTO;

public final class CiudadAssemblerDTO implements AssemblerDTO <CiudadDomain, CiudadDTO> {
	
	
	private static final AssemblerDTO<CiudadDomain, CiudadDTO> instance = 
			new CiudadAssemblerDTO();
		
	private CiudadAssemblerDTO() {
		super();
	}

	public static final AssemblerDTO<CiudadDomain, CiudadDTO> getInstance(){
		return instance;
	}
	
	
	private static final AssemblerDTO<DepartamentoDomain, DepartamentoDTO> departamentoAssembler
	= DepartamentoAssemblerDTO.getInstance();
	
	@Override
	public CiudadDomain toDomain(CiudadDTO data) {
		var ciudadDtoTmp = ObjectHelper.getObjectHelper().getDefaultValue(data, CiudadDTO.build());
		var departamentoDomain = departamentoAssembler.toDomain(ciudadDtoTmp.getDepartamento());
		return CiudadDomain.build(ciudadDtoTmp.getId(), ciudadDtoTmp.getNombre(), departamentoDomain);
	}

	@Override
	public CiudadDTO toDto(CiudadDomain domain) {
		var ciudadDomainTmp = ObjectHelper.getObjectHelper().getDefaultValue(domain, CiudadDomain.build());
		var departamentoDTO = departamentoAssembler.toDto(ciudadDomainTmp.getDepartamento());
		return CiudadDTO.build().setId(ciudadDomainTmp.getId()).setNombre(ciudadDomainTmp.getNombre()).setDepartamento(departamentoDTO);
	}

}