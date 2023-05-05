package co.edu.uco.compuconnect.business.assembler.concrete;

import co.edu.uco.compuconnect.business.assembler.Assembler;
import co.edu.uco.compuconnect.business.domain.UsuarioDomain;
import co.edu.uco.compuconnect.dto.UsuarioDTO;
import co.edu.uco.compuconnect.entities.UsuarioEntity;

public final class UsuarioAssembler implements Assembler<UsuarioDomain,UsuarioDTO,UsuarioEntity> {

	private static final Assembler<UsuarioDomain,UsuarioDTO,UsuarioEntity> INSTANCE = new UsuarioAssembler();
	
	private UsuarioAssembler() {
		super();
	}

	public static final Assembler<UsuarioDomain, UsuarioDTO, UsuarioEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public UsuarioDTO toDTOFromDomain(UsuarioDomain domain) {
		return UsuarioDTO.create().setIdentificador(domain.getIdentificador()).
				setTipoUsuario(TipoUsuarioAssembler.getInstance().toDTOFromDomain(domain.getTipoUsuario())).
				setNombre(domain.getNombre()).setTipoIdentificacion(TipoIdentificacionAssembler.getInstance().toDTOFromDomain(domain.getTipoIdentificacion())).
				setIdentificacion(domain.getIdentificacion()).setCorreoInstitucional(domain.getCorreoInstitucional());
				
	}

	@Override
	public UsuarioDomain toDomainFromDto(UsuarioDTO dto) {
		return new UsuarioDomain(dto.getIdentificador(),TipoUsuarioAssembler.getInstance().toDomainFromDto(dto.getTipoUsuario()),
				dto.getNombre(),TipoIdentificacionAssembler.getInstance().toDomainFromDto(dto.getTipoIdentificacion()),dto.getIdentificacion(),
				dto.getCorreoInstitucional());
	}

	@Override
	public UsuarioEntity toEntityFromDomain(UsuarioDomain domain) {
		return new UsuarioEntity(domain.getIdentificador(),TipoUsuarioAssembler.getInstance().toEntityFromDomain(domain.getTipoUsuario()),
				domain.getNombre(),TipoIdentificacionAssembler.getInstance().toEntityFromDomain(domain.getTipoIdentificacion()),domain.getIdentificacion(),
				domain.getCorreoInstitucional());
	}

	@Override
	public UsuarioDomain toDomainFromEntity(UsuarioEntity entity) {
		return new UsuarioDomain(entity.getIdentificador(),TipoUsuarioAssembler.getInstance().toDomainFromEntity(entity.getTipoUsuario()),
				entity.getNombre(),TipoIdentificacionAssembler.getInstance().toDomainFromEntity(entity.getTipoIdentificacion()),entity.getIdentificacion(),
				entity.getCorreoInstitucional());
	}
	
	
	
}