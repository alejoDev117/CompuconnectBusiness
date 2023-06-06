package co.edu.uco.compuconnect.business.assembler.concrete;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.Assembler;
import co.edu.uco.compuconnect.business.domain.TiempoFuncionamientoCentroInformaticaDomain;
import co.edu.uco.compuconnect.dto.TiempoFuncionamientoCentroInformaticaDTO;
import co.edu.uco.compuconnect.entities.TiempoFuncionamientoCentroInformaticaEntity;

public final  class TiempoFuncionamientoCentroInformaticaAssembler implements Assembler<TiempoFuncionamientoCentroInformaticaDomain,TiempoFuncionamientoCentroInformaticaDTO,TiempoFuncionamientoCentroInformaticaEntity> {

	private static final Assembler<TiempoFuncionamientoCentroInformaticaDomain,TiempoFuncionamientoCentroInformaticaDTO,TiempoFuncionamientoCentroInformaticaEntity> INSTANCE = new TiempoFuncionamientoCentroInformaticaAssembler();
	
	
	private TiempoFuncionamientoCentroInformaticaAssembler() {
		super();
	}


	public static final Assembler<TiempoFuncionamientoCentroInformaticaDomain, TiempoFuncionamientoCentroInformaticaDTO, TiempoFuncionamientoCentroInformaticaEntity> getInstance() {
		return INSTANCE;
	}


	@Override
	public TiempoFuncionamientoCentroInformaticaDTO toDTOFromDomain(TiempoFuncionamientoCentroInformaticaDomain domain) {
		return TiempoFuncionamientoCentroInformaticaDTO.create().setIdentificador(domain.getIdentificador()).setPeriodoFuncionamiento(PeriodoFuncionamientoAssembler.getInstance().toDTOFromDomain(domain.getPeriodoFuncionamiento())).
				setCentroInformatica(CentroInformaticaAssembler.getInstance().toDTOFromDomain(domain.getCentroInfomatica())).setDia(DiaSemanalAssembler.getInstance().toDTOFromDomain(domain.getDia())).
				setHoraInicio(domain.getHoraInicio()).setHoraFin(domain.getHoraFin());
				
	}


	@Override
	public TiempoFuncionamientoCentroInformaticaDomain toDomainFromDto(TiempoFuncionamientoCentroInformaticaDTO dto) {
		return new TiempoFuncionamientoCentroInformaticaDomain(dto.getIdentificador(),PeriodoFuncionamientoAssembler.getInstance().toDomainFromDto(dto.getPeriodoFuncionamiento()),
				CentroInformaticaAssembler.getInstance().toDomainFromDto(dto.getCentroInfomatica()),
				DiaSemanalAssembler.getInstance().toDomainFromDto(dto.getDia()),dto.getHoraInicio(),dto.getHoraFin());
	}


	@Override
	public TiempoFuncionamientoCentroInformaticaEntity toEntityFromDomain(
			TiempoFuncionamientoCentroInformaticaDomain domain) {
		return new TiempoFuncionamientoCentroInformaticaEntity(domain.getIdentificador(),
				PeriodoFuncionamientoAssembler.getInstance().toEntityFromDomain(domain.getPeriodoFuncionamiento()),
				CentroInformaticaAssembler.getInstance().toEntityFromDomain(domain.getCentroInfomatica()),
				DiaSemanalAssembler.getInstance().toEntityFromDomain(domain.getDia()),domain.getHoraInicio(),domain.getHoraFin());
	}


	@Override
	public TiempoFuncionamientoCentroInformaticaDomain toDomainFromEntity(
			TiempoFuncionamientoCentroInformaticaEntity entity) {
		return new TiempoFuncionamientoCentroInformaticaDomain(entity.getIdentificador(),
				PeriodoFuncionamientoAssembler.getInstance().toDomainFromEntity(entity.getPeriodoFuncionamiento()),
				CentroInformaticaAssembler.getInstance().toDomainFromEntity(entity.getCentroInfomatica()),
				DiaSemanalAssembler.getInstance().toDomainFromEntity(entity.getDia()),entity.getHoraInicio(),entity.getHoraFin());
	}


	@Override
	public List<TiempoFuncionamientoCentroInformaticaDomain> toDomainListFromEntityList(
			List<TiempoFuncionamientoCentroInformaticaEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}


	@Override
	public List<TiempoFuncionamientoCentroInformaticaDTO> toDTOListFromDomainList(
			List<TiempoFuncionamientoCentroInformaticaDomain> domainList) {
		return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();
	}


	@Override
	public List<TiempoFuncionamientoCentroInformaticaDomain> toDomainListFromDTOList(
			List<TiempoFuncionamientoCentroInformaticaDTO> dtoList) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<TiempoFuncionamientoCentroInformaticaEntity> toEntityListFromDomainList(
			List<TiempoFuncionamientoCentroInformaticaDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
