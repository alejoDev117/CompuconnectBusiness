package co.edu.uco.compuconnect.business.assembler.concrete;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.Assembler;
import co.edu.uco.compuconnect.business.domain.CentroInformaticaDomain;
import co.edu.uco.compuconnect.dto.CentroInformaticaDTO;
import co.edu.uco.compuconnect.entities.CentroInformaticaEntity;

public final class CentroInformaticaAssembler implements Assembler<CentroInformaticaDomain,CentroInformaticaDTO,CentroInformaticaEntity>{

	private static final Assembler<CentroInformaticaDomain,CentroInformaticaDTO,CentroInformaticaEntity> INSTANCE = new CentroInformaticaAssembler();
	
	
	private CentroInformaticaAssembler() {
		super();
	}

	
	public static final Assembler<CentroInformaticaDomain,CentroInformaticaDTO,CentroInformaticaEntity> getInstance(){
		return INSTANCE;
	}
	
	
	
	@Override
	public final CentroInformaticaDTO toDTOFromDomain(CentroInformaticaDomain domain) {
		return CentroInformaticaDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).setUbicacion(domain.getUbicacion()).setPoseeVideoBeam(domain.isPoseeVideoBeam());
		
	}

	@Override
	public final CentroInformaticaDomain toDomainFromDto(CentroInformaticaDTO dto) {
		return new CentroInformaticaDomain(dto.getIdentificador(),dto.getNombre(),dto.getUbicacion(),dto.isPoseeVideoBeam());
	}

	@Override
	public final CentroInformaticaEntity toEntityFromDomain(CentroInformaticaDomain domain) {
		return new CentroInformaticaEntity(domain.getIdentificador(),domain.getNombre(),domain.getUbicacion(),domain.isPoseeVideoBeam());
	}

	@Override
	public final  CentroInformaticaDomain toDomainFromEntity(CentroInformaticaEntity entity) {
		return new CentroInformaticaDomain(entity.getIdentificador(),entity.getNombre(),entity.getUbicacion(),entity.isPoseeVideoBeam());
	}


	@Override
	public List<CentroInformaticaDomain> toDomainListFromEntityList(List<CentroInformaticaEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}


	@Override
	public List<CentroInformaticaDTO> toDTOListFromDomainList(List<CentroInformaticaDomain> domainList) {
		return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();
	}


	@Override
	public List<CentroInformaticaDomain> toDomainListFromDTOList(List<CentroInformaticaDTO> dtoList) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<CentroInformaticaEntity> toEntityListFromDomainList(List<CentroInformaticaDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
