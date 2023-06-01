package co.edu.uco.compuconnect.business.business;

import java.util.List;


import co.edu.uco.compuconnect.business.domain.CentroInformaticaDomain;

public interface CentroInformaticaBusiness {

	void crear(CentroInformaticaDomain datosCentroInformatica);
	
	List<CentroInformaticaDomain> consultar(CentroInformaticaDomain datosFiltroCentroInformatica);
	
	void modificar(CentroInformaticaDomain datosModCentroInformatica);
	
	void eliminar(CentroInformaticaDomain identificadorEliminacionCentroInformatica);
	
	
}
