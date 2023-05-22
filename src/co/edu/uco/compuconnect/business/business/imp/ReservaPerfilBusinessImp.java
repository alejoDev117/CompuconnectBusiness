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
		final ReservaPerfilEntity entity = ReservaPerfilAssembler.getInstance().toEntityFromDomain(datosReservaPerfil);
		daoFactory.getReservaPerfil().create(entity);
		
	}

	@Override
	public List<ReservaPerfilDomain> consultar(ReservaPerfilDomain datosFiltroReservaPerfil) {
		final ReservaPerfilEntity entity = ReservaPerfilAssembler.getInstance().toEntityFromDomain(datosFiltroReservaPerfil);
		final List<ReservaPerfilEntity> resultEntityList = daoFactory.getReservaPerfilDAO().read(entity);
		return ReservaPerfilAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}

	@Override
	public void eliminar(ReservaPerfilDomain datosEliminacionReservaPerfil) {
		final ReservaPerfilEntity entity = ReservaPerfilAssembler.getInstance().toEntityFromDomain(datosEliminacionReservaPerfil);
		daoFactory.getReservaPerfilDAO().delete(entity);
		
	}

}
