package co.edu.uco.compuconnect.business.business;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.DetalleReservaDomain;
import co.edu.uco.compuconnect.business.domain.ReservaDomain;

public interface ReservaBusiness {

	void generar(ReservaDomain datosReserva);
	
	void modificar(ReservaDomain datosModReserva);
	
	void cancelar(ReservaDomain datosEliminacionReserva);
	
	List<ReservaDomain> consultar(ReservaDomain datosFiltroReserva);
	
	
	
}
