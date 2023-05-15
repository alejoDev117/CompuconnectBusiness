package co.edu.uco.compuconnect.business.assembler.concrete;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.Assembler;
import co.edu.uco.compuconnect.business.domain.DetalleReservaDomain;
import co.edu.uco.compuconnect.dto.DetalleReservaDTO;
import co.edu.uco.compuconnect.entities.DetalleReservaEntity;

public final class DetalleReservaAssembler implements Assembler< DetalleReservaDomain, DetalleReservaDTO, DetalleReservaEntity> {
	
	private static final Assembler< DetalleReservaDomain, DetalleReservaDTO, DetalleReservaEntity> INSTANCE = new DetalleReservaAssembler();
	
	
	private DetalleReservaAssembler() {
		super();
	}


	public static final Assembler<DetalleReservaDomain, DetalleReservaDTO, DetalleReservaEntity> getInstance() {
		return INSTANCE;
	}


	@Override
	public DetalleReservaDTO toDTOFromDomain(DetalleReservaDomain domain) {
		return DetalleReservaDTO.create().setIdentificador(domain.getIdentificador()).
				setReserva(ReservaAssembler.getInstance().toDTOFromDomain(domain.getReserva())).
				setDia(DiaSemanalAssembler.getInstance().toDTOFromDomain(domain.getDia())).
				setHoraInicio(domain.getHorainicio()).setHorFin(domain.getHorafin());
	}


	@Override
	public DetalleReservaDomain toDomainFromDto(DetalleReservaDTO dto) {
		return new DetalleReservaDomain(dto.getIdentificador(),ReservaAssembler.getInstance().toDomainFromDto(dto.getReserva()),
				DiaSemanalAssembler.getInstance().toDomainFromDto(dto.getDia()),dto.getHoraInicio(),dto.getHorFin());
	}


	@Override
	public DetalleReservaEntity toEntityFromDomain(DetalleReservaDomain domain) {
		return new DetalleReservaEntity(domain.getIdentificador(),ReservaAssembler.getInstance().toEntityFromDomain(domain.getReserva()),
				DiaSemanalAssembler.getInstance().toEntityFromDomain(domain.getDia()),domain.getHorainicio(),domain.getHorafin());
	}


	@Override
	public DetalleReservaDomain toDomainFromEntity(DetalleReservaEntity entity) {
		return new DetalleReservaDomain(entity.getIdentificador(),ReservaAssembler.getInstance().toDomainFromEntity(entity.getReserva()),
				DiaSemanalAssembler.getInstance().toDomainFromEntity(entity.getDia()),entity.getHorainicio(),entity.getHorafin());
	}


	@Override
	public List<DetalleReservaDomain> toDomainListFromEntityList(List<DetalleReservaEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}


	@Override
	public List<DetalleReservaDTO> toDTOListFromDomainList(List<DetalleReservaDomain> domainList) {
		return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();
	}
	
	
	

}
