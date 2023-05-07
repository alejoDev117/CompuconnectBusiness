package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.business.ReservaBusiness;
import co.edu.uco.compuconnect.business.domain.ReservaDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;

public final class ReservaBusinessImp implements ReservaBusiness{
	
	private DAOFactory daoFactory;
	
	public ReservaBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void generar(ReservaDomain datosReserva) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(ReservaDomain datosModReserva) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelar(ReservaDomain datosEliminacionReserva) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ReservaDomain> consultar(ReservaDomain datosFiltroReserva) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
