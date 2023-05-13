package co.edu.uco.compuconnect.business.assembler.concrete;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.Assembler;
import co.edu.uco.compuconnect.business.domain.ExcepcionDomain;
import co.edu.uco.compuconnect.dto.ExcepcionDTO;
import co.edu.uco.compuconnect.entities.ExcepcionEntity;

public final class ExcepcionAssembler implements Assembler<ExcepcionDomain,ExcepcionDTO,ExcepcionEntity>{ 
	private static final Assembler<ExcepcionDomain,ExcepcionDTO,ExcepcionEntity> INSTANCE = new ExcepcionAssembler();
	
	private ExcepcionAssembler() {
		super();
	}

	public static final Assembler<ExcepcionDomain, ExcepcionDTO, ExcepcionEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public ExcepcionDTO toDTOFromDomain(ExcepcionDomain domain) {
		return ExcepcionDTO.create().setIdentificador(domain.getIdentificador()).setFechaInicio(domain.getFechaInicio()).setFechaFin(domain.getFechaFin()).setHoraInicio(domain.getHoraInicio()).setHoraFin(domain.getHoraFin()).
				setFrecuencia(FrecuenciaAssembler.getInstance().toDTOFromDomain(domain.getFrecuencia())).setMotivo(domain.getMotivo());
	}

	@Override
	public ExcepcionDomain toDomainFromDto(ExcepcionDTO dto) {
		return new ExcepcionDomain(dto.getIdentificador(),dto.getFechaInicio(),dto.getFechaFin(),dto.getHoraInicio(),dto.getHoraFin(),FrecuenciaAssembler.getInstance().toDomainFromDto(dto.getFrecuencia()),dto.getMotivo());
	}

	@Override
	public ExcepcionEntity toEntityFromDomain(ExcepcionDomain domain) {
		return new ExcepcionEntity(domain.getIdentificador(),domain.getFechaInicio(),domain.getFechaFin(),domain.getHoraInicio(),domain.getHoraFin(),FrecuenciaAssembler.getInstance().toEntityFromDomain(domain.getFrecuencia()),domain.getMotivo());
	}

	@Override
	public ExcepcionDomain toDomainFromEntity(ExcepcionEntity entity) {
		return new ExcepcionDomain(entity.getIdentificador(),entity.getFechaInicio(),entity.getFechaFin(),entity.getHoraInicio(),entity.getHoraFin(),FrecuenciaAssembler.getInstance().toDomainFromEntity(entity.getFrecuencia()),entity.getMotivo());
	}

	@Override
	public List<ExcepcionDomain> toDomainListFromEntityList(List<ExcepcionEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}

	@Override
	public List<ExcepcionDTO> toDTOListFromDomainList(List<ExcepcionDomain> domainList) {
		return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();
	}
	
	
}
