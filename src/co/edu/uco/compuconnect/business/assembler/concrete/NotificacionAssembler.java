package co.edu.uco.compuconnect.business.assembler.concrete;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.Assembler;
import co.edu.uco.compuconnect.business.domain.NotificacionDomain;
import co.edu.uco.compuconnect.dto.NotificacionDTO;
import co.edu.uco.compuconnect.entities.NotificacionEntity;

public class NotificacionAssembler implements Assembler<NotificacionDomain, NotificacionDTO, NotificacionEntity> {
	
	private static final Assembler<NotificacionDomain, NotificacionDTO, NotificacionEntity> INSTANCE = new NotificacionAssembler();
	
	private NotificacionAssembler() {
		super();
	}
	
	public static final Assembler<NotificacionDomain, NotificacionDTO, NotificacionEntity> getInstance(){
		return INSTANCE;
	}

	@Override
	public NotificacionDTO toDTOFromDomain(NotificacionDomain domain) {
		return NotificacionDTO.create().setIdentificador(domain.getIdentificador()).setContenido(ContenidoAssembler.getInstance().toDTOFromDomain(domain.getContenido()))
				.setFecha(domain.getFecha()).setTiponotificacion(TipoNotificacionAssembler.getInstance().toDTOFromDomain(domain.getTipo()));
	}

	@Override
	public NotificacionDomain toDomainFromDto(NotificacionDTO dto) {
		return new NotificacionDomain(dto.getIdentificador(), ContenidoAssembler.getInstance().toDomainFromDto(dto.getContenido()),
				dto.getFecha(), TipoNotificacionAssembler.getInstance().toDomainFromDto(dto.getTiponotificacion()));
	}

	@Override
	public NotificacionEntity toEntityFromDomain(NotificacionDomain domain) {
		return new NotificacionEntity(domain.getIdentificador(), ContenidoAssembler.getInstance().toEntityFromDomain(domain.getContenido()), 
				domain.getFecha(), TipoNotificacionAssembler.getInstance().toEntityFromDomain(domain.getTipo()));
	}

	@Override
	public NotificacionDomain toDomainFromEntity(NotificacionEntity entity) {
		return new NotificacionDomain(entity.getIdentificador(), ContenidoAssembler.getInstance().toDomainFromEntity(entity.getContenido()),
				entity.getFecha(), TipoNotificacionAssembler.getInstance().toDomainFromEntity(entity.getTipo()));
	}

	@Override
	public List<NotificacionDomain> toDomainListFromEntityList(List<NotificacionEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}

	@Override
	public List<NotificacionDTO> toDTOListFromDomainList(List<NotificacionDomain> domainList) {
		return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();
	}

	@Override
	public List<NotificacionDomain> toDomainListFromDTOList(List<NotificacionDTO> dtoList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NotificacionEntity> toEntityListFromDomainList(List<NotificacionDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
