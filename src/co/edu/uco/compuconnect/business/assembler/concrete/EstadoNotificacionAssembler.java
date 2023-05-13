package co.edu.uco.compuconnect.business.assembler.concrete;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.Assembler;
import co.edu.uco.compuconnect.business.domain.EstadoNotificacionDomain;
import co.edu.uco.compuconnect.dto.EstadoNotificacionDTO;
import co.edu.uco.compuconnect.entities.EstadoNotificacionEntity;

public final class EstadoNotificacionAssembler implements Assembler<EstadoNotificacionDomain, EstadoNotificacionDTO, EstadoNotificacionEntity> {
	
	private static final Assembler<EstadoNotificacionDomain, EstadoNotificacionDTO, EstadoNotificacionEntity> INSTANCE = new EstadoNotificacionAssembler();
	
	
	private EstadoNotificacionAssembler() {
		super();
	}


	public static final Assembler<EstadoNotificacionDomain, EstadoNotificacionDTO, EstadoNotificacionEntity> getInstance() {
		return INSTANCE;
	}


	@Override
	public EstadoNotificacionDTO toDTOFromDomain(EstadoNotificacionDomain domain) {
		return EstadoNotificacionDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).setDescripcion(domain.getDescripcion());
	}


	@Override
	public EstadoNotificacionDomain toDomainFromDto(EstadoNotificacionDTO dto) {
		return new EstadoNotificacionDomain(dto.getIdentificador(),dto.getNombre(),dto.getDescripcion());
	}


	@Override
	public EstadoNotificacionEntity toEntityFromDomain(EstadoNotificacionDomain domain) {
		return new EstadoNotificacionEntity(domain.getIdentificador(),domain.getNombre(),domain.getDescripcion());
	}


	@Override
	public EstadoNotificacionDomain toDomainFromEntity(EstadoNotificacionEntity entity) {
		return new EstadoNotificacionDomain(entity.getIdentificador(),entity.getNombre(),entity.getDescripcion());
	}


	@Override
	public List<EstadoNotificacionDomain> toDomainListFromEntityList(List<EstadoNotificacionEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}


	@Override
	public List<EstadoNotificacionDTO> toDTOListFromDomainList(List<EstadoNotificacionDomain> domainList) {
		return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();
	}
	
	
	

}
