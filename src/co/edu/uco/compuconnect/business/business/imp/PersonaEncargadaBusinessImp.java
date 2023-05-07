package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.business.PersonaEncargadaBusiness;
import co.edu.uco.compuconnect.business.domain.PersonaEncargadaDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;

public final class PersonaEncargadaBusinessImp implements PersonaEncargadaBusiness{
	
	private DAOFactory daoFactory;
	
	public PersonaEncargadaBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void crear(PersonaEncargadaDomain datosPersonaEncargada) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(PersonaEncargadaDomain datosModificacionPersonaEncargada) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(PersonaEncargadaDomain datosEliminacionPersonaEncargada) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PersonaEncargadaDomain> consultar(PersonaEncargadaDomain datosFiltroPersonaEncargada) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
