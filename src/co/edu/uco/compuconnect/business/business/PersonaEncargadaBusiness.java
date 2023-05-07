package co.edu.uco.compuconnect.business.business;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.PersonaEncargadaDomain;

public interface PersonaEncargadaBusiness {

	void crear(PersonaEncargadaDomain datosPersonaEncargada);
	
	void modificar(PersonaEncargadaDomain datosModificacionPersonaEncargada);
	
	void eliminar(PersonaEncargadaDomain datosEliminacionPersonaEncargada);
	
	List<PersonaEncargadaDomain> consultar(PersonaEncargadaDomain datosFiltroPersonaEncargada);
	
	
}
