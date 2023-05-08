package co.edu.uco.compuconnect.business.domain;

import java.util.UUID;

import co.edu.uco.compuconnect.crosscutting.utils.UtilMail;
import co.edu.uco.compuconnect.crosscutting.utils.UtilObject;
import co.edu.uco.compuconnect.crosscutting.utils.UtilText;
import co.edu.uco.compuconnect.crosscutting.utils.UtilUUID;

public class UsuarioDomain {
	
	protected UUID identificador;
	protected TipoUsuarioDomain tipoUsuario;
	protected String nombre;
	protected TipoIdentificacionDomain tipoIdentificacion;
	protected String identificacion;
	protected String correoInstitucional;
	protected static final UsuarioDomain DEAFAUL_OBJECT  = new UsuarioDomain();
	

	public UsuarioDomain(UUID identificador, TipoUsuarioDomain tipoUsuario, String nombre, TipoIdentificacionDomain tipoIdentificacion, String numeroIdentificacion, String correoInstitucional ) {
		setIdentificador(identificador);
		setTipoUsuario(tipoUsuario);
		setNombre(nombre);
		setTipoIdentificacion(tipoIdentificacion);
		setIdentificacion(numeroIdentificacion);
		setCorreoInstitucional(correoInstitucional);
		
	}
	
	protected  UsuarioDomain() {
		super();
		setIdentificador(UtilUUID.getDefaultUuid());
		setTipoUsuario(TipoUsuarioDomain.getDefaultObject());
		setNombre(UtilText.getDefaultValue());
		setTipoIdentificacion(TipoIdentificacionDomain.getDefaultObject());
		setIdentificacion(UtilText.getDefaultValue());
		setCorreoInstitucional(UtilMail.getDefaultValueMail());
		
	}
	
	
	
	
	
	public static final UsuarioDomain getDeafaulObject() {
		return DEAFAUL_OBJECT;
	}

	public TipoUsuarioDomain getTipoUsuario() {
		return tipoUsuario;
	}




	private final void setTipoUsuario(TipoUsuarioDomain tipoUsuario) {
		this.tipoUsuario = UtilObject.getDefault(tipoUsuario, TipoUsuarioDomain.getDefaultObject());
		
	}




	
	public UUID getIdentificador() {
		return identificador;
	}

	
	private void setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		
	}

	
	public String getCorreoInstitucional() {
		return correoInstitucional;
	}


	private void setCorreoInstitucional(String correoInstitucional) {
		this.correoInstitucional = UtilText.applyTrim(correoInstitucional);
		
	}

	
	public String getIdentificacion() {
		
		return identificacion;
	}

	
	private void setIdentificacion(String identificacion) {
		this.identificacion = UtilText.applyTrim(identificacion);
		
	}

	
	public TipoIdentificacionDomain getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	
	private void setTipoIdentificacion(TipoIdentificacionDomain tipoIdentificacion) {
		this.tipoIdentificacion = UtilObject.getDefault(tipoIdentificacion, TipoIdentificacionDomain.getDefaultObject());
	}
	


	public String getNombre() {
		return nombre;
	}

	
	private final void   setNombre(String nombre) {
		this.nombre = UtilText.applyTrim(nombre);
	
	}

	
}
