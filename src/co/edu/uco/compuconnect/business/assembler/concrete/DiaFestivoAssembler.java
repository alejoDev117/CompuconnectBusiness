package co.edu.uco.compuconnect.business.assembler.concrete;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.Assembler;
import co.edu.uco.compuconnect.business.domain.DiaFestivoDomain;
import co.edu.uco.compuconnect.dto.DiaFestivoDTO;
import co.edu.uco.compuconnect.entities.DiaFestivoEntity;

public final class DiaFestivoAssembler implements Assembler<DiaFestivoDomain,DiaFestivoDTO,DiaFestivoEntity>{

	private static final Assembler<DiaFestivoDomain,DiaFestivoDTO,DiaFestivoEntity> INSTANCE = new DiaFestivoAssembler();
	
	
	private DiaFestivoAssembler() {
		super();
	}
	
	
	public static final Assembler<DiaFestivoDomain, DiaFestivoDTO, DiaFestivoEntity> getInstance() {
		return INSTANCE;
	}


	@Override
	public DiaFestivoDTO toDTOFromDomain(DiaFestivoDomain domain) {
		return DiaFestivoDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).setFecha(domain.getFecha());
	}

	@Override
	public DiaFestivoDomain toDomainFromDto(DiaFestivoDTO dto) {
		return new DiaFestivoDomain(dto.getIdentificador(),dto.getNombre(),dto.getFecha());
	}

	@Override
	public DiaFestivoEntity toEntityFromDomain(DiaFestivoDomain domain) {
		return new DiaFestivoEntity(domain.getIdentificador(),domain.getNombre(),domain.getFecha());
	}

	@Override
	public DiaFestivoDomain toDomainFromEntity(DiaFestivoEntity entity) {
		return new DiaFestivoDomain(entity.getIdentificador(),entity.getNombre(),entity.getFecha());
	}


	@Override
	public List<DiaFestivoDomain> toDomainListFromEntityList(List<DiaFestivoEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}


	@Override
	public List<DiaFestivoDTO> toDTOListFromDomainList(List<DiaFestivoDomain> domainList) {
		return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();
	}

}
