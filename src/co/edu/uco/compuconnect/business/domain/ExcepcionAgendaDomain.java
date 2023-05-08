package co.edu.uco.compuconnect.business.domain;

import java.time.LocalTime;
import java.util.Date;
import java.util.UUID;

import co.edu.uco.compuconnect.crosscutting.utils.UtilDateTime;
import co.edu.uco.compuconnect.crosscutting.utils.UtilObject;
import co.edu.uco.compuconnect.crosscutting.utils.UtilUUID;

public class ExcepcionAgendaDomain {
	
	private static final ExcepcionAgendaDomain DEFAULT_OBJECT = new ExcepcionAgendaDomain();
	private UUID identificador;
	private ExcepcionDomain excepcion;
	private AgendaDomain agenda;
	
	
	public ExcepcionAgendaDomain(UUID identificador, ExcepcionDomain excepcion, AgendaDomain agenda) {
		super();
		setIdentificador(identificador);
		setExcepcion(excepcion);
		setAgenda(agenda);
		
	}


	private ExcepcionAgendaDomain() {
		super();	
		setIdentificador(UtilUUID.getDefaultUuid());
		setExcepcion(ExcepcionDomain.getDefaultObject());
		setAgenda(AgendaDomain.getDefaultObject());
		
		
		
		
		}
	
	 
	
	public static final ExcepcionAgendaDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}


	public UUID getIdentificador() {
		return identificador;
	}
	
	private final void setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		
	}
	
	public ExcepcionDomain getExcepcion() {
		return excepcion;
	}
	
	private void setExcepcion(final ExcepcionDomain excepcion) {
		this.excepcion = UtilObject.getDefault(excepcion,ExcepcionDomain.getDefaultObject());
		
		
	}
	
	public AgendaDomain getAgenda() {
		return agenda;
	}
	
	private void setAgenda(final AgendaDomain agenda) {
		this.agenda = UtilObject.getDefault(agenda, AgendaDomain.getDefaultObject());
		
	}
	
	

}
