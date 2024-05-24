package co.com.park.gp.business.assembler.dto.impl;

import co.com.park.gp.business.assembler.dto.AssemblerDTO;
import co.com.park.gp.business.domain.TipoSedeDomain;
import co.com.park.gp.crosscutting.helpers.ObjectHelper;
import co.com.park.gp.dto.TipoSedeDTO;

public class TipoSedeAssemblerDTO implements AssemblerDTO<TipoSedeDomain, TipoSedeDTO> {

	private static final AssemblerDTO<TipoSedeDomain, TipoSedeDTO> instance = new TipoSedeAssemblerDTO();

	private TipoSedeAssemblerDTO() {
		super();
	}

	public static final AssemblerDTO<TipoSedeDomain, TipoSedeDTO> getInstance() {
		return instance;
	}

	@Override
	public TipoSedeDomain toDomain(TipoSedeDTO data) {
		var tipoSedeDtoTmp = ObjectHelper.getObjectHelper().getDefaultValue(data, TipoSedeDTO.build());
		return TipoSedeDomain.build(tipoSedeDtoTmp.getId(), tipoSedeDtoTmp.getNombre());
	}

	@Override
	public TipoSedeDTO toDto(TipoSedeDomain domain) {
		var tipoSedeDomainTmp = ObjectHelper.getObjectHelper().getDefaultValue(domain, TipoSedeDomain.build());
		return TipoSedeDTO.build().setId(tipoSedeDomainTmp.getId()).setNombre(tipoSedeDomainTmp.getNombre());
	}

}
