package co.edu.uco.compuconnect.business.business;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.ContenidoDomain;

public interface ContenidoBusiness {
	
	void crear(ContenidoDomain datosContenido);
	
	void eliminar(ContenidoDomain datosEliminacionContenido);
	
	List<ContenidoDomain> consultar(ContenidoDomain datosFiltroContenido);
	
	
}
