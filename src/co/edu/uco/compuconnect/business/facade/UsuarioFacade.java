package co.edu.uco.compuconnect.business.facade;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.UsuarioDomain;
import co.edu.uco.compuconnect.dto.UsuarioDTO;

public interface UsuarioFacade {

	void crear(UsuarioDTO dto);
	
	List<UsuarioDTO> consultar(UsuarioDTO dto);
	
	void eliminar(UsuarioDTO dto);
	
	void modificar(UsuarioDTO dto);
	
	
}
