package co.edu.uco.compuconnect.business.facade;

import java.util.List;


import co.edu.uco.compuconnect.dto.DiaSemanalDTO;

public interface DiaSemanalFacade {

	List<DiaSemanalDTO> consultar(DiaSemanalDTO dto);
}
