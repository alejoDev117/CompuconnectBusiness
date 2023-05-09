package co.edu.uco.compuconnect.business.business;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.CentroInformaticaDomain;
import co.edu.uco.compuconnect.business.domain.CentroInformaticaEquipoComputoDomain;

public interface CentroInformaticaEquipoComputoBusiness {
	
	void crear(CentroInformaticaEquipoComputoDomain datosCentroInformaticaEquipoComputo);
	
	List<CentroInformaticaEquipoComputoDomain> consultar(CentroInformaticaEquipoComputoDomain datosFiltroCentroInformaticaEquipoComputo);
	
	void eliminar (CentroInformaticaEquipoComputoDomain datosEliminacionCentroInformaticaEquipoComputo);

}
