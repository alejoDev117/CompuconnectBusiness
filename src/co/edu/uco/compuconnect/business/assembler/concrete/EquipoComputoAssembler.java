package co.edu.uco.compuconnect.business.assembler.concrete;

import co.edu.uco.compuconnect.business.assembler.Assembler;
import co.edu.uco.compuconnect.business.domain.EquipoComputoDomain;
import co.edu.uco.compuconnect.dto.EquipoComputoDTO;
import co.edu.uco.compuconnect.entities.EquipoComputoEntity;

public final class EquipoComputoAssembler implements Assembler<EquipoComputoDomain,EquipoComputoDTO,EquipoComputoEntity> {
	
	private static final Assembler<EquipoComputoDomain,EquipoComputoDTO,EquipoComputoEntity> INSTANCE = new EquipoComputoAssembler();
	
	private EquipoComputoAssembler() {
		super();
	}

	public static final Assembler<EquipoComputoDomain, EquipoComputoDTO, EquipoComputoEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public EquipoComputoDTO toDTOFromDomain(EquipoComputoDomain domain) {
		return EquipoComputoDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).setEstado(EstadoEquipoComputoAssembler.getInstance().toDTOFromDomain(domain.getEstado()).setNombre(domain.getNombre()));
	}

	@Override
	public EquipoComputoDomain toDomainFromDto(EquipoComputoDTO dto) {
		return new EquipoComputoDomain(dto.getIdentificador(),dto.getNombre(),EstadoEquipoComputoAssembler.getInstance().toDomainFromDto(dto.getEstado()));
	}

	@Override
	public EquipoComputoEntity toEntityFromDomain(EquipoComputoDomain domain) {
		return new EquipoComputoEntity(domain.getIdentificador(),domain.getNombre(),EstadoEquipoComputoAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
	}

	@Override
	public EquipoComputoDomain toDomainFromEntity(EquipoComputoEntity entity) {
		return new EquipoComputoDomain(entity.getIdentificador(),entity.getNombre(),EstadoEquipoComputoAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
	}
	
	
	

}