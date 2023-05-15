package co.edu.uco.compuconnect.business.assembler.concrete;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.Assembler;
import co.edu.uco.compuconnect.business.domain.ReservaDomain;
import co.edu.uco.compuconnect.dto.ReservaDTO;
import co.edu.uco.compuconnect.entities.ReservaEntity;

public final class ReservaAssembler implements Assembler<ReservaDomain,ReservaDTO,ReservaEntity>{
	
	private static final Assembler<ReservaDomain,ReservaDTO,ReservaEntity> INSTANCE = new ReservaAssembler();
	
	
	private ReservaAssembler() {
		super();
	}


	public static final Assembler<ReservaDomain, ReservaDTO, ReservaEntity> getInstance() {
		return INSTANCE;
	}


	@Override
	public ReservaDTO toDTOFromDomain(ReservaDomain domain) {
		return ReservaDTO.create().setIdentificador(domain.getIdentificador()).
				setAutor(UsuarioAssembler.getInstance().toDTOFromDomain(domain.getAutor())).
				setTipoReserva(TipoReservaAssembler.getInstance().toDTOFromDomain(domain.getTipoReserva())).
				setFechaInicio(domain.getFechaInicio()).setFechaFin(domain.getFechaFin()).
				setFrecuencia(FrecuenciaAssembler.getInstance().toDTOFromDomain(domain.getFrecuencia())).
				setCentroInformatica(CentroInformaticaAssembler.getInstance().toDTOFromDomain(domain.getCentroInformatica())).
				setDescripcion(domain.getDescripcion()).setHoraCreacion(domain.getHoraCreacion());
	}


	@Override
	public ReservaDomain toDomainFromDto(ReservaDTO dto) {
		return new ReservaDomain(dto.getIdentificador(),UsuarioAssembler.getInstance().toDomainFromDto(dto.getAutor()),
				TipoReservaAssembler.getInstance().toDomainFromDto(dto.getTipoReserva()),dto.getFechaInicio(),dto.getFechaFin(),
				FrecuenciaAssembler.getInstance().toDomainFromDto(dto.getFrecuencia()),CentroInformaticaAssembler.getInstance().toDomainFromDto(dto.getCentroInformatica()),
				dto.getDescripcion(),dto.getHoraCreacion());
	}


	@Override
	public ReservaEntity toEntityFromDomain(ReservaDomain domain) {
		return new ReservaEntity(domain.getIdentificador(),UsuarioAssembler.getInstance().toEntityFromDomain(domain.getAutor()),
				TipoReservaAssembler.getInstance().toEntityFromDomain(domain.getTipoReserva()),domain.getFechaInicio(),domain.getFechaFin(),
				FrecuenciaAssembler.getInstance().toEntityFromDomain(domain.getFrecuencia()),CentroInformaticaAssembler.getInstance().toEntityFromDomain(domain.getCentroInformatica()),
				domain.getDescripcion(),domain.getHoraCreacion());
	}


	@Override
	public ReservaDomain toDomainFromEntity(ReservaEntity entity) {
		return new ReservaDomain(entity.getIdentificador(),UsuarioAssembler.getInstance().toDomainFromEntity(entity.getAutor()),
				TipoReservaAssembler.getInstance().toDomainFromEntity(entity.getTipoReserva()),entity.getFechaInicio(),entity.getFechaFin(),
				FrecuenciaAssembler.getInstance().toDomainFromEntity(entity.getFrecuencia()),CentroInformaticaAssembler.getInstance().toDomainFromEntity(entity.getCentroInformatica()),
				entity.getDescripcion(),entity.getHoraCreacion());
	}


	@Override
	public List<ReservaDomain> toDomainListFromEntityList(List<ReservaEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}


	@Override
	public List<ReservaDTO> toDTOListFromDomainList(List<ReservaDomain> domainList) {
		return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();
	}
	
	
	

}
