package co.edu.uco.compuconnect.business.domain;

import java.util.Date;
import java.util.UUID;

import co.edu.uco.compuconnect.crosscutting.utils.UtilDateTime;
import co.edu.uco.compuconnect.crosscutting.utils.UtilObject;
import co.edu.uco.compuconnect.crosscutting.utils.UtilText;
import co.edu.uco.compuconnect.crosscutting.utils.UtilUUID;

public final class SolicitudDomain{
	
	private static final SolicitudDomain DEFAULT_OBJECT = new SolicitudDomain();
	private UUID identificador;
	private UsuarioDomain autor;
	private TipoSolicitudDomain tipoSolicitud;
	private String descripcion;
	private Date horaCreacion;
	private EstadoSolicitudDomain estadoSolicitud;
	
	public SolicitudDomain(UUID identificador, UsuarioDomain autor, TipoSolicitudDomain tipoSolicitud, String descripcion, Date horaCreacion, EstadoSolicitudDomain estadoSolicitud) {
		setIdentificador(identificador);
		setAutor(autor);
		setTipoSolicitud(tipoSolicitud);
		setDescripcion(descripcion);
		setHoraCreacion(horaCreacion);
		setEstadoSolicitud(estadoSolicitud);
		
	}
	
	
	public SolicitudDomain() {
		super();
		setIdentificador(UtilUUID.getDefaultUuid());
		setAutor(UsuarioDomain.getDeafaulObject());
		setTipoSolicitud(TipoSolicitudDomain.getDefaultObject());
		setDescripcion(UtilText.getDefaultValue());
		setHoraCreacion(UtilDateTime.getDefaultValueDate());
		setEstadoSolicitud(EstadoSolicitudDomain.getDefaultObject());
		
	}
	
	



	public static final SolicitudDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}


	public UUID getIdentificador() {
		return identificador;
	}


	private final void  setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		
	}


	public UsuarioDomain getAutor() {
		return autor;
	}

	private final void  setAutor(UsuarioDomain autor) {
		this.autor = UtilObject.getDefault(autor, UsuarioDomain.getDeafaulObject());
		
	}

	
	public String getDescripcion() {
		return descripcion;
	}

	
	private final void  setDescripcion(String descripcion) {
		this.descripcion = UtilText.applyTrim(descripcion);
		
	}


	public Date getHoraCreacion() {
		return horaCreacion;
	}


	public final void setHoraCreacion(Date horaCreacion) {
		this.horaCreacion = UtilDateTime.getDefaultDate(horaCreacion);
		
	}

	public final TipoSolicitudDomain getTipoSolicitud() {
		return tipoSolicitud;
	}

	public final void setTipoSolicitud(TipoSolicitudDomain tipoSolicitud) {
		this.tipoSolicitud = UtilObject.getDefault(tipoSolicitud, TipoSolicitudDomain.getDefaultObject());

	}

	public final EstadoSolicitudDomain getEstadoSolicitud() {
		return estadoSolicitud;
	}

	public final void setEstadoSolicitud(EstadoSolicitudDomain estadoSolicitud) {
		this.estadoSolicitud = UtilObject.getDefault(estadoSolicitud, EstadoSolicitudDomain.getDefaultObject());
	
	}


	
}
