package co.edu.uco.compuconnect.business.assembler.concrete;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.Assembler;
import co.edu.uco.compuconnect.business.domain.MonitorDomain;
import co.edu.uco.compuconnect.dto.MonitorDTO;
import co.edu.uco.compuconnect.entities.MonitorEntity;

public final class MonitorAssembler implements Assembler<MonitorDomain,MonitorDTO,MonitorEntity> {
	
	private static final Assembler<MonitorDomain,MonitorDTO,MonitorEntity> INSTANCE = new MonitorAssembler();
	
	
	private MonitorAssembler() {
		super();
		
	}


	public static final Assembler<MonitorDomain, MonitorDTO, MonitorEntity> getInstance() {
		return INSTANCE;
	}


	@Override
	public MonitorDTO toDTOFromDomain(MonitorDomain domain) {
		return MonitorDTO.create().setIdentificador(domain.getIdentificador()).
				setTipoIdentificacion(TipoIdentificacionAssembler.getInstance().toDTOFromDomain(domain.getTipoIdentificacion())).
				setIdentificacion(domain.getIdentificacion()).setNombre(domain.getNombre()).setCorreoInstitucional(domain.getCorreoInstitucional()).
						setNumeroCelular(domain.getNumeroCelular()).setTipoUsuario(TipoUsuarioAssembler.getInstance().toDTOFromDomain(domain.getTipoUsuario()));
				
	}


	@Override
	public MonitorDomain toDomainFromDto(MonitorDTO dto) {
		return new MonitorDomain(dto.getIdentificador(),dto.getNombre(),TipoIdentificacionAssembler.getInstance().toDomainFromDto(dto.getTipoIdentificacion()),
				dto.getIdentificacion(),dto.getCorreoInstitucional(),dto.getNumeroCelular(), TipoUsuarioAssembler.getInstance().toDomainFromDto(dto.getTipoUsuario()));
	}


	@Override
	public MonitorEntity toEntityFromDomain(MonitorDomain domain) {
		return new MonitorEntity(domain.getIdentificador(),domain.getNombre(),TipoIdentificacionAssembler.getInstance().toEntityFromDomain(domain.getTipoIdentificacion()),
				domain.getIdentificacion(),domain.getCorreoInstitucional(),domain.getNumeroCelular(), TipoUsuarioAssembler.getInstance().toEntityFromDomain(domain.getTipoUsuario()));
	}


	@Override
	public MonitorDomain toDomainFromEntity(MonitorEntity entity) {
		return new MonitorDomain(entity.getIdentificador(),entity.getNombre(),TipoIdentificacionAssembler.getInstance().toDomainFromEntity(entity.getTipoIdentificacion()),
				entity.getIdentificacion(),entity.getCorreoInstitucional(),entity.getNumeroCelular(), TipoUsuarioAssembler.getInstance().toDomainFromEntity(entity.getTipoUsuario()));
	}


	@Override
	public List<MonitorDomain> toDomainListFromEntityList(List<MonitorEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}


	@Override
	public List<MonitorDTO> toDTOListFromDomainList(List<MonitorDomain> domainList) {
		return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();
	}


	@Override
	public List<MonitorDomain> toDomainListFromDTOList(List<MonitorDTO> dtoList) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<MonitorEntity> toEntityListFromDomainList(List<MonitorDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
