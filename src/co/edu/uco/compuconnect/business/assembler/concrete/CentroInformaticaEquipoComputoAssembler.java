package co.edu.uco.compuconnect.business.assembler.concrete;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.Assembler;
import co.edu.uco.compuconnect.business.domain.CentroInformaticaEquipoComputoDomain;
import co.edu.uco.compuconnect.dto.CentroInformaticaEquipoComputoDTO;
import co.edu.uco.compuconnect.entities.CentroInformaticaEquipoComputoEntity;

public final class CentroInformaticaEquipoComputoAssembler implements Assembler<CentroInformaticaEquipoComputoDomain,CentroInformaticaEquipoComputoDTO,CentroInformaticaEquipoComputoEntity> {

	private static final Assembler<CentroInformaticaEquipoComputoDomain,CentroInformaticaEquipoComputoDTO,CentroInformaticaEquipoComputoEntity> INSTANCE = new CentroInformaticaEquipoComputoAssembler();
	
	private CentroInformaticaEquipoComputoAssembler() {
		super();
	}

	public static final Assembler<CentroInformaticaEquipoComputoDomain, CentroInformaticaEquipoComputoDTO, CentroInformaticaEquipoComputoEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public CentroInformaticaEquipoComputoDTO toDTOFromDomain(CentroInformaticaEquipoComputoDomain domain) {
		return CentroInformaticaEquipoComputoDTO.create().setIdentificador(domain.getIdentificador()).setCentroInformatica(CentroInformaticaAssembler.getInstance().toDTOFromDomain(domain.getCentroInformatica())).
				setEquipoComputo(EquipoComputoAssembler.getInstance().toDTOFromDomain(domain.getEquipoComputo()));
	}

	@Override
	public CentroInformaticaEquipoComputoDomain toDomainFromDto(CentroInformaticaEquipoComputoDTO dto) {
		return new CentroInformaticaEquipoComputoDomain(dto.getIdentificador(),CentroInformaticaAssembler.getInstance().toDomainFromDto(dto.getCentroInformatica()),
				EquipoComputoAssembler.getInstance().toDomainFromDto(dto.getEquipoComputo()));
	}

	@Override
	public CentroInformaticaEquipoComputoEntity toEntityFromDomain(CentroInformaticaEquipoComputoDomain domain) {
		return new  CentroInformaticaEquipoComputoEntity(domain.getIdentificador(),CentroInformaticaAssembler.getInstance().toEntityFromDomain(domain.getCentroInformatica()),
				EquipoComputoAssembler.getInstance().toEntityFromDomain(domain.getEquipoComputo()));
	}

	@Override
	public CentroInformaticaEquipoComputoDomain toDomainFromEntity(CentroInformaticaEquipoComputoEntity entity) {
		return new CentroInformaticaEquipoComputoDomain(entity.getIdentificador(),CentroInformaticaAssembler.getInstance().toDomainFromEntity(entity.getCentroInformatica()),
				EquipoComputoAssembler.getInstance().toDomainFromEntity(entity.getEquipoComputo()));
	}

	@Override
	public List<CentroInformaticaEquipoComputoDomain> toDomainListFromEntityList(
			List<CentroInformaticaEquipoComputoEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}

	@Override
	public List<CentroInformaticaEquipoComputoDTO> toDTOListFromDomainList(
			List<CentroInformaticaEquipoComputoDomain> domainList) {
		return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();
	}
	
	
	
}
