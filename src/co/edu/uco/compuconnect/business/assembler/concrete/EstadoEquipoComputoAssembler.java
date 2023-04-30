package co.edu.uco.compuconnect.business.assembler.concrete;

import co.edu.uco.compuconnect.business.assembler.Assembler;
import co.edu.uco.compuconnect.business.domain.EstadoEquipoComputoDomain;
import co.edu.uco.compuconnect.dto.EstadoEquipoComputoDTO;
import co.edu.uco.compuconnect.entities.EstadoEquipoComputoEntity;

public final class EstadoEquipoComputoAssembler implements Assembler<EstadoEquipoComputoDomain,EstadoEquipoComputoDTO,EstadoEquipoComputoEntity>{
	
	private static final Assembler<EstadoEquipoComputoDomain,EstadoEquipoComputoDTO,EstadoEquipoComputoEntity> INSTANCE = new EstadoEquipoComputoAssembler();
	
	
	private EstadoEquipoComputoAssembler() {
		super();
	}


	public static final Assembler<EstadoEquipoComputoDomain, EstadoEquipoComputoDTO, EstadoEquipoComputoEntity> getInstance() {
		return INSTANCE;
	}


	@Override
	public EstadoEquipoComputoDTO toDTOFromDomain(EstadoEquipoComputoDomain domain) {
		return EstadoEquipoComputoDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).setDescripcion(domain.getDescripcion());
	}


	@Override
	public EstadoEquipoComputoDomain toDomainFromDto(EstadoEquipoComputoDTO dto) {
		return new EstadoEquipoComputoDomain(dto.getIdentificador(),dto.getNombre(),dto.getDescripcion());
	}


	@Override
	public EstadoEquipoComputoEntity toEntityFromDomain(EstadoEquipoComputoDomain domain) {
		return new EstadoEquipoComputoEntity(domain.getIdentificador(),domain.getNombre(),domain.getDescripcion());
	}


	@Override
	public EstadoEquipoComputoDomain toDomainFromEntity(EstadoEquipoComputoEntity entity) {
		return new EstadoEquipoComputoDomain(entity.getIdentificador(),entity.getNombre(),entity.getDescripcion());
	}
	
	
	

}
