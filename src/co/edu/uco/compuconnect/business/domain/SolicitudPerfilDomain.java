package co.edu.uco.compuconnect.business.domain;

import java.util.UUID;

import co.edu.uco.compuconnect.crosscutting.utils.UtilObject;
import co.edu.uco.compuconnect.crosscutting.utils.UtilUUID;

public class SolicitudPerfilDomain {
	
	private static final SolicitudPerfilDomain DEFAULT_OBJECT = new SolicitudPerfilDomain();
	private UUID identificador;
	private SolicitudDomain solicitud;
	private PerfilDomain perfil;
	
	
	public SolicitudPerfilDomain(UUID identificador, SolicitudDomain solicitud, PerfilDomain perfil) {
		super();
		setIdentificador(identificador);
		setSolicitud(solicitud);
		setPerfil(perfil);
	}
	
	private SolicitudPerfilDomain() {
		super();
		setIdentificador(UtilUUID.getDefaultUuid());
		setSolicitud(SolicitudDomain.getDefaultObject());
		setPerfil(PerfilDomain.getDefaultObject());
	}
	
	public static final SolicitudPerfilDomain getDefaultObject() {
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
	public final PerfilDomain getPerfil() {
		return perfil;
	}
	private final void setPerfil(PerfilDomain perfil) {
		this.perfil = UtilObject.getDefault(perfil, PerfilDomain.getDefaultObject());
	}
	

}
