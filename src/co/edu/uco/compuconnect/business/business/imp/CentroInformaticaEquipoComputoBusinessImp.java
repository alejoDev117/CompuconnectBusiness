package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.CentroInformaticaAssembler;
import co.edu.uco.compuconnect.business.assembler.concrete.CentroInformaticaEquipoComputoAssembler;
import co.edu.uco.compuconnect.business.business.CentroInformaticaBusiness;
import co.edu.uco.compuconnect.business.business.CentroInformaticaEquipoComputoBusiness;
import co.edu.uco.compuconnect.business.domain.CentroInformaticaDomain;
import co.edu.uco.compuconnect.business.domain.CentroInformaticaEquipoComputoDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.entities.CentroInformaticaEntity;
import co.edu.uco.compuconnect.entities.CentroInformaticaEquipoComputoEntity;

public class CentroInformaticaEquipoComputoBusinessImp implements CentroInformaticaEquipoComputoBusiness{
	
	private DAOFactory daoFactory;
	
	public CentroInformaticaEquipoComputoBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void crear(CentroInformaticaEquipoComputoDomain datosCentroInformaticaEquipoComputo) {
		final CentroInformaticaEquipoComputoEntity entity = CentroInformaticaEquipoComputoAssembler.getInstance().toEntityFromDomain(datosCentroInformaticaEquipoComputo);
	}

	@Override
	public List<CentroInformaticaEquipoComputoDomain> consultar(CentroInformaticaEquipoComputoDomain datosFiltroCentroInformaticaEquipoComputo) {
		final CentroInformaticaEquipoComputoEntity entity = CentroInformaticaEquipoComputoAssembler.getInstance().toEntityFromDomain(datosFiltroCentroInformaticaEquipoComputo);
		final List<CentroInformaticaEquipoComputoEntity> result = daoFactory.getCentroInformaticaEquipoComputoDAO().read(entity);
		return null;
	}

	@Override
	public void eliminar(CentroInformaticaEquipoComputoDomain datosEliminacionCentroInformaticaEquipoComputo) {
		final CentroInformaticaEquipoComputoEntity entity = CentroInformaticaEquipoComputoAssembler.getInstance().toEntityFromDomain(datosEliminacionCentroInformaticaEquipoComputo);
		daoFactory.getCentroInformaticaEquipoComputoDAO().delete(entity);
		
	}

	

}
