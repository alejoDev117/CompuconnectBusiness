package co.edu.uco.compuconnect.business.domain;

import java.util.Date;
import java.util.UUID;

import co.edu.uco.compuconnect.crosscutting.utils.UtilDateTime;
import co.edu.uco.compuconnect.crosscutting.utils.UtilObject;
import co.edu.uco.compuconnect.crosscutting.utils.UtilText;
import co.edu.uco.compuconnect.crosscutting.utils.UtilUUID;

public class RespuestaDomain {

	private static final RespuestaDomain DEFAULT_OBJECT = new RespuestaDomain();
	private UUID identificador;
	private CoordinadorDomain autor;
	private String observacion;
	private Date fecha;
	
	public RespuestaDomain(UUID identificador, CoordinadorDomain autor, String observacion, Date fecha) {
		super();
		setIdentificador(identificador);
		setAutor(autor);
		setObservacion(observacion);
		setFecha(fecha);
	}
	
	private RespuestaDomain() {
		super();
		setIdentificador(UtilUUID.getDefaultUuid());
		setAutor(CoordinadorDomain.getDefaultObject());
		setObservacion(UtilText.getDefaultValue());
		setFecha(UtilDateTime.getDefaultValueDate());
	}
	
	public static final RespuestaDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}
	
	public final UUID getIdentificador() {
		return identificador;
	}
	
	private final void setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	}
	
	public final CoordinadorDomain getAutor() {
		return autor;
	}
	
	private final void setAutor(CoordinadorDomain autor) {
		this.autor = UtilObject.getDefault(autor, CoordinadorDomain.getDefaultObject());
	}
	
	public final String getObservacion() {
		return observacion;
	}
	
	private final void setObservacion(String observacion) {
		this.observacion = UtilText.applyTrim(observacion);
	}
	
	public final Date getFecha() {
		return fecha;
	}
	
	private final void setFecha(Date fecha) {
		this.fecha = UtilDateTime.getDefaultDate(fecha);
	}
	
	
	
}
