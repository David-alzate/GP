package co.com.park.gp.business.assembler.dto.impl;

import co.com.park.gp.business.assembler.dto.AssemblerDTO;
import co.com.park.gp.business.domain.DepartamentoDomain;
import co.com.park.gp.business.domain.PaisDomain;
import co.com.park.gp.crosscutting.helpers.ObjectHelper;
import co.com.park.gp.dto.DepartamentoDTO;
import co.com.park.gp.dto.PaisDTO;

public final class DepartamentoAssemblerDTO implements AssemblerDTO <DepartamentoDomain, DepartamentoDTO> {

	private static final AssemblerDTO <PaisDomain, PaisDTO> paisAssembler
		= PaisAssemblerDTO.getInstance();
	
	private static final AssemblerDTO<DepartamentoDomain, DepartamentoDTO> instance 
	= new DepartamentoAssemblerDTO();
	
	private DepartamentoAssemblerDTO() {
		super();
	}

	public static final AssemblerDTO<DepartamentoDomain, DepartamentoDTO> getInstance(){
		return instance;
	}
	
	@Override
	public DepartamentoDomain toDomain(final DepartamentoDTO data) {
		var departamentoDtoTmp = ObjectHelper.getObjectHelper().getDefaultValue(data, DepartamentoDTO.build());
		var paisDomain = paisAssembler.toDomain(departamentoDtoTmp.getPais());
		return DepartamentoDomain.build(
				departamentoDtoTmp.getId(),
				departamentoDtoTmp.getNombre(),
				paisDomain);
	}

	@Override
	public DepartamentoDTO toDto(DepartamentoDomain domain) {
		var departamentoDomainTmp = ObjectHelper.getObjectHelper().getDefaultValue(domain, DepartamentoDomain.build());
		var paisDto = paisAssembler.toDto(departamentoDomainTmp.getPais());
		return DepartamentoDTO.build()
				.setId(departamentoDomainTmp.getId())
				.setNombre(departamentoDomainTmp.getNombre())
				.setPais(paisDto);
	}
	

}