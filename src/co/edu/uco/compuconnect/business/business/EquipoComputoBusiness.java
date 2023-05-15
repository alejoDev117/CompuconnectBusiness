package co.edu.uco.compuconnect.business.business;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.EquipoComputoDomain;

public interface EquipoComputoBusiness {

	void registrar(EquipoComputoDomain datosEquipoComputo);
	
	void modificar(EquipoComputoDomain datosMotificacionEquipoComputo);
	
	List<EquipoComputoDomain> consultar(EquipoComputoDomain datosFiltroEquipoComputo);
	
	void eliminar(EquipoComputoDomain datosBorrarEquipoComputo);
	
	
}
