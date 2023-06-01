package co.edu.uco.compuconnect.business.domain;

import java.util.Date;

import java.util.UUID;

import co.edu.uco.compuconnect.crosscutting.utils.UtilDateTime;
import co.edu.uco.compuconnect.crosscutting.utils.UtilObject;
import co.edu.uco.compuconnect.crosscutting.utils.UtilUUID;

public class NotificacionDomain {
	
	private static final NotificacionDomain DEFAULT_OBJECT = new NotificacionDomain();
	private UUID identificador;
	private ContenidoDomain contenido;
	private Date fecha;
	private TipoNotificacionDomain tipo;
	
	public NotificacionDomain(UUID identificador, ContenidoDomain contenido, Date fecha, TipoNotificacionDomain tipo) {
		super();
		setIdentificador(identificador);
		setContenido(contenido);
		setFecha(fecha);
		setTipo(tipo);
	}
	
	private NotificacionDomain() {
		super();
		setIdentificador(UtilUUID.getDefaultUuid());
		setContenido(ContenidoDomain.getDefaultObject());
		setFecha(UtilDateTime.getDefaultValueDate());
		setTipo(TipoNotificacionDomain.getDefaultObject());
	}
	
	public static final NotificacionDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}
	
	
	public final UUID getIdentificador() {
		return identificador;
	}
	private final void setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	}
	public final ContenidoDomain getContenido() {
		return contenido;
	}
	private final void setContenido(ContenidoDomain contenido) {
		this.contenido = UtilObject.getDefault(contenido, ContenidoDomain.getDefaultObject());
	}
	public final Date getFecha() {
		return fecha;
	}
	private final void setFecha(Date fecha) {
		this.fecha = UtilDateTime.getDefaultDate(fecha)
				;
	}
	public final TipoNotificacionDomain getTipo() {
		return tipo;
	}
	private final void setTipo(TipoNotificacionDomain tipo) {
		this.tipo = UtilObject.getDefault(tipo, TipoNotificacionDomain.getDefaultObject());
	}
	
	

}
