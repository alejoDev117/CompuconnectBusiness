package co.edu.uco.compuconnect.business.assembler.concrete;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.Assembler;
import co.edu.uco.compuconnect.business.domain.AgendaReservaDomain;
import co.edu.uco.compuconnect.dto.AgendaReservaDTO;
import co.edu.uco.compuconnect.entities.AgendaReservaEntity;

public final class AgendaReservaAssembler implements Assembler<AgendaReservaDomain,AgendaReservaDTO,AgendaReservaEntity>{
	
	private static final Assembler<AgendaReservaDomain,AgendaReservaDTO,AgendaReservaEntity> INSTANCE = new AgendaReservaAssembler();
	
	private AgendaReservaAssembler() {
		super();
	}

	
	public static final Assembler<AgendaReservaDomain, AgendaReservaDTO, AgendaReservaEntity> getInstance() {
		return INSTANCE;
	}


	@Override
	public AgendaReservaDTO toDTOFromDomain(AgendaReservaDomain domain) {
		return AgendaReservaDTO.create().setIdentificador(domain.getIdentificador()).setAgenda(AgendaAssembler.getInstance().toDTOFromDomain(domain.getAgenda())).
				setReserva(ReservaAssembler.getInstance().toDTOFromDomain(domain.getReserva()));
	}

	@Override
	public AgendaReservaDomain toDomainFromDto(AgendaReservaDTO dto) {
		return new AgendaReservaDomain(dto.getIdentificador(),AgendaAssembler.getInstance().toDomainFromDto(dto.getAgenda()),ReservaAssembler.getInstance().toDomainFromDto(dto.getReserva()));
	}

	@Override
	public AgendaReservaEntity toEntityFromDomain(AgendaReservaDomain domain) {
		return new AgendaReservaEntity(domain.getIdentificador(),AgendaAssembler.getInstance().toEntityFromDomain(domain.getAgenda()),ReservaAssembler.getInstance().toEntityFromDomain(domain.getReserva()));
	}

	@Override
	public AgendaReservaDomain toDomainFromEntity(AgendaReservaEntity entity) {
		return new AgendaReservaDomain(entity.getIdentificador(),AgendaAssembler.getInstance().toDomainFromEntity(entity.getAgenda()),ReservaAssembler.getInstance().toDomainFromEntity(entity.getReserva()));
	}


	@Override
	public List<AgendaReservaDomain> toDomainListFromEntityList(List<AgendaReservaEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}


	@Override
	public List<AgendaReservaDTO> toDTOListFromDomainList(List<AgendaReservaDomain> domainList) {
		return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();
	}
	

}
