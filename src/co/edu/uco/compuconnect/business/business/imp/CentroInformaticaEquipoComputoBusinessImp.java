package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.business.CentroInformaticaBusiness;
import co.edu.uco.compuconnect.business.domain.CentroInformaticaDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;

public class CentroInformaticaEquipoComputoBusinessImp implements CentroInformaticaBusiness{
	
	private DAOFactory daoFactory;
	
	public CentroInformaticaEquipoComputoBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void crear(CentroInformaticaDomain datosCentroInformatica) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CentroInformaticaDomain> consultar(CentroInformaticaDomain datosFiltroCentroInformatica) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificar(CentroInformaticaDomain datosModCentroInformatica) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(CentroInformaticaDomain identificadorEliminacionCentroInformatica) {
		// TODO Auto-generated method stub
		
	}

}
