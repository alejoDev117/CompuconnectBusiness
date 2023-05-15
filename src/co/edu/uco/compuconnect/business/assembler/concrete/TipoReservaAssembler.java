package co.edu.uco.compuconnect.business.assembler.concrete;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.Assembler;
import co.edu.uco.compuconnect.business.domain.TipoReservaDomain;
import co.edu.uco.compuconnect.dto.TipoReservaDTO;
import co.edu.uco.compuconnect.entities.TipoReservaEntity;

public final class TipoReservaAssembler implements Assembler<TipoReservaDomain,TipoReservaDTO,TipoReservaEntity> {
	
	private static final Assembler<TipoReservaDomain,TipoReservaDTO,TipoReservaEntity> INSTANCE = new TipoReservaAssembler();
	
	private TipoReservaAssembler() {
		super();
	}

	public static final Assembler<TipoReservaDomain, TipoReservaDTO, TipoReservaEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public TipoReservaDTO toDTOFromDomain(TipoReservaDomain domain) {
		return TipoReservaDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).setDescripcion(domain.getDescripcion());
	}

	@Override
	public TipoReservaDomain toDomainFromDto(TipoReservaDTO dto) {
		return new TipoReservaDomain(dto.getIdentificador(),dto.getNombre(),dto.getDescripcion());
	}

	@Override
	public TipoReservaEntity toEntityFromDomain(TipoReservaDomain domain) {
		return new TipoReservaEntity(domain.getIdentificador(),domain.getNombre(),domain.getDescripcion());
	}

	@Override
	public TipoReservaDomain toDomainFromEntity(TipoReservaEntity entity) {
		return new TipoReservaDomain(entity.getIdentificador(),entity.getNombre(),entity.getDescripcion());
	}

	@Override
	public List<TipoReservaDomain> toDomainListFromEntityList(List<TipoReservaEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}

	@Override
	public List<TipoReservaDTO> toDTOListFromDomainList(List<TipoReservaDomain> domainList) {
		return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();
	}
	
	

}
