package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;
import java.util.UUID;

import co.edu.uco.compuconnect.business.assembler.concrete.CentroInformaticaAssembler;
import co.edu.uco.compuconnect.business.business.CentroInformaticaBusiness;
import co.edu.uco.compuconnect.business.domain.CentroInformaticaDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;

public final class CentroInformaticaBusinessImp implements CentroInformaticaBusiness{

	private DAOFactory daoFactory;
	
	public CentroInformaticaBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	@Override
	public final void crear(final CentroInformaticaDomain datosCentroInformatica) {
		daoFactory.getCentroInformaticaDAO().create(CentroInformaticaAssembler.getInstance().toEntityFromDomain(datosCentroInformatica));
		
		
	}

	@Override
	public final  List<CentroInformaticaDomain> consultar(final CentroInformaticaDomain identificador) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final void modificar(final CentroInformaticaDomain datosModCentroInformatica) {
		daoFactory.getCentroInformaticaDAO().update(CentroInformaticaAssembler.getInstance().toEntityFromDomain(datosModCentroInformatica));
		
	}

	@Override
	public final void eliminar(final CentroInformaticaDomain identificadorEliminacionCentroInformatica) {
		daoFactory.getCentroInformaticaDAO().delete(CentroInformaticaAssembler.getInstance().toEntityFromDomain(identificadorEliminacionCentroInformatica));
		
	}
	
	

}
