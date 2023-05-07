package co.edu.uco.compuconnect.business.business;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.SoftwareDomain;

public interface SoftwareBusiness {

	void añadir(SoftwareDomain datosSoftware);
	
	void eliminar(SoftwareDomain datosBorrarSoftware);
	
	List<SoftwareDomain> consultar(SoftwareDomain datosFiltroSoftware);
	
}
