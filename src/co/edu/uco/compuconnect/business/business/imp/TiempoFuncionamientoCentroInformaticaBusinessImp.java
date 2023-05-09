package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.TiempoFuncionamientoCentroInformaticaAssembler;
import co.edu.uco.compuconnect.business.business.TiempoFuncionamientoCentroInformaticaBusiness;
import co.edu.uco.compuconnect.business.domain.TiempoFuncionamientoCentroInformaticaDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.entities.TiempoFuncionamientoCentroInformaticaEntity;

public final class TiempoFuncionamientoCentroInformaticaBusinessImp implements TiempoFuncionamientoCentroInformaticaBusiness{
	
	private DAOFactory daoFactory;
	
	public TiempoFuncionamientoCentroInformaticaBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void crear(TiempoFuncionamientoCentroInformaticaDomain datosCreacionTiempoFuncionamientoCentroInformatica) {
		final TiempoFuncionamientoCentroInformaticaEntity entity = TiempoFuncionamientoCentroInformaticaAssembler.getInstance().toEntityFromDomain(datosCreacionTiempoFuncionamientoCentroInformatica);
		daoFactory.getTiempoFuncionamientoCentroInformaticaDAO().create(entity);
		
	}

	@Override
	public void eliminar(
			TiempoFuncionamientoCentroInformaticaDomain datosBorradoTiempoFuncionamientoCentroInformatica) {
		final TiempoFuncionamientoCentroInformaticaEntity entity = TiempoFuncionamientoCentroInformaticaAssembler.getInstance().toEntityFromDomain(datosBorradoTiempoFuncionamientoCentroInformatica);
		daoFactory.getTiempoFuncionamientoCentroInformaticaDAO().delete(entity);
		
	}

	@Override
	public List<TiempoFuncionamientoCentroInformaticaDomain> consultar(
			TiempoFuncionamientoCentroInformaticaDomain datosFiltroTiempoFuncionamientoCentroInformatica) {
		final TiempoFuncionamientoCentroInformaticaEntity entity = TiempoFuncionamientoCentroInformaticaAssembler.getInstance().toEntityFromDomain(datosFiltroTiempoFuncionamientoCentroInformatica);
		final List<TiempoFuncionamientoCentroInformaticaEntity> result = daoFactory.getTiempoFuncionamientoCentroInformaticaDAO().read(entity);
		return null;
	}
	
	
}
