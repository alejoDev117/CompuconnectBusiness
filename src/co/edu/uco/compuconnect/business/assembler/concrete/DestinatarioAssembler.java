package co.edu.uco.compuconnect.business.assembler.concrete;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.Assembler;
import co.edu.uco.compuconnect.business.domain.DestinatarioDomain;
import co.edu.uco.compuconnect.dto.DestinatarioDTO;
import co.edu.uco.compuconnect.entities.DestinatarioEntity;

public class DestinatarioAssembler implements Assembler<DestinatarioDomain, DestinatarioDTO, DestinatarioEntity>{
	
	private static final Assembler<DestinatarioDomain, DestinatarioDTO, DestinatarioEntity> INSTANCE = new DestinatarioAssembler();
	
	private DestinatarioAssembler() {
		super();
	}
	
	public static final Assembler<DestinatarioDomain, DestinatarioDTO, DestinatarioEntity> getInstance(){
		return INSTANCE;
	}

	@Override
	public DestinatarioDTO toDTOFromDomain(DestinatarioDomain domain) {
		return DestinatarioDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).setCorreo(domain.getCorreo());
	}

	@Override
	public DestinatarioDomain toDomainFromDto(DestinatarioDTO dto) {
		return new DestinatarioDomain(dto.getIdentificador(), dto.getNombre(), dto.getCorreo());
	}

	@Override
	public DestinatarioEntity toEntityFromDomain(DestinatarioDomain domain) {
		return new DestinatarioEntity(domain.getIdentificador(), domain.getNombre(), domain.getCorreo());
	}

	@Override
	public DestinatarioDomain toDomainFromEntity(DestinatarioEntity entity) {
		return new DestinatarioDomain(entity.getIdentificador(), entity.getNombre(), entity.getCorreoInstitucional());
	}

	@Override
	public List<DestinatarioDomain> toDomainListFromEntityList(List<DestinatarioEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}

	@Override
	public List<DestinatarioDTO> toDTOListFromDomainList(List<DestinatarioDomain> domainList) {
		return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();
	}

}
