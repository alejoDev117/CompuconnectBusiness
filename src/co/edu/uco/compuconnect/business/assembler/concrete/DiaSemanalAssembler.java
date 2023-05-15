package co.edu.uco.compuconnect.business.assembler.concrete;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.Assembler;
import co.edu.uco.compuconnect.business.domain.DiaSemanalDomain;
import co.edu.uco.compuconnect.dto.DiaSemanalDTO;
import co.edu.uco.compuconnect.entities.DiaSemanalEntity;

public final class DiaSemanalAssembler implements Assembler<DiaSemanalDomain,DiaSemanalDTO,DiaSemanalEntity> {
	
	private static final Assembler<DiaSemanalDomain,DiaSemanalDTO,DiaSemanalEntity> INSTANCE = new DiaSemanalAssembler();
	
	
	private DiaSemanalAssembler() {
		super();
	}


	public static final Assembler<DiaSemanalDomain, DiaSemanalDTO, DiaSemanalEntity> getInstance() {
		return INSTANCE;
	}


	@Override
	public DiaSemanalDTO toDTOFromDomain(DiaSemanalDomain domain) {
		return DiaSemanalDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre());
	}


	@Override
	public DiaSemanalDomain toDomainFromDto(DiaSemanalDTO dto) {
		return new DiaSemanalDomain(dto.getIdentificador(),dto.getNombre());
	}


	@Override
	public DiaSemanalEntity toEntityFromDomain(DiaSemanalDomain domain) {
		return new DiaSemanalEntity(domain.getIdentificador(),domain.getNombre());
	}


	@Override
	public DiaSemanalDomain toDomainFromEntity(DiaSemanalEntity entity) {
		return new DiaSemanalDomain(entity.getIdentificador(),entity.getNombre());
	}


	@Override
	public List<DiaSemanalDomain> toDomainListFromEntityList(List<DiaSemanalEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}


	@Override
	public List<DiaSemanalDTO> toDTOListFromDomainList(List<DiaSemanalDomain> domainList) {
		return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();
	}
	
	
	

}
