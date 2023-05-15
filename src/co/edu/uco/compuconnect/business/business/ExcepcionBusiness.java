package co.edu.uco.compuconnect.business.business;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.ExcepcionDomain;

public interface ExcepcionBusiness {

	void generar(ExcepcionDomain datosExcepcion);
	
	void modificar(ExcepcionDomain datosModificacionExcepcion);
	
	void eliminar(ExcepcionDomain datosBorrarExcepcion);
	
	List<ExcepcionDomain> consultar(ExcepcionDomain datosFiltroExcepcion);
	
	
}
