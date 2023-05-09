package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.CoordinadorAssembler;
import co.edu.uco.compuconnect.business.business.CoordinadorBusiness;
import co.edu.uco.compuconnect.business.domain.CoordinadorDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.entities.CoordinadorEntity;

public final class CoordinadorBusinessImp implements CoordinadorBusiness{
	
	private DAOFactory daoFactory;
	
	public CoordinadorBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void registrar(CoordinadorDomain datosCoordinador) {
		final CoordinadorEntity entity = CoordinadorAssembler.getInstance().toEntityFromDomain(datosCoordinador);
		daoFactory.getCoordinadorDAO().create(entity);
		
	}

	@Override
	public void modificar(CoordinadorDomain datosActualizacionCoordinador) {
		final CoordinadorEntity entity = CoordinadorAssembler.getInstance().toEntityFromDomain(datosActualizacionCoordinador);
		daoFactory.getCoordinadorDAO().update(entity);
		
	}

	@Override
	public List<CoordinadorDomain> consultar(CoordinadorDomain datosFiltroCoordiandor) {
		final CoordinadorEntity entity = CoordinadorAssembler.getInstance().toEntityFromDomain(datosFiltroCoordiandor);
		final List<CoordinadorEntity> result = daoFactory.getCoordinadorDAO().read(entity);
		return null;
	}

	@Override
	public void eliminar(CoordinadorDomain datosEliminacionCoordinador) {
		final CoordinadorEntity entity = CoordinadorAssembler.getInstance().toEntityFromDomain(datosEliminacionCoordinador);
		daoFactory.getCoordinadorDAO().delete(entity);
		
	}
	
	

}
