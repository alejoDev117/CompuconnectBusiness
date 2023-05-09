package co.edu.uco.compuconnect.business.business;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.ReservaPerfilDomain;

public interface ReservaPerfilBusiness {
	
void crear(ReservaPerfilDomain datosReservaPerfil);
	
	List<ReservaPerfilDomain>consultar(ReservaPerfilDomain datosFiltroReservaPerfil);
	
	void eliminar(ReservaPerfilDomain datosEliminacionReservaPerfil);


}
