package co.edu.uco.compuconnect.business.domain;

import java.util.UUID;

import co.edu.uco.compuconnect.crosscutting.utils.UtilObject;
import co.edu.uco.compuconnect.crosscutting.utils.UtilUUID;

public class DestinatarioNotificacionDomain {

	private static final DestinatarioNotificacionDomain DEFAULT_OBJECT = new DestinatarioNotificacionDomain();
	private UUID identificador;
	private DestinatarioDomain destinatario;
	private NotificacionDomain notificacion;
	private EstadoNotificacionDomain estado;
	
	
	public DestinatarioNotificacionDomain(UUID identificador, DestinatarioDomain destinatario, NotificacionDomain notificacion, EstadoNotificacionDomain estado) {
		super();
		setIdentificador(identificador);
		setDestinatario(destinatario);
		setNotificacion(notificacion);
		setEstado(estado);
	}
	
	private DestinatarioNotificacionDomain() {
		super();
		setIdentificador(UtilUUID.getDefaultUuid());
		setDestinatario(DestinatarioDomain.getDefaultObject());
		setNotificacion(NotificacionDomain.getDefaultObject());
		setEstado(EstadoNotificacionDomain.getDefaultObject());

	}
	
	public static final DestinatarioNotificacionDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}
	
	
	public final UUID getIdentificador() {
		return identificador;
	}
	
	private final void setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	}
	
	public final DestinatarioDomain getDestinatario() {
		return destinatario;
	}
	
	private final void setDestinatario(DestinatarioDomain destinatario) {
		this.destinatario = UtilObject.getDefault(destinatario, DestinatarioDomain.getDefaultObject());
	}
	
	public final NotificacionDomain getNotificacion() {
		return notificacion;
	}
	
	private final void setNotificacion(NotificacionDomain notificacion) {
		this.notificacion = UtilObject.getDefault(notificacion, NotificacionDomain.getDefaultObject());
	}
	
	public final EstadoNotificacionDomain getEstado() {
		return estado;
	}
	
	private final void setEstado(EstadoNotificacionDomain estado) {
		this.estado = UtilObject.getDefault(estado, EstadoNotificacionDomain.getDefaultObject());
	}
	
}
