package co.edu.uco.compuconnect.business.assembler.concrete;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.Assembler;
import co.edu.uco.compuconnect.business.domain.HorarioPersonaEncargadaDomain;
import co.edu.uco.compuconnect.dto.HorarioPersonaEncargadaDTO;
import co.edu.uco.compuconnect.entities.HorarioPersonaEncargadaEntity;

public class HorarioPersonaEncargadaAssembler implements Assembler<HorarioPersonaEncargadaDomain, HorarioPersonaEncargadaDTO, HorarioPersonaEncargadaEntity> {

	private static final Assembler<HorarioPersonaEncargadaDomain, HorarioPersonaEncargadaDTO, HorarioPersonaEncargadaEntity> INSTANCE = new HorarioPersonaEncargadaAssembler();
	
	
	private HorarioPersonaEncargadaAssembler() {
		super();
	}
	
	public static final Assembler<HorarioPersonaEncargadaDomain, HorarioPersonaEncargadaDTO, HorarioPersonaEncargadaEntity> getInstance(){
		return INSTANCE;
	}

	@Override
	public HorarioPersonaEncargadaDTO toDTOFromDomain(HorarioPersonaEncargadaDomain domain) {
		return HorarioPersonaEncargadaDTO.create().setIdentificador(domain.getIdentificador()).setTiempoFuncionamiento(TiempoFuncionamientoCentroInformaticaAssembler.getInstance().
				toDTOFromDomain(domain.getTiempoFuncionamiento())).setPersonaEncargada(PersonaEncargadaAssembler.getInstance().toDTOFromDomain(domain.getPersonaEncargada()))
				.setHoraInicio(domain.getHoraInicio()).setHoraFin(domain.getHoraFin());
	}

	@Override
	public HorarioPersonaEncargadaDomain toDomainFromDto(HorarioPersonaEncargadaDTO dto) {
		return new HorarioPersonaEncargadaDomain(dto.getIdentificador(), TiempoFuncionamientoCentroInformaticaAssembler.getInstance().toDomainFromDto(dto.getTiempoFuncionamiento())
				,PersonaEncargadaAssembler.getInstance().toDomainFromDto(dto.getPersonaEncargada()), dto.getHoraInicio(), dto.getHoraFin());
	}


	
	
	@Override
	public HorarioPersonaEncargadaEntity toEntityFromDomain(HorarioPersonaEncargadaDomain domain) {
		return new HorarioPersonaEncargadaEntity(domain.getIdentificador(), TiempoFuncionamientoCentroInformaticaAssembler.getInstance().toEntityFromDomain(domain.getTiempoFuncionamiento())
				, PersonaEncargadaAssembler.getInstance().toEntityFromDomain(domain.getPersonaEncargada()), domain.getHoraInicio(), domain.getHoraFin());
	}

	@Override
	public HorarioPersonaEncargadaDomain toDomainFromEntity(HorarioPersonaEncargadaEntity entity) {
		return new HorarioPersonaEncargadaDomain(entity.getIdentificador(), TiempoFuncionamientoCentroInformaticaAssembler.getInstance().toDomainFromEntity(entity.getTiempoFuncionamiento())
				, PersonaEncargadaAssembler.getInstance().toDomainFromEntity(entity.getPersonaEncargada()), entity.getHoraInicio(), entity.getHoraFin());
	}

	@Override
	public List<HorarioPersonaEncargadaDomain> toDomainListFromEntityList(List<HorarioPersonaEncargadaEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}
	
	
	
}
