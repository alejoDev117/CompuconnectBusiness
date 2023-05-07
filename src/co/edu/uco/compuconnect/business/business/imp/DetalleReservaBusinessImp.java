package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.business.DetalleReservaBusiness;
import co.edu.uco.compuconnect.business.domain.DetalleReservaDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;

public final class DetalleReservaBusinessImp implements DetalleReservaBusiness{
	
	private DAOFactory daoFactory;
	
	
	public DetalleReservaBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}


	@Override
	public void crear(DetalleReservaDomain datosDetalleReserva) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void modificar(DetalleReservaDomain datosModificacionDetalleReserva) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void eliminar(DetalleReservaDomain datosEliminacionDetalleReserva) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<DetalleReservaDomain> consultar(DetalleReservaDomain datosFiltroDetalleReserva) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
