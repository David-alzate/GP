package co.com.park.gp.business.assembler.dto.impl;

import co.com.park.gp.business.assembler.dto.AssemblerDTO;
import co.com.park.gp.business.domain.PaisDomain;
import co.com.park.gp.crosscutting.helpers.ObjectHelper;
import co.com.park.gp.dto.PaisDTO;

public final class PaisAssemblerDTO implements AssemblerDTO<PaisDomain, PaisDTO> {

	private static final AssemblerDTO<PaisDomain, PaisDTO> instance = new PaisAssemblerDTO();

	private PaisAssemblerDTO() {
		super();
	}

	public static final AssemblerDTO<PaisDomain, PaisDTO> getInstance() {
		return instance;
	}

	@Override
	public final PaisDomain toDomain(final PaisDTO data) {
		var paisDtoTmp = ObjectHelper.getObjectHelper().getDefaultValue(data, PaisDTO.build());
		return PaisDomain.build(paisDtoTmp.getId(), paisDtoTmp.getNombre());
	}

	@Override
	public final PaisDTO toDto(final PaisDomain domain) {
		var paisDomainTmp = ObjectHelper.getObjectHelper().getDefaultValue(domain, PaisDomain.build());
		return PaisDTO.build().setId(paisDomainTmp.getId()).setNombre(paisDomainTmp.getNombre());
	}

}