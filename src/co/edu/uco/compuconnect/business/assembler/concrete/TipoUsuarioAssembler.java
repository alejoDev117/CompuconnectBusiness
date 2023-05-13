package co.edu.uco.compuconnect.business.assembler.concrete;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.Assembler;
import co.edu.uco.compuconnect.business.domain.TipoUsuarioDomain;
import co.edu.uco.compuconnect.dto.TipoUsuarioDTO;
import co.edu.uco.compuconnect.entities.TipoUsuarioEntity;

public final class TipoUsuarioAssembler implements Assembler<TipoUsuarioDomain,TipoUsuarioDTO,TipoUsuarioEntity>{
	
	private static final Assembler<TipoUsuarioDomain,TipoUsuarioDTO,TipoUsuarioEntity> INSTANCE = new TipoUsuarioAssembler();
	
	private TipoUsuarioAssembler() {
		super();
	}

	public static final Assembler<TipoUsuarioDomain, TipoUsuarioDTO, TipoUsuarioEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public TipoUsuarioDTO toDTOFromDomain(TipoUsuarioDomain domain) {
		return TipoUsuarioDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).setDescripcion(domain.getDescripcion());
	}

	@Override
	public TipoUsuarioDomain toDomainFromDto(TipoUsuarioDTO dto) {
		return new TipoUsuarioDomain(dto.getIdentificador(),dto.getNombre(),dto.getDescripcion());
	}

	@Override
	public TipoUsuarioEntity toEntityFromDomain(TipoUsuarioDomain domain) {
		return new TipoUsuarioEntity(domain.getIdentificador(),domain.getNombre(),domain.getDescripcion());
	}

	@Override
	public TipoUsuarioDomain toDomainFromEntity(TipoUsuarioEntity entity) {
		return new TipoUsuarioDomain(entity.getIdentificador(),entity.getNombre(),entity.getDescripcion());
	}

	@Override
	public List<TipoUsuarioDomain> toDomainListFromEntityList(List<TipoUsuarioEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}

	@Override
	public List<TipoUsuarioDTO> toDTOListFromDomainList(List<TipoUsuarioDomain> domainList) {
		return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();
	}
	
	
}
