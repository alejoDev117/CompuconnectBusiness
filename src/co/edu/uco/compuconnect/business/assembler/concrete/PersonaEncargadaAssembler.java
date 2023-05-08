package co.edu.uco.compuconnect.business.assembler.concrete;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.Assembler;
import co.edu.uco.compuconnect.business.domain.PersonaEncargadaDomain;
import co.edu.uco.compuconnect.dto.PersonaEncargadaDTO;
import co.edu.uco.compuconnect.entities.PersonaEncargadaEntity;

public class PersonaEncargadaAssembler implements Assembler<PersonaEncargadaDomain, PersonaEncargadaDTO, PersonaEncargadaEntity>{
	
	private static final Assembler<PersonaEncargadaDomain, PersonaEncargadaDTO, PersonaEncargadaEntity> INSTANCE = new PersonaEncargadaAssembler();
	
	private PersonaEncargadaAssembler() {
		super();
	}
	
	public static final Assembler<PersonaEncargadaDomain, PersonaEncargadaDTO, PersonaEncargadaEntity> getInstance(){
		return INSTANCE;
	}

	@Override
	public PersonaEncargadaDTO toDTOFromDomain(PersonaEncargadaDomain domain) {
		return PersonaEncargadaDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).setCorreoInstitucional
				(domain.getCorreoInstitucional()).setNumeroCelular(domain.getCorreoInstitucional());
	}

	@Override
	public PersonaEncargadaDomain toDomainFromDto(PersonaEncargadaDTO dto) {
		return new PersonaEncargadaDomain(dto.getIdentificador(), dto.getNombre(), dto.getCorreoInstitucional(), dto.getNumeroCelular());
	}

	@Override
	public PersonaEncargadaEntity toEntityFromDomain(PersonaEncargadaDomain domain) {
		return new PersonaEncargadaEntity( domain.getNombre(),domain.getIdentificador(), domain.getCorreoInstitucional(), domain.getNumeroCelular());
	}

	@Override
	public PersonaEncargadaDomain toDomainFromEntity(PersonaEncargadaEntity entity) {
		return new PersonaEncargadaDomain(entity.getIdentificador(), entity.getNombre(), entity.getCorreoInstitucional(), entity.getNumeroCelular());
	}

	@Override
	public List<PersonaEncargadaDomain> toDomainListFromEntityList(List<PersonaEncargadaEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}
	
	

}
