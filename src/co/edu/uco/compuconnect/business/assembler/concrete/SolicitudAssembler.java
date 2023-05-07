package co.edu.uco.compuconnect.business.assembler.concrete;

import co.edu.uco.compuconnect.business.assembler.Assembler;
import co.edu.uco.compuconnect.business.domain.SolicitudDomain;
import co.edu.uco.compuconnect.dto.SolicitudDTO;
import co.edu.uco.compuconnect.entities.SolicitudEntity;

public final class SolicitudAssembler implements Assembler<SolicitudDomain,SolicitudDTO,SolicitudEntity>{
	
	private static final Assembler<SolicitudDomain,SolicitudDTO,SolicitudEntity> INSTANCE = new SolicitudAssembler();
	
	private SolicitudAssembler() {
		super();
	}

	public static final Assembler<SolicitudDomain, SolicitudDTO, SolicitudEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public SolicitudDTO toDTOFromDomain(SolicitudDomain domain) {
		return SolicitudDTO.create().setIdentificador(domain.getIdentificador()).
				setAutor(UsuarioAssembler.getInstance().toDTOFromDomain(domain.getAutor())).
				setTipoSolicitud(TipoSolicitudAssembler.getInstance().toDTOFromDomain(domain.getTipoSolicitud())).
				setDescripcion(domain.getDescripcion()).setEstadoSolicitud(EstadoSolicitudAssembler.getInstance().toDTOFromDomain(domain.getEstadoSolicitud())).
				setHoraCreacion(domain.getHoraCreacion());
		
	}

	@Override
	public SolicitudDomain toDomainFromDto(SolicitudDTO dto) {
		return new SolicitudDomain(dto.getIdentificador(),UsuarioAssembler.getInstance().toDomainFromDto(dto.getAutor()),
				TipoSolicitudAssembler.getInstance().toDomainFromDto(dto.getTipoSolicitud()),dto.getDescripcion(),dto.getHoraCreacion(),
				EstadoSolicitudAssembler.getInstance().toDomainFromDto(dto.getEstadoSolicitud()));
	}

	@Override
	public SolicitudEntity toEntityFromDomain(SolicitudDomain domain) {
		return new SolicitudEntity(domain.getIdentificador(),UsuarioAssembler.getInstance().toEntityFromDomain(domain.getAutor()),
				TipoSolicitudAssembler.getInstance().toEntityFromDomain(domain.getTipoSolicitud()),domain.getDescripcion(),domain.getHoraCreacion(),
				EstadoSolicitudAssembler.getInstance().toEntityFromDomain(domain.getEstadoSolicitud()));
	}
	

	@Override
	public SolicitudDomain toDomainFromEntity(SolicitudEntity entity) {
		return new SolicitudDomain(entity.getIdentificador(),UsuarioAssembler.getInstance().toDomainFromEntity(entity.getAutor()),
				TipoSolicitudAssembler.getInstance().toDomainFromEntity(entity.getTipoSolicitud()),entity.getDescripcion(),entity.getHoraCreacion(),
				EstadoSolicitudAssembler.getInstance().toDomainFromEntity(entity.getEstadoSolicitud()));
	}
	
	

}
