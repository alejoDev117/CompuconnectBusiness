package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.ReservaPerfilAssembler;
import co.edu.uco.compuconnect.business.business.ReservaPerfilBusiness;
import co.edu.uco.compuconnect.business.domain.ReservaPerfilDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.entities.ReservaPerfilEntity;

public class ReservaPerfilBusinessImp implements ReservaPerfilBusiness{
	
	private DAOFactory daoFactory;
	
	public ReservaPerfilBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void crear(ReservaPerfilDomain datosReservaPerfil) {
		final ReservaPerfilEntity entity = ReservaPerfilAssembler.getInsta().toEntityFromDomain(datosReservaPerfil);
		daoFactory.getReservaPerfilDAO().create(entity);
		
	}

	@Override
	public List<ReservaPerfilDomain> consultar(ReservaPerfilDomain datosFiltroReservaPerfil) {
		final ReservaPerfilEntity entity = ReservaPerfilAssembler.getInsta().toEntityFromDomain(datosFiltroReservaPerfil);
		final List<ReservaPerfilEntity> result = daoFactory.getReservaPerfilDAO().read(entity);
		return null;
	}

	@Override
	public void eliminar(ReservaPerfilDomain datosEliminacionReservaPerfil) {
		final ReservaPerfilEntity entity = ReservaPerfilAssembler.getInsta().toEntityFromDomain(datosEliminacionReservaPerfil);
		daoFactory.getReservaPerfilDAO().delete(entity);
		
		
		
	}

}
