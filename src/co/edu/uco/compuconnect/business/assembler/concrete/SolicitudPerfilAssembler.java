package co.edu.uco.compuconnect.business.assembler.concrete;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.Assembler;
import co.edu.uco.compuconnect.business.domain.SolicitudPerfilDomain;
import co.edu.uco.compuconnect.dto.SolicitudPerfilDTO;
import co.edu.uco.compuconnect.entities.SolicitudPerfilEntity;

public class SolicitudPerfilAssembler implements Assembler<SolicitudPerfilDomain, SolicitudPerfilDTO, SolicitudPerfilEntity>{
	
	private static final Assembler<SolicitudPerfilDomain, SolicitudPerfilDTO, SolicitudPerfilEntity> INSTANCE = new SolicitudPerfilAssembler();
	
	private SolicitudPerfilAssembler(){
		super();
	}
	
	public static final  Assembler<SolicitudPerfilDomain, SolicitudPerfilDTO, SolicitudPerfilEntity> getInstance(){
		return INSTANCE;

	}

	@Override
	public SolicitudPerfilDTO toDTOFromDomain(SolicitudPerfilDomain domain) {
		return SolicitudPerfilDTO.create().setIdentificador(domain.getIdentificador()).setPerfil(PerfilAssembler.getInstance().toDTOFromDomain(domain.getPerfil()))
				.setSolicitud(SolicitudAssembler.getInstance().toDTOFromDomain(domain.getSolicitud()));
	}

	@Override
	public SolicitudPerfilDomain toDomainFromDto(SolicitudPerfilDTO dto) {
		return new SolicitudPerfilDomain(dto.getIdentificador(), SolicitudAssembler.getInstance().toDomainFromDto(dto.getSolicitud()),
				PerfilAssembler.getInstance().toDomainFromDto(dto.getPerfil()));
	}

	@Override
	public SolicitudPerfilEntity toEntityFromDomain(SolicitudPerfilDomain domain) {
		return new SolicitudPerfilEntity(domain.getIdentificador(), SolicitudAssembler.getInstance().toEntityFromDomain(domain.getSolicitud()),
				PerfilAssembler.getInstance().toEntityFromDomain(domain.getPerfil()));
	}

	@Override
	public SolicitudPerfilDomain toDomainFromEntity(SolicitudPerfilEntity entity) {
		return new SolicitudPerfilDomain(entity.getIdentificador(), SolicitudAssembler.getInstance().toDomainFromEntity(entity.getSolicitud()),
				PerfilAssembler.getInstance().toDomainFromEntity(entity.getPerfil()));
	}

	@Override
	public List<SolicitudPerfilDomain> toDomainListFromEntityList(List<SolicitudPerfilEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}
	
	
}
