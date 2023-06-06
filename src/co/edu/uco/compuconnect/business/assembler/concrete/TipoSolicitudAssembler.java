package co.edu.uco.compuconnect.business.assembler.concrete;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.Assembler;
import co.edu.uco.compuconnect.business.domain.TipoSolicitudDomain;
import co.edu.uco.compuconnect.dto.TipoSolicitudDTO;
import co.edu.uco.compuconnect.entities.TipoSolicitudEntity;

public final class TipoSolicitudAssembler implements Assembler<TipoSolicitudDomain,TipoSolicitudDTO,TipoSolicitudEntity> {
	
	private static final Assembler<TipoSolicitudDomain,TipoSolicitudDTO,TipoSolicitudEntity> INSTANCE = new TipoSolicitudAssembler();
	
	
	private TipoSolicitudAssembler() {
		super();
	}
	
	

	public static final Assembler<TipoSolicitudDomain, TipoSolicitudDTO, TipoSolicitudEntity> getInstance() {
		return INSTANCE;
	}



	@Override
	public TipoSolicitudDTO toDTOFromDomain(TipoSolicitudDomain domain) {
		return TipoSolicitudDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).setDescripcion(domain.getDescripcion());
	}

	@Override
	public TipoSolicitudDomain toDomainFromDto(TipoSolicitudDTO dto) {
		return new TipoSolicitudDomain(dto.getIdentificador(),dto.getNombre(),dto.getDescripcion());
	}

	@Override
	public TipoSolicitudEntity toEntityFromDomain(TipoSolicitudDomain domain) {
		return new TipoSolicitudEntity(domain.getIdentificador(),domain.getNombre(),domain.getDescripcion());
	}

	@Override
	public TipoSolicitudDomain toDomainFromEntity(TipoSolicitudEntity entity) {
		return new TipoSolicitudDomain(entity.getIdentificador(),entity.getNombre(),entity.getDescripcion());
	}



	@Override
	public List<TipoSolicitudDomain> toDomainListFromEntityList(List<TipoSolicitudEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}



	@Override
	public List<TipoSolicitudDTO> toDTOListFromDomainList(List<TipoSolicitudDomain> domainList) {
		return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();
	}



	@Override
	public List<TipoSolicitudDomain> toDomainListFromDTOList(List<TipoSolicitudDTO> dtoList) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<TipoSolicitudEntity> toEntityListFromDomainList(List<TipoSolicitudDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
