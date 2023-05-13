package co.edu.uco.compuconnect.business.assembler.concrete;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.Assembler;
import co.edu.uco.compuconnect.business.domain.PeriodoFuncionamientoDomain;
import co.edu.uco.compuconnect.dto.PeriodoFuncionamientoDTO;
import co.edu.uco.compuconnect.entities.PeriodoFuncionamientoEntity;

public final class PeriodoFuncionamientoAssembler implements Assembler<PeriodoFuncionamientoDomain,PeriodoFuncionamientoDTO,PeriodoFuncionamientoEntity> {

	private static final Assembler<PeriodoFuncionamientoDomain,PeriodoFuncionamientoDTO,PeriodoFuncionamientoEntity> INSTANCE = new PeriodoFuncionamientoAssembler();
	
	
	private PeriodoFuncionamientoAssembler() {
		super();
	}


	public static final Assembler<PeriodoFuncionamientoDomain, PeriodoFuncionamientoDTO, PeriodoFuncionamientoEntity> getInstance() {
		return INSTANCE;
	}


	@Override
	public PeriodoFuncionamientoDTO toDTOFromDomain(PeriodoFuncionamientoDomain domain) {
		return PeriodoFuncionamientoDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).
				setFechaInicio(domain.getFechaInicio()).setFechaFin(domain.getFechaFin()).setDiaFestivo(DiaFestivoAssembler.getInstance().toDTOFromDomain(domain.getDiaFestivo())).
				setEstado(EstadoPeriodoFuncionamientoAssembler.getInstance().toDTOFromDomain(domain.getEstado()));
							}


	@Override
	public PeriodoFuncionamientoDomain toDomainFromDto(PeriodoFuncionamientoDTO dto) {
		return new PeriodoFuncionamientoDomain(dto.getIdentificador(),dto.getNombre(),dto.getFechaInicio(),dto.getFechaFin(),
				DiaFestivoAssembler.getInstance().toDomainFromDto(dto.getDiaFestivo()),EstadoPeriodoFuncionamientoAssembler.getInstance().toDomainFromDto(dto.getEstado()));
	}


	@Override
	public PeriodoFuncionamientoEntity toEntityFromDomain(PeriodoFuncionamientoDomain domain) {
		return new PeriodoFuncionamientoEntity(domain.getIdentificador(),domain.getNombre(),domain.getFechaInicio(),domain.getFechaFin(),DiaFestivoAssembler.getInstance().toEntityFromDomain(domain.getDiaFestivo()),
				EstadoPeriodoFuncionamientoAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
	}


	@Override
	public PeriodoFuncionamientoDomain toDomainFromEntity(PeriodoFuncionamientoEntity entity) {
		return new PeriodoFuncionamientoDomain(entity.getIdentificador(),entity.getNombre(),entity.getFechaInicio(),entity.getFechaFin(),
				DiaFestivoAssembler.getInstance().toDomainFromEntity(entity.getDiaFestivo()),EstadoPeriodoFuncionamientoAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
	}


	@Override
	public List<PeriodoFuncionamientoDomain> toDomainListFromEntityList(List<PeriodoFuncionamientoEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}


	@Override
	public List<PeriodoFuncionamientoDTO> toDTOListFromDomainList(List<PeriodoFuncionamientoDomain> domainList) {
		return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();
	}
	
	
}
