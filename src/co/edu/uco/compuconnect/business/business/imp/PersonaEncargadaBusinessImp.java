package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.PersonaEncargadaAssembler;
import co.edu.uco.compuconnect.business.business.PersonaEncargadaBusiness;
import co.edu.uco.compuconnect.business.domain.PersonaEncargadaDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.entities.PersonaEncargadaEntity;

public final class PersonaEncargadaBusinessImp implements PersonaEncargadaBusiness{
	
	private DAOFactory daoFactory;
	
	public PersonaEncargadaBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void crear(PersonaEncargadaDomain datosPersonaEncargada) {
		final PersonaEncargadaEntity entity = PersonaEncargadaAssembler.getInstance().toEntityFromDomain(datosPersonaEncargada);
		daoFactory.getPersonaEncargadaDAO().create(entity);
		
	}

	@Override
	public void modificar(PersonaEncargadaDomain datosModificacionPersonaEncargada) {
		final PersonaEncargadaEntity entity = PersonaEncargadaAssembler.getInstance().toEntityFromDomain(datosModificacionPersonaEncargada);
		daoFactory.getPersonaEncargadaDAO().update(entity);
		
	}

	@Override
	public void eliminar(PersonaEncargadaDomain datosEliminacionPersonaEncargada) {
		final PersonaEncargadaEntity entity = PersonaEncargadaAssembler.getInstance().toEntityFromDomain(datosEliminacionPersonaEncargada);
		daoFactory.getPersonaEncargadaDAO().delete(entity);
		
	}

	@Override
	public List<PersonaEncargadaDomain> consultar(PersonaEncargadaDomain datosFiltroPersonaEncargada) {
		final PersonaEncargadaEntity entity = PersonaEncargadaAssembler.getInstance().toEntityFromDomain(datosFiltroPersonaEncargada);
		final List<PersonaEncargadaEntity> result = daoFactory.getPersonaEncargadaDAO().read(entity);
		return PersonaEncargadaAssembler.getInstance().toDomainListFromEntityList(result);
	}
	
	
	

}
