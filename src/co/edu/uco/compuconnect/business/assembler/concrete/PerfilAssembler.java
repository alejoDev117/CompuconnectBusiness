package co.edu.uco.compuconnect.business.assembler.concrete;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.Assembler;
import co.edu.uco.compuconnect.business.domain.PerfilDomain;
import co.edu.uco.compuconnect.dto.PerfilDTO;
import co.edu.uco.compuconnect.entities.PerfilEntity;

public class PerfilAssembler implements Assembler<PerfilDomain, PerfilDTO, PerfilEntity>{
	
	private static final Assembler<PerfilDomain, PerfilDTO, PerfilEntity> INSTANCE = new PerfilAssembler();
	
	private PerfilAssembler() {
		super();
	}
	
	public static final Assembler<PerfilDomain, PerfilDTO, PerfilEntity> getInstance(){
		return INSTANCE;
	}

	@Override
	public PerfilDTO toDTOFromDomain(PerfilDomain domain) {
		return PerfilDTO.create().setIdentificador(domain.getIdentificador()).setUsuario(UsuarioAssembler.getInstance().toDTOFromDomain(domain.getUsuario()));
	}

	@Override
	public PerfilDomain toDomainFromDto(PerfilDTO dto) {
		return new PerfilDomain(dto.getIdentificador(), UsuarioAssembler.getInstance().toDomainFromDto(dto.getUsuario()));
	}

	@Override
	public PerfilEntity toEntityFromDomain(PerfilDomain domain) {
		return new PerfilEntity(domain.getIdentificador(), UsuarioAssembler.getInstance().toEntityFromDomain(domain.getUsuario()));
	}

	@Override
	public PerfilDomain toDomainFromEntity(PerfilEntity entity) {
		return new PerfilDomain(entity.getIdentificador(), UsuarioAssembler.getInstance().toDomainFromEntity(entity.getUsuario()));
	}

	@Override
	public List<PerfilDomain> toDomainListFromEntityList(List<PerfilEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}

}
