package co.edu.uco.compuconnect.business.business;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.RespuestaDomain;

public interface RespuestaBusiness {

	void realizar(RespuestaDomain datosRespuesa);
	
	void eliminar(RespuestaDomain datosEliminacionRespuesta);
	
	List<RespuestaDomain> consultar(RespuestaDomain datosFiltroRespuesta);
	
	
	
}
