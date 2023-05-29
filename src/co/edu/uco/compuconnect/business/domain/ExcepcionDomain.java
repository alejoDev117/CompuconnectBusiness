package co.edu.uco.compuconnect.business.domain;

import java.time.LocalTime;
import java.util.Date;
import java.util.UUID;

import co.edu.uco.compuconnect.crosscutting.utils.UtilDateTime;
import co.edu.uco.compuconnect.crosscutting.utils.UtilObject;
import co.edu.uco.compuconnect.crosscutting.utils.UtilText;
import co.edu.uco.compuconnect.crosscutting.utils.UtilUUID;

public class ExcepcionDomain {
	
	
	private static final ExcepcionDomain DEFAULT_OBJECT = new ExcepcionDomain();
	private UUID identificador;
	private Date fechaInicio;
	private Date fechaFin;
	private LocalTime horaInicio;
	private LocalTime horaFin;
	private FrecuenciaDomain frecuencia;
	private String motivo;
	
	public ExcepcionDomain(UUID identificador, Date fechaInicio, Date fechaFin, LocalTime horaInicio, LocalTime horaFin, FrecuenciaDomain frecuencia, String motivo) {
		super();
		setIdentificador(identificador);
		setFechaInicio(fechaInicio);
		setFechaFin(fechaFin);
		setHoraInicio(horaInicio);
		setHoraFin(horaFin);
		setFrecuencia(frecuencia);
		setMotivo(motivo);
		
	}


	private ExcepcionDomain() {
		super();	
		setIdentificador(UtilUUID.getDefaultUuid());
		setFechaInicio(UtilDateTime.getDefaultValueDate());
		setFechaFin(UtilDateTime.getDefaultValueDate());
		setHoraInicio(UtilDateTime.getDefaultValueLocaltime());
		setHoraFin(UtilDateTime.getDefaultValueLocaltime());
		setFrecuencia(FrecuenciaDomain.getDefaultObject());
		
		
		}
	
	
	
	public static final ExcepcionDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}


	public UUID getIdentificador() {
		return identificador;
	}
	
	private final void setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		
	}
	
	public Date getFechaInicio() {
		return fechaInicio;
	}
	
	private final void setFechaInicio(final Date fechaInicio) {
		this.fechaInicio = UtilDateTime.getDefaultDate(fechaInicio);
		
	}
	
	public Date getFechaFin() {
		return fechaFin;
	}
	
	
	private final void setFechaFin(final Date fechaFin) {
		this.fechaFin = UtilDateTime.getDefaultDate(fechaFin);
		
	}
	
	
	public LocalTime getHoraInicio() {
		return horaInicio;
	}
	
	private void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = UtilDateTime.getDefaultLocalTime(horaInicio);
		
	}
	
	public LocalTime getHoraFin() {
		return horaFin;
	}
	
	private void setHoraFin(LocalTime horaFin) {
		this.horaFin = UtilDateTime.getDefaultLocalTime(horaFin);
		
	}
	
	public FrecuenciaDomain getFrecuencia() {
		return frecuencia;
	}
	
	private void setFrecuencia(FrecuenciaDomain frecuencia) {
		this.frecuencia = UtilObject.getDefault(frecuencia, FrecuenciaDomain.getDefaultObject());
		
	}
	
	public String getMotivo() {
		return motivo;
	}
	
	private final void setMotivo(final String motivo) {
		this.motivo = UtilText.getUtilText().applyTrim(motivo);
	
	}
	
	
	
	

}
