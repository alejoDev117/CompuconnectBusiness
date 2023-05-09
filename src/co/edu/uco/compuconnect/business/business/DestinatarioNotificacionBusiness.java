package co.edu.uco.compuconnect.business.business;

<<<<<<< Updated upstream
=======
import java.util.List;

import co.edu.uco.compuconnect.business.domain.DestinatarioDomain;
import co.edu.uco.compuconnect.business.domain.DestinatarioNotificacionDomain;

>>>>>>> Stashed changes
public interface  DestinatarioNotificacionBusiness {
	
	void crear(DestinatarioNotificacionDomain datosCreacionDestinatarioNotificacion);
	
	List<DestinatarioNotificacionDomain> consultar(DestinatarioNotificacionDomain datosFiltroDestinatario);
	
	void eliminar(DestinatarioNotificacionDomain datosEliminacionDestinatarioNotificacion);
	
	
}
