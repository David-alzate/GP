package co.com.park.gp.business.assembler.entity.impl;

import co.com.park.gp.business.assembler.entity.AssemblerEntity;
import co.com.park.gp.business.domain.CiudadDomain;
import co.com.park.gp.business.domain.DepartamentoDomain;
import co.com.park.gp.business.domain.PaisDomain;
import co.com.park.gp.business.domain.ParqueaderoDomain;
import co.com.park.gp.business.domain.SedeDomain;
import co.com.park.gp.business.domain.TipoSedeDomain;
import co.com.park.gp.entity.CiudadEntity;
import co.com.park.gp.entity.DepartamentoEntity;
import co.com.park.gp.entity.PaisEntity;
import co.com.park.gp.entity.ParqueaderoEntity;
import co.com.park.gp.entity.SedeEntity;
import co.com.park.gp.entity.TipoSedeEntity;

public class SedeAssemblerEntity implements AssemblerEntity<SedeDomain, SedeEntity> {

	private static final AssemblerEntity<ParqueaderoDomain, ParqueaderoEntity> parqueaderoAssembler = ParqueaderoAssemblerEntity
			.getInstance();
	private static final AssemblerEntity<CiudadDomain, CiudadEntity> ciudadAssembler = CiudadAssemblerEntity
			.getInstance();
	private static final AssemblerEntity<TipoSedeDomain, TipoSedeEntity> tipoSedeAssembler = TipoSedeAssemblerEntity
			.getInstance();
	private static final AssemblerEntity<PaisDomain, PaisEntity> paisAssembler = PaisAssemblerEntity.getInstance();
	private static final AssemblerEntity<DepartamentoDomain, DepartamentoEntity> departamentoAssembler = DepartamentoAssemblerEntity
			.getInstance();

	private static final AssemblerEntity<SedeDomain, SedeEntity> INSTANCE = new SedeAssemblerEntity();

	private SedeAssemblerEntity() {
		super();
	}

	public static AssemblerEntity<SedeDomain, SedeEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public SedeDomain toDomain(SedeEntity data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SedeEntity toEntity(SedeDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

}
