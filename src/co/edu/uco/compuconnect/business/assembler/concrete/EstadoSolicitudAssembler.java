package co.edu.uco.compuconnect.business.assembler.concrete;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.Assembler;
import co.edu.uco.compuconnect.business.domain.EstadoSolicitudDomain;
import co.edu.uco.compuconnect.dto.EstadoSolicitudDTO;
import co.edu.uco.compuconnect.entities.EstadoSolicitudEntity;

public final  class EstadoSolicitudAssembler implements Assembler<EstadoSolicitudDomain,EstadoSolicitudDTO,EstadoSolicitudEntity>{
	
	private static final Assembler<EstadoSolicitudDomain,EstadoSolicitudDTO,EstadoSolicitudEntity> INSTANCE = new EstadoSolicitudAssembler();
	
	
	private EstadoSolicitudAssembler() {
		super();
	}


	public static final Assembler<EstadoSolicitudDomain, EstadoSolicitudDTO, EstadoSolicitudEntity> getInstance() {
		return INSTANCE;
	}


	@Override
	public EstadoSolicitudDTO toDTOFromDomain(EstadoSolicitudDomain domain) {
		return EstadoSolicitudDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).setDescripcion(domain.getDescripcion());
	}


	@Override
	public EstadoSolicitudDomain toDomainFromDto(EstadoSolicitudDTO dto) {
		return new EstadoSolicitudDomain(dto.getIdentificador(),dto.getNombre(),dto.getDescripcion());
	}


	@Override
	public EstadoSolicitudEntity toEntityFromDomain(EstadoSolicitudDomain domain) {
		return new EstadoSolicitudEntity(domain.getIdentificador(),domain.getNombre(),domain.getDescripcion());
	}


	@Override
	public EstadoSolicitudDomain toDomainFromEntity(EstadoSolicitudEntity entity) {
		return new EstadoSolicitudDomain(entity.getIdentificador(),entity.getNombre(),entity.getDescripcion());
	}


	@Override
	public List<EstadoSolicitudDomain> toDomainListFromEntityList(List<EstadoSolicitudEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}


	@Override
	public List<EstadoSolicitudDTO> toDTOListFromDomainList(List<EstadoSolicitudDomain> domainList) {
		return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();
	}
	
	
	
	

}
