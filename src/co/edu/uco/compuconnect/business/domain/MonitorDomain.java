package co.edu.uco.compuconnect.business.domain;

import java.util.UUID;

import co.edu.uco.compuconnect.crosscutting.utils.UtilMail;
import co.edu.uco.compuconnect.crosscutting.utils.UtilObject;
import co.edu.uco.compuconnect.crosscutting.utils.UtilText;
import co.edu.uco.compuconnect.crosscutting.utils.UtilUUID;
import co.edu.uco.compuconnect.dto.UsuarioDTO;

public final class MonitorDomain extends UsuarioDomain {
	
	private String numeroCelular;

	private static final MonitorDomain DEAFAULT_OBJECT = new MonitorDomain();
	
	public MonitorDomain(UUID identificador, String nombre, TipoIdentificacionDomain tipoIdentificacion, String numeroIdentificacion, String correoInstitucional, String numeroCelular, TipoUsuarioDomain tipoUsuario) {
		super();
		setIdentificador(identificador);
		setNombre(nombre);
		setTipoUsuario(tipoUsuario);
		setTipoIdentificacion(tipoIdentificacion);
		setIdentificacion(numeroIdentificacion);
		setCorreoInstitucional(correoInstitucional);
		setNumeroCelular(numeroCelular);
		
	}
	
	
	public MonitorDomain() {
		super();
		setIdentificador(UtilUUID.getDefaultUuid());
		setNombre(UtilText.getDefaultValue());
		setTipoUsuario(TipoUsuarioDomain.getDefaultObject());
		setTipoIdentificacion(TipoIdentificacionDomain.getDefaultObject());
		setIdentificacion(UtilText.getDefaultValue());
		setCorreoInstitucional(UtilMail.getDefaultValueMail());
		setNumeroCelular(UtilText.getDefaultValue());
		
	}
	

	
	
	
	public static final MonitorDomain getDeafaultObject() {
		return DEAFAULT_OBJECT;
	}


	public UUID getIdentificador() {
		return identificador;
	}

	
	private final void setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		
	}

	
	public String getCorreoInstitucional() {
		return correoInstitucional;
	}

	
	private final void  setCorreoInstitucional(String correoInstitucional) {
		this.correoInstitucional = UtilText.applyTrim(correoInstitucional);
		
	}

	
	public String getIdentificacion() {
		return identificacion;
	}

	
	private final void setIdentificacion(String identificacion) {
		this.identificacion = UtilText.applyTrim(identificacion);
		
	}

	
	public TipoIdentificacionDomain getTipoIdentificacion() {

		return tipoIdentificacion;
	}

	
	public final void  setTipoIdentificacion(TipoIdentificacionDomain tipoIdentificacion) {
		this.tipoIdentificacion = UtilObject.getDefault(tipoIdentificacion,TipoIdentificacionDomain.getDefaultObject());
		
	}

	public String getNombre() {
		return nombre;
	}

	
	private final void setNombre(String nombre) {
		this.nombre = UtilText.applyTrim(nombre);
		
	}


	public String getNumeroCelular() {
		return numeroCelular;
	}



	private final void  setNumeroCelular(String numeroCelular) {
		this.numeroCelular = UtilText.applyTrim(numeroCelular);
		
	}
	
	public final TipoUsuarioDomain getTipoUsuario() {
		return tipoUsuario;
	}
	
	private final void setTipoUsuario(TipoUsuarioDomain tipoUsuario) {
		this.tipoUsuario = UtilObject.getDefault(tipoUsuario, TipoUsuarioDomain.getDefaultObject());
	}


}
