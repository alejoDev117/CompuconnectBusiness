package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.business.TiempoFuncionamientoCentroInformaticaBusiness;
import co.edu.uco.compuconnect.business.domain.TiempoFuncionamientoCentroInformaticaDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;

public final class TiempoFuncionamientoCentroInformaticaBusinessImp implements TiempoFuncionamientoCentroInformaticaBusiness{
	
	private DAOFactory daoFactory;
	
	public TiempoFuncionamientoCentroInformaticaBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void crear(TiempoFuncionamientoCentroInformaticaDomain datosCreacionTiempoFuncionamientoCentroInformatica) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(
			TiempoFuncionamientoCentroInformaticaDomain datosBorradoTiempoFuncionamientoCentroInformatica) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TiempoFuncionamientoCentroInformaticaDomain> consultar(
			TiempoFuncionamientoCentroInformaticaDomain datosFiltroTiempoFuncionamientoCentroInformatica) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
