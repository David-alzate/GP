package co.com.park.gp.business.assembler.entity.impl;

import co.com.park.gp.business.assembler.entity.AssemblerEntity;
import co.com.park.gp.business.domain.CiudadDomain;
import co.com.park.gp.business.domain.DepartamentoDomain;
import co.com.park.gp.business.domain.PaisDomain;
import co.com.park.gp.business.domain.ParqueaderoDomain;
import co.com.park.gp.business.domain.SedeDomain;
import co.com.park.gp.business.domain.TipoSedeDomain;
import co.com.park.gp.crosscutting.helpers.ObjectHelper;
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
		var sedeEntityTmp = ObjectHelper.getObjectHelper().getDefaultValue(data, SedeEntity.build());
		var parqueaderoDomain = parqueaderoAssembler.toDomain(sedeEntityTmp.getParqueadero());
		var ciudadDomain = ciudadAssembler.toDomain(sedeEntityTmp.getCiudad());
		var tipoSedeDomain = tipoSedeAssembler.toDomain(sedeEntityTmp.getTipoSede());
		var paisDomain = paisAssembler.toDomain(sedeEntityTmp.getPais());
		var departamentoDomain = departamentoAssembler.toDomain(sedeEntityTmp.getDepartamento());
		return SedeDomain.build(sedeEntityTmp.getId(), parqueaderoDomain, sedeEntityTmp.getNombre(), ciudadDomain,
				sedeEntityTmp.getDireccion(), sedeEntityTmp.getCorreoElectronico(), sedeEntityTmp.getCeldasCarro(),
				sedeEntityTmp.getCeldasMoto(), sedeEntityTmp.getCeldascamion(), tipoSedeDomain, paisDomain,
				departamentoDomain);
	}

	@Override
	public SedeEntity toEntity(SedeDomain domain) {
		var sedeDomainTmp = ObjectHelper.getObjectHelper().getDefaultValue(domain, SedeDomain.build());
		var parqueaderoEntity = parqueaderoAssembler.toEntity(sedeDomainTmp.getParqueadero());
		var ciudadEntity = ciudadAssembler.toEntity(sedeDomainTmp.getCiudad());
		var tipoSedeEntity = tipoSedeAssembler.toEntity(sedeDomainTmp.getTipoSede());
		var paisEntity = paisAssembler.toEntity(sedeDomainTmp.getPais());
		var departamentoEntity = departamentoAssembler.toEntity(sedeDomainTmp.getDepartamento());
		return SedeEntity.build().setId(sedeDomainTmp.getId()).setParqueadero(parqueaderoEntity)
				.setNombre(sedeDomainTmp.getNombre()).setCiudad(ciudadEntity).setDireccion(sedeDomainTmp.getDireccion())
				.setCorreoElectronico(sedeDomainTmp.getCorreoElectronico())
				.setCeldasCarro(sedeDomainTmp.getCeldasCarro()).setCeldasMoto(sedeDomainTmp.getCeldasMoto())
				.setCeldascamion(sedeDomainTmp.getCeldascamion()).setTipoSede(tipoSedeEntity).setPais(paisEntity)
				.setDepartamento(departamentoEntity);
	}

}
