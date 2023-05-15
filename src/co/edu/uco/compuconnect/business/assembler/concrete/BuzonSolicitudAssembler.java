package co.edu.uco.compuconnect.business.assembler.concrete;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.Assembler;
import co.edu.uco.compuconnect.business.domain.BuzonSolicitudDomain;
import co.edu.uco.compuconnect.business.domain.RespuestaDomain;
import co.edu.uco.compuconnect.dto.BuzonSolicitudDTO;
import co.edu.uco.compuconnect.entities.BuzonSolicitudEntity;

public class BuzonSolicitudAssembler implements Assembler<BuzonSolicitudDomain, BuzonSolicitudDTO, BuzonSolicitudEntity>{
	
	private static final Assembler<BuzonSolicitudDomain, BuzonSolicitudDTO, BuzonSolicitudEntity> INSTANCE = new BuzonSolicitudAssembler();
	
	private BuzonSolicitudAssembler() {
		super();
	}
	
	public static final Assembler<BuzonSolicitudDomain, BuzonSolicitudDTO, BuzonSolicitudEntity> getInstance(){
		return INSTANCE;
	}

	@Override
	public BuzonSolicitudDTO toDTOFromDomain(BuzonSolicitudDomain domain) {
		return BuzonSolicitudDTO.create().setIdentificador(domain.getIdentificador()).setSolicitud(SolicitudAssembler.getInstance().toDTOFromDomain(domain.getSolicitud())
				).setRespuesta(RespuestaAssembler.getInstance().toDTOFromDomain(domain.getRespuesta()));
	}

	@Override
	public BuzonSolicitudDomain toDomainFromDto(BuzonSolicitudDTO dto) {
		return new BuzonSolicitudDomain(dto.getIdentificador(), SolicitudAssembler.getInstance().toDomainFromDto(dto.getSolicitud()), 
				RespuestaAssembler.getInstance().toDomainFromDto(dto.getRespuesta()));
	}

	@Override
	public BuzonSolicitudEntity toEntityFromDomain(BuzonSolicitudDomain domain) {
		return new BuzonSolicitudEntity(domain.getIdentificador(), SolicitudAssembler.getInstance().toEntityFromDomain(domain.getSolicitud()),
				RespuestaAssembler.getInstance().toEntityFromDomain(domain.getRespuesta()));
	}

	@Override
	public BuzonSolicitudDomain toDomainFromEntity(BuzonSolicitudEntity entity) {
		return new BuzonSolicitudDomain(entity.getIdentificador(), SolicitudAssembler.getInstance().toDomainFromEntity(entity.getSolicitud()),
				RespuestaAssembler.getInstance().toDomainFromEntity(entity.getRespuesta()));
	}

	@Override
	public List<BuzonSolicitudDomain> toDomainListFromEntityList(List<BuzonSolicitudEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}

	@Override
	public List<BuzonSolicitudDTO> toDTOListFromDomainList(List<BuzonSolicitudDomain> domainList) {
		return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();
	}

}
