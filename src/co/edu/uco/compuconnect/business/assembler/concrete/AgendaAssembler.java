package co.edu.uco.compuconnect.business.assembler.concrete;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.Assembler;
import co.edu.uco.compuconnect.business.domain.AgendaDomain;
import co.edu.uco.compuconnect.crosscutting.utils.UtilUUID;
import co.edu.uco.compuconnect.dto.AgendaDTO;
import co.edu.uco.compuconnect.entities.AgendaEntity;
import co.edu.uco.compuconnect.entities.PeriodoFuncionamientoEntity;

public final  class AgendaAssembler implements Assembler<AgendaDomain,AgendaDTO,AgendaEntity> {
	
	private static final Assembler<AgendaDomain,AgendaDTO,AgendaEntity> INSTANCE = new AgendaAssembler();
	
	
	private AgendaAssembler() {
		super();
	}


	public static final Assembler<AgendaDomain, AgendaDTO, AgendaEntity> getInstance() {
		return INSTANCE;
	}


	@Override
	public AgendaDTO toDTOFromDomain(AgendaDomain domain) {
		return AgendaDTO.create().setIdentificador(domain.getIdentificador()).setPeriodoFuncionamiento(PeriodoFuncionamientoAssembler.getInstance().toDTOFromDomain(domain.getPeriodoFuncionamiento())).
				setCentroInformatica(CentroInformaticaAssembler.getInstance().toDTOFromDomain(domain.getCentroInformatica())).setNombre(domain.getNombre());
				
	}


	@Override
	public AgendaDomain toDomainFromDto(AgendaDTO dto) {
		return new AgendaDomain(dto.getIdentificador(),PeriodoFuncionamientoAssembler.getInstance().toDomainFromDto(dto.getPeriodoFuncionamiento()),
				CentroInformaticaAssembler.getInstance().toDomainFromDto(dto.getCentroInformatica()),dto.getNombre());
	}


	@Override
	public AgendaEntity toEntityFromDomain(AgendaDomain domain) {
		return new AgendaEntity(domain.getIdentificador(),PeriodoFuncionamientoAssembler.getInstance().toEntityFromDomain(domain.getPeriodoFuncionamiento()),
				CentroInformaticaAssembler.getInstance().toEntityFromDomain(domain.getCentroInformatica()),domain.getNombre());
	}


	@Override
	public AgendaDomain toDomainFromEntity(AgendaEntity entity) {
		return new AgendaDomain(entity.getIdentificador(),PeriodoFuncionamientoAssembler.getInstance().toDomainFromEntity(entity.getPeriodoFuncionamiento()),
				CentroInformaticaAssembler.getInstance().toDomainFromEntity(entity.getCentroInformatica()),entity.getNombre());
	}


	@Override
	public List<AgendaDomain> toDomainListFromEntityList(List<AgendaEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}


	@Override
	public List<AgendaDTO> toDTOListFromDomainList(List<AgendaDomain> domainList) {
		return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();
	}
	

}
