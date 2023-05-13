package co.edu.uco.compuconnect.business.assembler.concrete;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.Assembler;
import co.edu.uco.compuconnect.business.domain.CoordinadorDomain;
import co.edu.uco.compuconnect.business.domain.TipoUsuarioDomain;
import co.edu.uco.compuconnect.dto.CoordinadorDTO;
import co.edu.uco.compuconnect.entities.CoordinadorEntity;

public final  class CoordinadorAssembler implements Assembler<CoordinadorDomain,CoordinadorDTO,CoordinadorEntity>{
	
	private static final Assembler<CoordinadorDomain,CoordinadorDTO,CoordinadorEntity> INSTANCE = new CoordinadorAssembler();
	
	
	private CoordinadorAssembler() {
		super();
	}


	public static final Assembler<CoordinadorDomain, CoordinadorDTO, CoordinadorEntity> getInstance() {
		return INSTANCE;
	}


	@Override
	public CoordinadorDTO toDTOFromDomain(CoordinadorDomain domain) {
		return CoordinadorDTO.create().setIdentificador(domain.getIdentificador()).
				setTipoIdentificacion(TipoIdentificacionAssembler.getInstance().toDTOFromDomain(domain.getTipoIdentificacion())).
				setIdentificacion(domain.getIdentificacion()).setNombre(domain.getNombre()).setCorreoInstitucional(domain.getCorreoInstitucional()).
				setNumeroCelular(domain.getNumeroCelular()).setTipoUsuario(TipoUsuarioAssembler.getInstance().toDTOFromDomain(domain.getTipoUsuario()));
	}


	@Override
	public CoordinadorDomain toDomainFromDto(CoordinadorDTO dto) {
		return new CoordinadorDomain(dto.getIdentificador(), dto.getNombre() ,TipoIdentificacionAssembler.getInstance().toDomainFromDto(dto.getTipoIdentificacion()),
				 dto.getIdentificacion(), dto.getCorreoInstitucional(), dto.getNumeroCelular(), TipoUsuarioAssembler.getInstance().toDomainFromDto(dto.getTipoUsuario()));
			
	}


	@Override
	public CoordinadorEntity toEntityFromDomain(CoordinadorDomain domain) {
		return new CoordinadorEntity(domain.getIdentificador(), domain.getNombre(), TipoIdentificacionAssembler.getInstance().toEntityFromDomain(domain.getTipoIdentificacion())
				, domain.getIdentificacion(), domain.getCorreoInstitucional(), domain.getNumeroCelular(), TipoUsuarioAssembler.getInstance().toEntityFromDomain(domain.getTipoUsuario()));
		
	}


	@Override
	public CoordinadorDomain toDomainFromEntity(CoordinadorEntity entity) {
		return new CoordinadorDomain(entity.getIdentificador(), entity.getNombre(), TipoIdentificacionAssembler.getInstance().toDomainFromEntity(entity.getTipoIdentificacion()),
				entity.getIdentificacion(), entity.getCorreoInstitucional(), entity.getNumeroCelular(), TipoUsuarioAssembler.getInstance().toDomainFromEntity(entity.getTipoUsuario()));
	}


	@Override
	public List<CoordinadorDomain> toDomainListFromEntityList(List<CoordinadorEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}


	@Override
	public List<CoordinadorDTO> toDTOListFromDomainList(List<CoordinadorDomain> domainList) {
		return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();
	}
	
	
	

}
