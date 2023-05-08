package co.edu.uco.compuconnect.business.assembler.concrete;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.Assembler;
import co.edu.uco.compuconnect.business.domain.DestinatarioNotificacionDomain;
import co.edu.uco.compuconnect.dto.DestinatarioNotificacionDTO;
import co.edu.uco.compuconnect.entities.DestinatarioNotificacionEntity;

public class DestinatarioNotificacionAssembler implements Assembler<DestinatarioNotificacionDomain, DestinatarioNotificacionDTO, DestinatarioNotificacionEntity>{

	private static final Assembler<DestinatarioNotificacionDomain, DestinatarioNotificacionDTO, DestinatarioNotificacionEntity> INSTANCE = new DestinatarioNotificacionAssembler();
	
	private DestinatarioNotificacionAssembler() {
		super();
	}
	
	public static final Assembler<DestinatarioNotificacionDomain, DestinatarioNotificacionDTO, DestinatarioNotificacionEntity> getInstance(){
		return INSTANCE;
	}

	@Override
	public DestinatarioNotificacionDTO toDTOFromDomain(DestinatarioNotificacionDomain domain) {
		return DestinatarioNotificacionDTO.create().setIdentificador(domain.getIdentificador()).setDestinatario(DestinatarioAssembler.getInstance().toDTOFromDomain(domain.getDestinatario()))
				.setNotificacion(NotificacionAssembler.getInstance().toDTOFromDomain(domain.getNotificacion())).setEstado(EstadoNotificacionAssembler.getInstance().toDTOFromDomain(domain.getEstado()));
	}

	@Override
	public DestinatarioNotificacionDomain toDomainFromDto(DestinatarioNotificacionDTO dto) {
		return new DestinatarioNotificacionDomain(dto.getIdentificador(), DestinatarioAssembler.getInstance().toDomainFromDto(dto.getDestinatario()),
				NotificacionAssembler.getInstance().toDomainFromDto(dto.getNotificacion()), EstadoNotificacionAssembler.getInstance().toDomainFromDto(dto.getEstado()));
	}

	@Override
	public DestinatarioNotificacionEntity toEntityFromDomain(DestinatarioNotificacionDomain domain) {
		return new DestinatarioNotificacionEntity(domain.getIdentificador(), DestinatarioAssembler.getInstance().toEntityFromDomain(domain.getDestinatario()),
				NotificacionAssembler.getInstance().toEntityFromDomain(domain.getNotificacion()), EstadoNotificacionAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
	}

	@Override
	public DestinatarioNotificacionDomain toDomainFromEntity(DestinatarioNotificacionEntity entity) {
		return new DestinatarioNotificacionDomain(entity.getIdentificador(), DestinatarioAssembler.getInstance().toDomainFromEntity(entity.getDestinatario()),
				NotificacionAssembler.getInstance().toDomainFromEntity(entity.getNotificacion()), EstadoNotificacionAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
	}

	@Override
	public List<DestinatarioNotificacionDomain> toDomainListFromEntityList(List<DestinatarioNotificacionEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}
	
}
