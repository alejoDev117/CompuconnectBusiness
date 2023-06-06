package co.edu.uco.compuconnect.business.assembler.concrete;

import java.util.List;


import co.edu.uco.compuconnect.business.assembler.Assembler;
import co.edu.uco.compuconnect.business.domain.ReservaPerfilDomain;
import co.edu.uco.compuconnect.dto.ReservaPerfilDTO;
import co.edu.uco.compuconnect.entities.ReservaPerfilEntity;

public class ReservaPerfilAssembler implements Assembler<ReservaPerfilDomain, ReservaPerfilDTO, ReservaPerfilEntity> {
	
	private static final Assembler<ReservaPerfilDomain, ReservaPerfilDTO, ReservaPerfilEntity> INSTANCE = new ReservaPerfilAssembler();
	
	private ReservaPerfilAssembler() {
		super();
	}
	
	public static final Assembler<ReservaPerfilDomain, ReservaPerfilDTO, ReservaPerfilEntity> getInstance(){
		return INSTANCE;
	}

	@Override
	public ReservaPerfilDTO toDTOFromDomain(ReservaPerfilDomain domain) {
		return ReservaPerfilDTO.create().setIdentificador(domain.getIdentificador()).setPerfil(PerfilAssembler.getInstance().toDTOFromDomain(domain.getPerfil()))
				.setReserva(ReservaAssembler.getInstance().toDTOFromDomain(domain.getReserva()));
	}

	@Override
	public ReservaPerfilDomain toDomainFromDto(ReservaPerfilDTO dto) {
		return new ReservaPerfilDomain(dto.getIdentificador(), ReservaAssembler.getInstance().toDomainFromDto(dto.getReserva()),
				PerfilAssembler.getInstance().toDomainFromDto(dto.getPerfil()));
	}

	@Override
	public ReservaPerfilEntity toEntityFromDomain(ReservaPerfilDomain domain) {
		return new ReservaPerfilEntity(domain.getIdentificador(), ReservaAssembler.getInstance().toEntityFromDomain(domain.getReserva()),
				PerfilAssembler.getInstance().toEntityFromDomain(domain.getPerfil()));
	}

	@Override
	public ReservaPerfilDomain toDomainFromEntity(ReservaPerfilEntity entity) {
		return new ReservaPerfilDomain(entity.getIdentificador(), ReservaAssembler.getInstance().toDomainFromEntity(entity.getReserva()),
				PerfilAssembler.getInstance().toDomainFromEntity(entity.getPerfil()));
	}

	@Override
	public List<ReservaPerfilDomain> toDomainListFromEntityList(List<ReservaPerfilEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}

	@Override
	public List<ReservaPerfilDTO> toDTOListFromDomainList(List<ReservaPerfilDomain> domainList) {
		return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();
	}

	@Override
	public List<ReservaPerfilDomain> toDomainListFromDTOList(List<ReservaPerfilDTO> dtoList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReservaPerfilEntity> toEntityListFromDomainList(List<ReservaPerfilDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
