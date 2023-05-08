package co.edu.uco.compuconnect.business.assembler.concrete;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.Assembler;
import co.edu.uco.compuconnect.business.domain.SoftwareDomain;
import co.edu.uco.compuconnect.dto.SoftwareDTO;
import co.edu.uco.compuconnect.entities.SoftwareEntity;

public final class SoftwareAssembler implements Assembler<SoftwareDomain,SoftwareDTO,SoftwareEntity>{
	
	private static final Assembler<SoftwareDomain,SoftwareDTO,SoftwareEntity> INSTANCE = new SoftwareAssembler();
	
	
	
	private SoftwareAssembler() {
		super();
	}
	
	
	public static final Assembler<SoftwareDomain,SoftwareDTO,SoftwareEntity> getInstance(){
		return INSTANCE;
	}

	@Override
	public SoftwareDTO toDTOFromDomain(SoftwareDomain domain) {
		return SoftwareDTO.create().setIdentificador(domain.getIdentidicador()).setNombre(domain.getNombre()).setVersion(domain.getVersion());
	}

	@Override
	public SoftwareDomain toDomainFromDto(SoftwareDTO dto) {
		return new SoftwareDomain(dto.getIdentidicador(),dto.getNombre(),dto.getVersion());
	}

	@Override
	public SoftwareEntity toEntityFromDomain(SoftwareDomain domain) {
		return new SoftwareEntity(domain.getIdentidicador(),domain.getNombre(),domain.getVersion());
	}

	@Override
	public SoftwareDomain toDomainFromEntity(SoftwareEntity entity) {
		
		return new SoftwareDomain(entity.getIdentidicador(),entity.getNombre(),entity.getVersion());
	}


	@Override
	public List<SoftwareDomain> toDomainListFromEntityList(List<SoftwareEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}
	
	
}
