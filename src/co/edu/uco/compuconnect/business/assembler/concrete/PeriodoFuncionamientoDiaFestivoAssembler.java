package co.edu.uco.compuconnect.business.assembler.concrete;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.Assembler;
import co.edu.uco.compuconnect.business.domain.PeriodoFuncionamientoDiaFestivoDomain;
import co.edu.uco.compuconnect.dto.PeriodoFuncionamientoDiaFestivoDTO;
import co.edu.uco.compuconnect.entities.PeriodoFuncionamientoDiaFestivoEntity;

public final class PeriodoFuncionamientoDiaFestivoAssembler implements Assembler<PeriodoFuncionamientoDiaFestivoDomain,PeriodoFuncionamientoDiaFestivoDTO,PeriodoFuncionamientoDiaFestivoEntity>{

	private static final Assembler<PeriodoFuncionamientoDiaFestivoDomain,PeriodoFuncionamientoDiaFestivoDTO,PeriodoFuncionamientoDiaFestivoEntity> INSTANCE = new PeriodoFuncionamientoDiaFestivoAssembler();
	
	
	
	private PeriodoFuncionamientoDiaFestivoAssembler() {
		super();
	}



	public static final Assembler<PeriodoFuncionamientoDiaFestivoDomain, PeriodoFuncionamientoDiaFestivoDTO, PeriodoFuncionamientoDiaFestivoEntity> getInstance() {
		return INSTANCE;
	}



	@Override
	public PeriodoFuncionamientoDiaFestivoDTO toDTOFromDomain(PeriodoFuncionamientoDiaFestivoDomain domain) {
		return PeriodoFuncionamientoDiaFestivoDTO.create().setIdentificador(domain.getIdentificador()).setPeriodoFuncionamiento(PeriodoFuncionamientoAssembler.getInstance().toDTOFromDomain(domain.getPeriodoFuncionamiento())).
				setDiaFestivo(DiaFestivoAssembler.getInstance().toDTOFromDomain(domain.getDiaFestivo()));
	}



	@Override
	public PeriodoFuncionamientoDiaFestivoDomain toDomainFromDto(PeriodoFuncionamientoDiaFestivoDTO dto) {
		return new PeriodoFuncionamientoDiaFestivoDomain(dto.getIdentificador(),PeriodoFuncionamientoAssembler.getInstance().toDomainFromDto(dto.getPeriodoFuncionamiento()),
				DiaFestivoAssembler.getInstance().toDomainFromDto(dto.getDiaFestivo()));
	}



	@Override
	public PeriodoFuncionamientoDiaFestivoEntity toEntityFromDomain(PeriodoFuncionamientoDiaFestivoDomain domain) {
		return new PeriodoFuncionamientoDiaFestivoEntity(domain.getIdentificador(),PeriodoFuncionamientoAssembler.getInstance().toEntityFromDomain(domain.getPeriodoFuncionamiento()),
				DiaFestivoAssembler.getInstance().toEntityFromDomain(domain.getDiaFestivo()));
	}



	@Override
	public PeriodoFuncionamientoDiaFestivoDomain toDomainFromEntity(PeriodoFuncionamientoDiaFestivoEntity entity) {
		return new PeriodoFuncionamientoDiaFestivoDomain(entity.getIdentificador(),PeriodoFuncionamientoAssembler.getInstance().toDomainFromEntity(entity.getPeriodoFuncionamiento()),
				DiaFestivoAssembler.getInstance().toDomainFromEntity(entity.getDiaFestivo()));
	}



	@Override
	public List<PeriodoFuncionamientoDiaFestivoDomain> toDomainListFromEntityList(
			List<PeriodoFuncionamientoDiaFestivoEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}



	@Override
	public List<PeriodoFuncionamientoDiaFestivoDTO> toDTOListFromDomainList(
			List<PeriodoFuncionamientoDiaFestivoDomain> domainList) {
		return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();
	}
	
	
}
