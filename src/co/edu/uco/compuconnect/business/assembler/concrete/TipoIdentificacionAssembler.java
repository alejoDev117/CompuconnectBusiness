package co.edu.uco.compuconnect.business.assembler.concrete;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.Assembler;
import co.edu.uco.compuconnect.business.domain.TipoIdentificacionDomain;
import co.edu.uco.compuconnect.dto.TipoIdentificacionDTO;
import co.edu.uco.compuconnect.entities.TipoIdentificacionEntity;

public final class TipoIdentificacionAssembler implements Assembler<TipoIdentificacionDomain,TipoIdentificacionDTO,TipoIdentificacionEntity>{
	
	private static final Assembler<TipoIdentificacionDomain,TipoIdentificacionDTO,TipoIdentificacionEntity> INSTANCE = new TipoIdentificacionAssembler();
	
	
	private TipoIdentificacionAssembler() {
		super();
	}


	public static final Assembler<TipoIdentificacionDomain, TipoIdentificacionDTO, TipoIdentificacionEntity> getInstance() {
		return INSTANCE;
	}


	@Override
	public TipoIdentificacionDTO toDTOFromDomain(TipoIdentificacionDomain domain) {
		return TipoIdentificacionDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).setDescripcion(domain.getDescripcion());
	}


	@Override
	public TipoIdentificacionDomain toDomainFromDto(TipoIdentificacionDTO dto) {
		return new TipoIdentificacionDomain(dto.getIdentificador(),dto.getNombre(),dto.getDescripcion());
	}


	@Override
	public TipoIdentificacionEntity toEntityFromDomain(TipoIdentificacionDomain domain) {
		return new TipoIdentificacionEntity(domain.getIdentificador(),domain.getNombre(),domain.getDescripcion());
	}


	@Override
	public TipoIdentificacionDomain toDomainFromEntity(TipoIdentificacionEntity entity) {
		return new TipoIdentificacionDomain(entity.getIdentificador(),entity.getNombre(),entity.getDescripcion());
	}


	@Override
	public List<TipoIdentificacionDomain> toDomainListFromEntityList(List<TipoIdentificacionEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}


	@Override
	public List<TipoIdentificacionDTO> toDTOListFromDomainList(List<TipoIdentificacionDomain> domainList) {
		return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();
	}
	
	
	

}
