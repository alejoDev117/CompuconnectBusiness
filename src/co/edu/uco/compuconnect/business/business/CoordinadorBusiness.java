package co.edu.uco.compuconnect.business.business;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.CoordinadorDomain;

public interface CoordinadorBusiness {

	void registrar(CoordinadorDomain datosCoordinador);
	
	void modificar(CoordinadorDomain datosActualizacionCoordinador);
	
	List<CoordinadorDomain> consultar(CoordinadorDomain datosFiltroCoordiandor);
	
	void eliminar(CoordinadorDomain datosEliminacionCoordinador);
	
}
