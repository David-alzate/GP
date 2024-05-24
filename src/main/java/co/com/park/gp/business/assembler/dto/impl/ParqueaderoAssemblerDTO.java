package co.com.park.gp.business.assembler.dto.impl;

import co.com.park.gp.business.assembler.dto.AssemblerDTO;
import co.com.park.gp.business.domain.ParqueaderoDomain;
import co.com.park.gp.crosscutting.helpers.ObjectHelper;
import co.com.park.gp.dto.ParqueaderoDTO;

public class ParqueaderoAssemblerDTO implements AssemblerDTO<ParqueaderoDomain, ParqueaderoDTO> {

	private static final AssemblerDTO<ParqueaderoDomain, ParqueaderoDTO> instance = new ParqueaderoAssemblerDTO();

	private ParqueaderoAssemblerDTO() {
		super();
	}

	public static final AssemblerDTO<ParqueaderoDomain, ParqueaderoDTO> getInstance() {
		return instance;
	}

	@Override
	public ParqueaderoDomain toDomain(ParqueaderoDTO data) {
		var parqueaderoDtoTmp = ObjectHelper.getObjectHelper().getDefaultValue(data, ParqueaderoDTO.build());
		return ParqueaderoDomain.build(parqueaderoDtoTmp.getId(), parqueaderoDtoTmp.getNombre());
	}

	@Override
	public ParqueaderoDTO toDto(ParqueaderoDomain domain) {
		var parqueaderoDomainTmp = ObjectHelper.getObjectHelper().getDefaultValue(domain, ParqueaderoDomain.build());
		return ParqueaderoDTO.build().setId(parqueaderoDomainTmp.getId()).setNombre(parqueaderoDomainTmp.getNombre());
	}

}
