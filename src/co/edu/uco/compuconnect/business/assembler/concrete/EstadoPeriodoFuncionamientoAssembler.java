package co.edu.uco.compuconnect.business.assembler.concrete;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.Assembler;
import co.edu.uco.compuconnect.business.domain.EstadoPeriodoFuncionamientoDomain;
import co.edu.uco.compuconnect.dto.EstadoPeriodoFuncionamientoDTO;
import co.edu.uco.compuconnect.entities.EstadoPeriodoFuncionamientoEntity;

public final class EstadoPeriodoFuncionamientoAssembler implements Assembler<EstadoPeriodoFuncionamientoDomain,EstadoPeriodoFuncionamientoDTO,EstadoPeriodoFuncionamientoEntity>{

	private static final Assembler<EstadoPeriodoFuncionamientoDomain,EstadoPeriodoFuncionamientoDTO,EstadoPeriodoFuncionamientoEntity> INSTANCE = new EstadoPeriodoFuncionamientoAssembler();
	
	
	private EstadoPeriodoFuncionamientoAssembler() {
		super();
	}


	public static final Assembler<EstadoPeriodoFuncionamientoDomain, EstadoPeriodoFuncionamientoDTO, EstadoPeriodoFuncionamientoEntity> getInstance() {
		return INSTANCE;
	}


	@Override
	public EstadoPeriodoFuncionamientoDTO toDTOFromDomain(EstadoPeriodoFuncionamientoDomain domain) {
		return EstadoPeriodoFuncionamientoDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).setDescripcion(domain.getDescripcion());
	}


	@Override
	public EstadoPeriodoFuncionamientoDomain toDomainFromDto(EstadoPeriodoFuncionamientoDTO dto) {
		return new EstadoPeriodoFuncionamientoDomain(dto.getIdentificador(),dto.getNombre(),dto.getDescripcion());
	}


	@Override
	public EstadoPeriodoFuncionamientoEntity toEntityFromDomain(EstadoPeriodoFuncionamientoDomain domain) {
		return new EstadoPeriodoFuncionamientoEntity(domain.getIdentificador(),domain.getNombre(),domain.getDescripcion());
	}


	@Override
	public EstadoPeriodoFuncionamientoDomain toDomainFromEntity(EstadoPeriodoFuncionamientoEntity entity) {
		return new EstadoPeriodoFuncionamientoDomain(entity.getIdentificador(),entity.getNombre(),entity.getDescripcion());
	}


	@Override
	public List<EstadoPeriodoFuncionamientoDomain> toDomainListFromEntityList(
			List<EstadoPeriodoFuncionamientoEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}


	@Override
	public List<EstadoPeriodoFuncionamientoDTO> toDTOListFromDomainList(
			List<EstadoPeriodoFuncionamientoDomain> domainList) {
		return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();
	}
	
	
	
}
