package co.edu.uco.compuconnect.business.domain;

import java.util.UUID;

import co.edu.uco.compuconnect.crosscutting.utils.UtilObject;
import co.edu.uco.compuconnect.crosscutting.utils.UtilUUID;

public class BuzonSolicitudDomain {
	
	private static final BuzonSolicitudDomain DEFAULT_OBJECT = new BuzonSolicitudDomain();
	private UUID identificador;
	private SolicitudDomain solicitud;
	private RespuestaDomain respuesta;
	
	public BuzonSolicitudDomain(UUID identificador, SolicitudDomain solicitud, RespuestaDomain respuesta) {
		super();
		setIdentificador(identificador);
		setSolicitud(solicitud);
		setRespuesta(respuesta);
	}
	
	private BuzonSolicitudDomain() {
		super();
		setIdentificador(UtilUUID.getDefault(identificador));
		setSolicitud(SolicitudDomain.getDefaultObject());
		setRespuesta(RespuestaDomain.getDefaultObject());
	}
	
	public static final BuzonSolicitudDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}
	
	public final UUID getIdentificador() {
		return identificador;
	}
	
	private final void setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	}
	
	public final SolicitudDomain getSolicitud() {
		return solicitud;
	}
	
	private final void setSolicitud(SolicitudDomain solicitud) {
		this.solicitud = UtilObject.getDefault(solicitud, SolicitudDomain.getDefaultObject());
	}
	
	public final RespuestaDomain getRespuesta() {
		return respuesta;
	}
	
	private final void setRespuesta(RespuestaDomain respuesta) {
		this.respuesta = UtilObject.getDefault(respuesta, RespuestaDomain.getDefaultObject());
	}
	
	

}
