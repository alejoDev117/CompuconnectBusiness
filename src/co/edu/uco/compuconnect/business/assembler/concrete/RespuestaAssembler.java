package co.edu.uco.compuconnect.business.assembler.concrete;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.Assembler;
import co.edu.uco.compuconnect.business.domain.RespuestaDomain;
import co.edu.uco.compuconnect.dto.RespuestaDTO;
import co.edu.uco.compuconnect.entities.RespuestaEntity;

public class RespuestaAssembler implements Assembler<RespuestaDomain, RespuestaDTO, RespuestaEntity>{
	
	private static final Assembler<RespuestaDomain, RespuestaDTO, RespuestaEntity> INSTANCE = new RespuestaAssembler();
	
	private RespuestaAssembler() {
		super();
	}
	
	public static final Assembler<RespuestaDomain, RespuestaDTO, RespuestaEntity> getInstance(){
		return INSTANCE;
	}

	@Override
	public RespuestaDTO toDTOFromDomain(RespuestaDomain domain) {
		return RespuestaDTO.create().setIdentificador(domain.getIdentificador()).setAutor(CoordinadorAssembler.getInstance().toDTOFromDomain(domain.getAutor())
				).setObservacion(domain.getObservacion()).setFecha(domain.getFecha());
	}

	@Override
	public RespuestaDomain toDomainFromDto(RespuestaDTO dto) {
		return new RespuestaDomain(dto.getIdentificador(), CoordinadorAssembler.getInstance().toDomainFromDto(dto.getAutor()),
				dto.getObservacion(), dto.getFecha());
	}

	@Override
	public RespuestaEntity toEntityFromDomain(RespuestaDomain domain) {
		return new RespuestaEntity(domain.getIdentificador(), CoordinadorAssembler.getInstance().toEntityFromDomain(domain.getAutor()),
				domain.getObservacion(), domain.getFecha());
	}

	@Override
	public RespuestaDomain toDomainFromEntity(RespuestaEntity entity) {
		return new RespuestaDomain(entity.getIdentificador(), CoordinadorAssembler.getInstance().toDomainFromEntity(entity.getAutor()),
				entity.getObservacion(), entity.getFecha());
	}

	@Override
	public List<RespuestaDomain> toDomainListFromEntityList(List<RespuestaEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}

	@Override
	public List<RespuestaDTO> toDTOListFromDomainList(List<RespuestaDomain> domainList) {
		return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();
	}

}
