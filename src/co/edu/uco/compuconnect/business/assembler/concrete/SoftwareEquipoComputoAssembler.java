package co.edu.uco.compuconnect.business.assembler.concrete;

import co.edu.uco.compuconnect.business.assembler.Assembler;
import co.edu.uco.compuconnect.business.domain.SoftwareEquipoComputoDomain;
import co.edu.uco.compuconnect.dto.SoftwareEquipoComputoDTO;
import co.edu.uco.compuconnect.entities.SoftwareEquipoComputoEntity;

public final class SoftwareEquipoComputoAssembler implements Assembler<SoftwareEquipoComputoDomain,SoftwareEquipoComputoDTO,SoftwareEquipoComputoEntity> {

	private static final Assembler<SoftwareEquipoComputoDomain,SoftwareEquipoComputoDTO,SoftwareEquipoComputoEntity> INSTANCE = new SoftwareEquipoComputoAssembler();
	
	
	private SoftwareEquipoComputoAssembler() {
		super();
	}


	public static final Assembler<SoftwareEquipoComputoDomain, SoftwareEquipoComputoDTO, SoftwareEquipoComputoEntity> getInstance() {
		return INSTANCE;
	}


	@Override
	public SoftwareEquipoComputoDTO toDTOFromDomain(SoftwareEquipoComputoDomain domain) {
		return SoftwareEquipoComputoDTO.create().setIdentificador(domain.getIdentificador()).setSoftware(SoftwareAssembler.getInstance().toDTOFromDomain(domain.getSoftware())).
				setEquipoComputo(EquipoComputoAssembler.getInstance().toDTOFromDomain(domain.getEquipoComputo()));
	}


	@Override
	public SoftwareEquipoComputoDomain toDomainFromDto(SoftwareEquipoComputoDTO dto) {
		return new SoftwareEquipoComputoDomain(dto.getIdentificador(),SoftwareAssembler.getInstance().toDomainFromDto(dto.getSoftware()),
				EquipoComputoAssembler.getInstance().toDomainFromDto(dto.getEquipoComputo()));
	}


	@Override
	public SoftwareEquipoComputoEntity toEntityFromDomain(SoftwareEquipoComputoDomain domain) {
		return new SoftwareEquipoComputoEntity(domain.getIdentificador(),SoftwareAssembler.getInstance().toEntityFromDomain(domain.getSoftware()),
				EquipoComputoAssembler.getInstance().toEntityFromDomain(domain.getEquipoComputo()));
	}


	@Override
	public SoftwareEquipoComputoDomain toDomainFromEntity(SoftwareEquipoComputoEntity entity) {
		return new SoftwareEquipoComputoDomain(entity.getIdentificador(),SoftwareAssembler.getInstance().toDomainFromEntity(entity.getSoftware()),
				EquipoComputoAssembler.getInstance().toDomainFromEntity(entity.getEquipoComputo()));
	}
	
	
	
}
