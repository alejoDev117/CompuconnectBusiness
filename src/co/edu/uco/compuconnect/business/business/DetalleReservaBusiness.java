package co.edu.uco.compuconnect.business.business;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.DetalleReservaDomain;

public  interface DetalleReservaBusiness{
	
	void crear(DetalleReservaDomain datosDetalleReserva);
	
	void modificar(DetalleReservaDomain datosModificacionDetalleReserva);
	
	void eliminar(DetalleReservaDomain datosEliminacionDetalleReserva);
	
	List<DetalleReservaDomain> consultar(DetalleReservaDomain datosFiltroDetalleReserva);
	
	

}
