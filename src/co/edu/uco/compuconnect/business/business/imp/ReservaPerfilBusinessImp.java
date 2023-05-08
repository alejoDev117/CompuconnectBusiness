package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.business.ReservaPerfilBusiness;
import co.edu.uco.compuconnect.business.domain.ReservaPerfilDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;

public class ReservaPerfilBusinessImp implements ReservaPerfilBusiness{
	
	private DAOFactory daoFactory;
	
	public ReservaPerfilBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void crear(ReservaPerfilDomain datosReservaPerfil) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ReservaPerfilDomain> consultar(ReservaPerfilDomain datosFiltroReservaPerfil) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(ReservaPerfilDomain datosEliminacionReservaPerfil) {
		// TODO Auto-generated method stub
		
	}

}
