package co.edu.uco.compuconnect.business.assembler.concrete;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.Assembler;
import co.edu.uco.compuconnect.business.domain.FrecuenciaDomain;
import co.edu.uco.compuconnect.dto.FrecuenciaDTO;
import co.edu.uco.compuconnect.entities.FrecuenciaEntity;

public final class FrecuenciaAssembler implements Assembler<FrecuenciaDomain,FrecuenciaDTO,FrecuenciaEntity> {
	
	private static final Assembler<FrecuenciaDomain,FrecuenciaDTO,FrecuenciaEntity> INSTANCE = new FrecuenciaAssembler();
	
	
	private FrecuenciaAssembler() {
		super();
	}


	public static final Assembler<FrecuenciaDomain, FrecuenciaDTO, FrecuenciaEntity> getInstance() {
		return INSTANCE;
	}


	@Override
	public FrecuenciaDTO toDTOFromDomain(FrecuenciaDomain domain) {
		return FrecuenciaDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).setDescripcion(domain.getDescripcion());
	}


	@Override
	public FrecuenciaDomain toDomainFromDto(FrecuenciaDTO dto) {
		return new FrecuenciaDomain(dto.getIdentificador(),dto.getNombre(),dto.getDescripcion());
	}


	@Override
	public FrecuenciaEntity toEntityFromDomain(FrecuenciaDomain domain) {
		return new FrecuenciaEntity(domain.getIdentificador(),domain.getNombre(),domain.getDescripcion());
	}


	@Override
	public FrecuenciaDomain toDomainFromEntity(FrecuenciaEntity entity) {
		return new FrecuenciaDomain(entity.getIdentificador(),entity.getNombre(),entity.getDescripcion());
	}


	@Override
	public List<FrecuenciaDomain> toDomainListFromEntityList(List<FrecuenciaEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}


	@Override
	public List<FrecuenciaDTO> toDTOListFromDomainList(List<FrecuenciaDomain> domainList) {
		return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();
	}
	
	

}
