package co.edu.uco.compuconnect.business.business;

import java.util.List;

public interface RespuestaBusiness {

	void realizar(RespuestaDomain datosRespuesa);
	
	void eliminar(RespuestaDomain datosEliminacionRespuesta);
	
	List<RespuestaDomain> consultar(RespuestaDomain datosFiltroRespuesta);
	
	
	
}
