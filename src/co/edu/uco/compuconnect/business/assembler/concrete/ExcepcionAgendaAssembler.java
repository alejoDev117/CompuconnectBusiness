package co.edu.uco.compuconnect.business.assembler.concrete;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.Assembler;
import co.edu.uco.compuconnect.business.domain.ExcepcionAgendaDomain;
import co.edu.uco.compuconnect.dto.ExcepcionAgendaDTO;
import co.edu.uco.compuconnect.entities.ExcepcionAgendaEntity;

public final class ExcepcionAgendaAssembler implements Assembler<ExcepcionAgendaDomain,ExcepcionAgendaDTO,ExcepcionAgendaEntity> {

	private static final Assembler<ExcepcionAgendaDomain,ExcepcionAgendaDTO,ExcepcionAgendaEntity> INSTANCE = new ExcepcionAgendaAssembler();
	
	
	private ExcepcionAgendaAssembler() {
		super();
	}


	public static final Assembler<ExcepcionAgendaDomain, ExcepcionAgendaDTO, ExcepcionAgendaEntity> getInstance() {
		return INSTANCE;
	}


	@Override
	public ExcepcionAgendaDTO toDTOFromDomain(ExcepcionAgendaDomain domain) {
		return ExcepcionAgendaDTO.create().setIdentificador(domain.getIdentificador()).setExcepcion(ExcepcionAssembler.getInstance().toDTOFromDomain(domain.getExcepcion())).
				setAgenda(AgendaAssembler.getInstance().toDTOFromDomain(domain.getAgenda()));
				
	}


	@Override
	public ExcepcionAgendaDomain toDomainFromDto(ExcepcionAgendaDTO dto) {
		return new ExcepcionAgendaDomain(dto.getIdentificador(),ExcepcionAssembler.getInstance().toDomainFromDto(dto.getExcepcion()),
				AgendaAssembler.getInstance().toDomainFromDto(dto.getAgenda()));
	}


	@Override
	public ExcepcionAgendaEntity toEntityFromDomain(ExcepcionAgendaDomain domain) {
		return new ExcepcionAgendaEntity(domain.getIdentificador(),ExcepcionAssembler.getInstance().toEntityFromDomain(domain.getExcepcion()),
				AgendaAssembler.getInstance().toEntityFromDomain(domain.getAgenda()));
	}


	@Override
	public ExcepcionAgendaDomain toDomainFromEntity(ExcepcionAgendaEntity entity) {
		return new ExcepcionAgendaDomain(entity.getIdentificador(),ExcepcionAssembler.getInstance().toDomainFromEntity(entity.getExcepcion()),
				AgendaAssembler.getInstance().toDomainFromEntity(entity.getAgenda()));
	}


	@Override
	public List<ExcepcionAgendaDomain> toDomainListFromEntityList(List<ExcepcionAgendaEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}
	
	
}
