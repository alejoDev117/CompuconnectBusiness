package co.edu.uco.compuconnect.business.business;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.TiempoFuncionamientoCentroInformaticaDomain;

public interface TiempoFuncionamientoCentroInformaticaBusiness {

	void crear(TiempoFuncionamientoCentroInformaticaDomain datosCreacionTiempoFuncionamientoCentroInformatica);
	
	void eliminar(TiempoFuncionamientoCentroInformaticaDomain datosBorradoTiempoFuncionamientoCentroInformatica);
	
	List<TiempoFuncionamientoCentroInformaticaDomain> consultar(TiempoFuncionamientoCentroInformaticaDomain datosFiltroTiempoFuncionamientoCentroInformatica);
	
	
}
