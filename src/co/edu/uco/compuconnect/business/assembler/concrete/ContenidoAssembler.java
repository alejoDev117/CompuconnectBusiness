package co.edu.uco.compuconnect.business.assembler.concrete;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.Assembler;
import co.edu.uco.compuconnect.business.domain.ContenidoDomain;
import co.edu.uco.compuconnect.dto.ContenidoDTO;
import co.edu.uco.compuconnect.entities.ContenidoEntity;

public class ContenidoAssembler implements Assembler<ContenidoDomain, ContenidoDTO, ContenidoEntity>{
	
	private static final Assembler<ContenidoDomain, ContenidoDTO, ContenidoEntity> INSTANCE = new ContenidoAssembler();
	
	private ContenidoAssembler() {
		super();
	}
	
	public static final Assembler<ContenidoDomain, ContenidoDTO, ContenidoEntity> getInstance(){
		return INSTANCE;
	}

	@Override
	public ContenidoDTO toDTOFromDomain(ContenidoDomain domain) {
		return ContenidoDTO.create().setIdentificador(domain.getIdentificador()).setDescripcion(domain.getDescripcion());
	}

	@Override
	public ContenidoDomain toDomainFromDto(ContenidoDTO dto) {
		return new ContenidoDomain(dto.getIdentificador(), dto.getDescripcion());
	}

	@Override
	public ContenidoEntity toEntityFromDomain(ContenidoDomain domain) {
		return new ContenidoEntity(domain.getIdentificador(), domain.getDescripcion());
	}

	@Override
	public ContenidoDomain toDomainFromEntity(ContenidoEntity entity) {
		return new ContenidoDomain(entity.getIdentificador(), entity.getDescripcion());
	}

	@Override
	public List<ContenidoDomain> toDomainListFromEntityList(List<ContenidoEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}

	
	
}
