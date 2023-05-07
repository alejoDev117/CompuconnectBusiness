package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.business.EstadoEquipoComputoBusiness;
import co.edu.uco.compuconnect.business.domain.EstadoEquipoComputoDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;

public final class EstadoEquipoComputoBusinessImp implements EstadoEquipoComputoBusiness{
	
	private DAOFactory daoFactory;

	public EstadoEquipoComputoBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<EstadoEquipoComputoDomain> consultar(EstadoEquipoComputoDomain datosFiltroEstadoEquipoComputo) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
