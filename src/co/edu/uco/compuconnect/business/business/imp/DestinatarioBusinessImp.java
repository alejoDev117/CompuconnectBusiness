package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;



import co.edu.uco.compuconnect.business.assembler.concrete.DestinatarioAssembler;
import co.edu.uco.compuconnect.business.business.DestinatarioBusiness;
import co.edu.uco.compuconnect.business.domain.DestinatarioDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;

import co.edu.uco.compuconnect.entities.DestinatarioEntity;

public final class DestinatarioBusinessImp implements DestinatarioBusiness{
	
	private DAOFactory daoFactory;
	
	public DestinatarioBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void registrar(DestinatarioDomain datosRegistroDestinatario) {
		final DestinatarioEntity entity = DestinatarioAssembler.getInstance().toEntityFromDomain(datosRegistroDestinatario);
		daoFactory.getDestinatarioDAO().generate(entity);
		
	}

	@Override
	public void modificar(DestinatarioDomain datosModificacionDestintario) {
		final DestinatarioEntity entity = DestinatarioAssembler.getInstance().toEntityFromDomain(datosModificacionDestintario);
		daoFactory.getDestinatarioDAO().update(entity);

		
	}

	@Override
	public List<DestinatarioDomain> consultar(DestinatarioDomain datosFiltroDestinatario) {
		final DestinatarioEntity entity = DestinatarioAssembler.getInstance().toEntityFromDomain(datosFiltroDestinatario);
		List<DestinatarioEntity> resultEntityList = daoFactory.getDestinatarioDAO().read(entity);
		return DestinatarioAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
				
	}

	@Override
	public void eliminar(DestinatarioDomain datosEliminacionDestinatario) {
		final DestinatarioEntity entity = DestinatarioAssembler.getInstance().toEntityFromDomain(datosEliminacionDestinatario);
		daoFactory.getDestinatarioDAO().delete(entity);
		
	}
	
	
	

}
