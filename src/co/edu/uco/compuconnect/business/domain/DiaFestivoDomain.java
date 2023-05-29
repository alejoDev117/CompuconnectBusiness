package co.edu.uco.compuconnect.business.domain;

import java.util.Date;
import java.util.UUID;

import co.edu.uco.compuconnect.crosscutting.utils.UtilDateTime;
import co.edu.uco.compuconnect.crosscutting.utils.UtilText;
import co.edu.uco.compuconnect.crosscutting.utils.UtilUUID;

public class DiaFestivoDomain {
	
	private static final DiaFestivoDomain DEFAULT_OBJECT = new DiaFestivoDomain();
	private UUID identificador;
	private String nombre;
	private Date fecha;
	
	
	public DiaFestivoDomain(UUID identificador, String nombre, Date fecha) {
		super();
		setIdentificador(identificador);
		setNombre(nombre);
		setFecha(fecha);
	}
	
	private  DiaFestivoDomain() { 
		super();
		setIdentificador(UtilUUID.getDefaultUuid());
		setNombre(UtilText.getUtilText().getDefaultValue());
		setFecha(UtilDateTime.getDefaultValueDate());
	}
	
	
	
	
	public static final DiaFestivoDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}
	
	

	public final UUID getIdentificador() {
		return identificador;
	}
	
	private final void setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);

	}
	public final String getNombre() {
		return nombre;
	}
	
	private final void setNombre(final String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre) ;
		
	}
	
	public final Date getFecha() {
		return fecha;
	}
	
	private final void setFecha(final Date fecha) {
		this.fecha = UtilDateTime.getDefaultDate(fecha);
	
	}
		
}

